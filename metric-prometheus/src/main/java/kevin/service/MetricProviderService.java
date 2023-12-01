package kevin.service;

import io.opentelemetry.api.metrics.DoubleCounter;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.exporter.prometheus.PrometheusHttpServer;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.resources.Resource;
import kevin.config.MetricConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static io.opentelemetry.semconv.resource.attributes.ResourceAttributes.SERVICE_NAME;
import static io.opentelemetry.semconv.resource.attributes.ResourceAttributes.SERVICE_VERSION;

@Service
public class MetricProviderService {

    @Autowired
    private MetricConfig metricConfig;

    /**
     * long counter
     */
    private LongCounter longCounter;

    /**
     * double counter
     */
    private DoubleCounter doubleCounter;


    /**
     * long Histogram
     */
    private LongHistogram longHistogram;

    /**
     * double Histogram
     */
    private DoubleHistogram doubleHistogram;

    @PostConstruct
    private void init() {
        PrometheusHttpServer prometheusHttpServer = PrometheusHttpServer.builder()
                .setPort(metricConfig.getPrometheusPort())
                .build();
        Resource resource = Resource.getDefault().toBuilder()
                .put(SERVICE_NAME, "openTelemetry-metric-prometheus")
                .put(SERVICE_VERSION, "0.0.1")
                .build();
        SdkMeterProvider sdkMeterProvider = SdkMeterProvider.builder()
                .registerMetricReader(prometheusHttpServer)
                .setResource(resource)
                .build();

        longCounter = sdkMeterProvider
                .get("aliyun")
                .counterBuilder("ping_long_counter")
                .setDescription("openTelemetry metric prometheus ping_long_counter")
                .build();

        doubleCounter = sdkMeterProvider
                .get("aliyun")
                .counterBuilder("ping_double_counter")
                .ofDoubles()
                .setDescription("openTelemetry metric prometheus ping_double_counter")
                .build();

        longHistogram = sdkMeterProvider
                .get("aliyun")
                .histogramBuilder("ping_long_histogram")
                .ofLongs()
                .setDescription("openTelemetry metric prometheus ping_long_histogram")
                .setUnit("ms")
                .build();

        doubleHistogram = sdkMeterProvider
                .get("aliyun")
                .histogramBuilder("ping_double_histogram")
                .setDescription("openTelemetry metric prometheus ping_double_histogram")
                .setUnit("ms")
                .build();

    }

    public LongCounter getLongCounter() {
        return longCounter;
    }

    public DoubleCounter getDoubleCounter() {
        return doubleCounter;
    }

    public LongHistogram getLongHistogram() {
        return longHistogram;
    }

    public DoubleHistogram getDoubleHistogram() {
        return doubleHistogram;
    }
}
