# OpenTelemetry-metric-http
this example show how openTelemetry metric export with http server

# start application
The default port is 8085

```
http://127.0.0.1:8085/ping
```

# config
(1) please  use the right http endpoint 
```
OtlpHttpMetricExporter.builder()
 .setAggregationTemporalitySelector(aggregationTemporalitySelector)
 .setEndpoint("******")
 .build()
```

(2) OpenTelemetry related clients does not have compression enabled by default. It is recommended to set the Compression parameter to gzip to reduce network transmission consumption
```
OtlpHttpMetricExporter.builder()
 .setAggregationTemporalitySelector(aggregationTemporalitySelector)
 .setEndpoint("******")
 .setCompression("gzip")
 .build()
```

(3) if you want to add prefix to all metric,you can add Header "metricNamespace"

```
OtlpHttpMetricExporter.builder()
  .setAggregationTemporalitySelector(aggregationTemporalitySelector)
  .setEndpoint("******")
  .setCompression("gzip")
  .addHeader("metricNamespace","ot")
   .build()
```
for example if you set metricNamespace = ot, all you metric name will add "ot_" prefix