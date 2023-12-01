package kevin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConfig {

    @Value("${otel.exporter.otlp.endpoint}")
    private String otelExporterOtlpEndpoint;

    @Value("${otel.exporter.otlp.authentication}")
    private String otelExporterOtlpAuthentication;

    public String getOtelExporterOtlpEndpoint() {
        return otelExporterOtlpEndpoint;
    }

    public String getOtelExporterOtlpAuthentication() {
        return otelExporterOtlpAuthentication;
    }
}
