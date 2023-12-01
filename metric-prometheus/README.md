# opentelemetry-metric-prometheus
this example show how OpenTelemetry metric export as Prometheus works

# start application
The default port is 8086

```
http://127.0.0.1:8086/ping
```

# prometheus metric
The default port of Prometheus is 1000
```
http://127.0.0.1:1000
```
this is result example of this application's Prometheus metric
```
# TYPE target info
# HELP target Target metadata
target_info{service_name="openTelemetry-metric-prometheus",service_version="0.0.1",telemetry_sdk_language="java",telemetry_sdk_name="opentelemetry",telemetry_sdk_version="1.31.0"} 1
# TYPE ping_double_counter_total counter
# HELP ping_double_counter_total openTelemetry metric prometheus ping_double_counter
ping_double_counter_total{otel_scope_name="aliyun",zoneId="B"} 1.1 1701402365887
ping_double_counter_total{otel_scope_name="aliyun",zoneId="A"} 1.1 1701402365887
# TYPE ping_long_counter_total counter
# HELP ping_long_counter_total openTelemetry metric prometheus ping_long_counter
ping_long_counter_total{otel_scope_name="aliyun",regionId="cn-hangzhou"} 1.0 1701402365887
ping_long_counter_total{otel_scope_name="aliyun",regionId="cn-shanghai"} 2.0 1701402365887
# TYPE ping_long_histogram_milliseconds histogram
# HELP ping_long_histogram_milliseconds openTelemetry metric prometheus ping_long_histogram
ping_long_histogram_milliseconds_count{otel_scope_name="aliyun",regionId="cn-hangzhou"} 1.0 1701402365887
ping_long_histogram_milliseconds_sum{otel_scope_name="aliyun",regionId="cn-hangzhou"} 24.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="0.0"} 0.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="5.0"} 0.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="10.0"} 0.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="25.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="50.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="75.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="100.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="250.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="500.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="750.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="1000.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="2500.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="5000.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="7500.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="10000.0"} 1.0 1701402365887
ping_long_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="+Inf"} 1.0 1701402365887
# TYPE ping_double_histogram_milliseconds histogram
# HELP ping_double_histogram_milliseconds openTelemetry metric prometheus ping_double_histogram
ping_double_histogram_milliseconds_count{otel_scope_name="aliyun",regionId="cn-hangzhou"} 1.0 1701402365887
ping_double_histogram_milliseconds_sum{otel_scope_name="aliyun",regionId="cn-hangzhou"} 11.11 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="0.0"} 0.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="5.0"} 0.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="10.0"} 0.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="25.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="50.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="75.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="100.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="250.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="500.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="750.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="1000.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="2500.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="5000.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="7500.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="10000.0"} 1.0 1701402365887
ping_double_histogram_milliseconds_bucket{otel_scope_name="aliyun",regionId="cn-hangzhou",le="+Inf"} 1.0 1701402365887
```
