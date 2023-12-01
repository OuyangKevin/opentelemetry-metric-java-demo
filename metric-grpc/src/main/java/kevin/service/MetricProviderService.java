package kevin.service;

import io.opentelemetry.api.metrics.DoubleCounter;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.otlp.http.metrics.OtlpHttpMetricExporter;
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter;
import io.opentelemetry.sdk.metrics.*;
import io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.resources.Resource;
import kevin.common.MetricConstants;
import kevin.config.MetricConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

import static io.opentelemetry.semconv.resource.attributes.ResourceAttributes.SERVICE_NAME;
import static io.opentelemetry.semconv.resource.attributes.ResourceAttributes.SERVICE_VERSION;

@Service
public class MetricProviderService {

    @Autowired
    private MetricConfig metricConfig;
    /*********************************cumulative********************/
    private LongCounter longCumulativeCounter;
    private DoubleCounter doubleCumulativeCounter;

    private LongHistogram longCumulativeHistogram;
    private LongHistogram longCumulativeExponentialHistogram;
    /********************************** delta**********************/
    private LongCounter longDeltaCounter;
    private LongHistogram longDeltaHistogram;
    private LongHistogram longDeltaExponentialHistogram;

    /********************************** else **********************/


    @PostConstruct
    public  void init(){
        /*********************************cumulative********************/
        longCumulativeCounter = getMeterProvider(AggregationTemporalitySelector.alwaysCumulative(),Aggregation.sum(),InstrumentType.COUNTER)
                .get("aliyun")
                .counterBuilder("cumulative_long_counter")
                .setDescription("ot gRpc demo cumulative_long_counter")
                .build();


        doubleCumulativeCounter = getMeterProvider(AggregationTemporalitySelector.alwaysCumulative(),Aggregation.sum(),InstrumentType.COUNTER)
                .get("aliyun")
                .counterBuilder("cumulative_double_counter")
                .ofDoubles()
                .setDescription("ot gRpc demo cumulative_double_counter")
                .build();



        longCumulativeHistogram = getMeterProvider(AggregationTemporalitySelector.alwaysCumulative(),Aggregation.explicitBucketHistogram(),InstrumentType.HISTOGRAM)
                .get("aliyun")
                .histogramBuilder("cumulative_long_histogram")
                .ofLongs()
                .setDescription("ot gRpc demo cumulative_long_histogram")
                .setUnit("ms")
                .build();

        longCumulativeExponentialHistogram = getMeterProvider(AggregationTemporalitySelector.alwaysCumulative(),Aggregation.base2ExponentialBucketHistogram(),InstrumentType.HISTOGRAM)
                .get("aliyun")
                .histogramBuilder("cumulative_long_exponential_histogram")
                .ofLongs()
                .setDescription("ot gRpc demo cumulative_long_exponential_histogram")
                .setUnit("ms")
                .build();


        /********************************** delta**********************/
        longDeltaCounter = getMeterProvider(AggregationTemporalitySelector.deltaPreferred(),Aggregation.sum(),InstrumentType.COUNTER)
                 .get("aliyun")
                 .counterBuilder("delta_long_counter")
                 .setDescription("ot gRpc demo delta_long_counter")
                 .setUnit("s")
                 .build();

        longDeltaHistogram = getMeterProvider(AggregationTemporalitySelector.deltaPreferred(),Aggregation.explicitBucketHistogram(),InstrumentType.HISTOGRAM)
                .get("aliyun")
                .histogramBuilder("delta_long_histogram")
                .ofLongs()
                .setDescription("ot gRpc demo delta_long_histogram")
                .setUnit("ms")
                .build();


        longDeltaExponentialHistogram = getMeterProvider(AggregationTemporalitySelector.deltaPreferred(),Aggregation.base2ExponentialBucketHistogram(),InstrumentType.HISTOGRAM)
                .get("aliyun")
                .histogramBuilder("delta_long_exponential_histogram")
                .ofLongs()
                .setDescription("ot gRpc demo delta_long_exponential_histogram")
                .setUnit("ms")
                .build();
    }

    private MeterProvider getMeterProvider(AggregationTemporalitySelector aggregationTemporalitySelector, Aggregation aggregation, InstrumentType instrumentType){
        String endpoint = metricConfig.getOtelExporterOtlpEndpoint();
        String authentication = metricConfig.getOtelExporterOtlpAuthentication();

        ViewBuilder viewBuilder = View.builder().setAggregation(aggregation);
        Resource resource = Resource.getDefault().toBuilder()
                .put(SERVICE_NAME, "openTelemetry-metric-http")
                .put(SERVICE_VERSION, "0.0.1").build();

        return SdkMeterProvider.builder()
                .registerMetricReader(PeriodicMetricReader.builder(
                        OtlpGrpcMetricExporter.builder()
                                .setAggregationTemporalitySelector(aggregationTemporalitySelector)
                                .setEndpoint(endpoint)
                                .setCompression("gzip")
                                .addHeader(MetricConstants.AUTHENTICATION,authentication)
                                .build())
                        .setInterval(15, TimeUnit.SECONDS).build())
                .setResource(resource)
                .registerView(InstrumentSelector.builder().setType(instrumentType).build(),viewBuilder.build())
                .build();

    }

    public LongCounter getLongCumulativeCounter() {
        return longCumulativeCounter;
    }

    public DoubleCounter getDoubleCumulativeCounter() {
        return doubleCumulativeCounter;
    }

    public LongHistogram getLongCumulativeHistogram() {
        return longCumulativeHistogram;
    }

    public LongHistogram getLongCumulativeExponentialHistogram() {
        return longCumulativeExponentialHistogram;
    }

    public LongCounter getLongDeltaCounter() {
        return longDeltaCounter;
    }

    public LongHistogram getLongDeltaHistogram() {
        return longDeltaHistogram;
    }

    public LongHistogram getLongDeltaExponentialHistogram() {
        return longDeltaExponentialHistogram;
    }
}
