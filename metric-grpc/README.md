# OpenTelemetry-metric-gRpc
this example show how openTelemetry metric export with gRpc server

# start application
The default port is 8083

```
http://127.0.0.1:8083/ping
```

# config
(1) please  use the right gRpc endpoint
```
OtlpGrpcMetricExporter.builder()
  .setEndpoint("******")
  .build()
```

(2) please  use the right user authentication,add add Header "Authentication"
```
OtlpGrpcMetricExporter.builder()
   .setEndpoint("******")
   .setCompression("gzip")
   .addHeader("Authentication","******")
   .build()
```
(3) if you want to add prefix to all metric,you can add Header "metricNamespace"
```
OtlpGrpcMetricExporter.builder()
   .setEndpoint("******")
   .setCompression("gzip")
   .addHeader("Authentication","******")
   .addHeader("metricNamespace","ot")
   .build()
```
for example if you set metricNamespace = ot, all you metric name will add "ot_" prefix