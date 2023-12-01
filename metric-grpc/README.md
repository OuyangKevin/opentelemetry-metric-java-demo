# opentelemetry-metric-http
this example show how opentelemetry metric export with gRpc server

# start application
The default port is 8083

```
http://127.0.0.1:8083/ping
```

# config
(1) please  use the right gRpc endpoint 
(2) please  use the right user authentication
```
OtlpGrpcMetricExporterBuilder add Header "Authentication"
```
(3) if you want to add prefix to all metric,you can set 
```
OtlpGrpcMetricExporterBuilder add Header "metricNamespace"
```
for example if you set metricNamespace = ot, all you metric name will add "ot_" prefix