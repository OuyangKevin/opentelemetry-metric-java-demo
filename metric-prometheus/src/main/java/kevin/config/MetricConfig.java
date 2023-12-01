package kevin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConfig {

    @Value("${prometheus.port}")
    private Integer prometheusPort;


    public Integer getPrometheusPort() {
        return prometheusPort;
    }
}
