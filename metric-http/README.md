# OpenTelemetry-metric-http
this example show how openTelemetry metric export with http server

# start application
The default port is 8085

```
http://127.0.0.1:8085/ping
```

# config
(1) please  use the right http endpoint 

(2) if you want to add prefix to all metric,you can set 
```
OtlpHttpMetricExporterBuilder add Header "metricNamespace"
```
for example if you set metricNamespace = ot, all you metric name will add "ot_" prefix