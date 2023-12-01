package kevin.controller;

import kevin.service.MetricProviderService;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class MetricPrometheusController {

    @Autowired
    private MetricProviderService metricProviderService;

    @GetMapping("/ping")
    public String ping(){
         long startTime = System.currentTimeMillis();
         try{
             metricProviderService.getLongCounter().add(1,Attributes.of(AttributeKey.stringKey("regionId"),"cn-hangzhou"));
             metricProviderService.getLongCounter().add(2,Attributes.of(AttributeKey.stringKey("regionId"),"cn-shanghai"));
             metricProviderService.getDoubleCounter().add(1.1,Attributes.of(AttributeKey.stringKey("zoneId"),"A"));
             metricProviderService.getDoubleCounter().add(1.1,Attributes.of(AttributeKey.stringKey("zoneId"),"B"));
             TimeUnit.MILLISECONDS.sleep(new Random().nextInt(10));
         }catch (Throwable e){

         }finally {
             metricProviderService.getLongHistogram().record(System.currentTimeMillis() - startTime,Attributes.of(AttributeKey.stringKey("regionId"),"cn-hangzhou"));
             metricProviderService.getDoubleHistogram().record(11.11D,Attributes.of(AttributeKey.stringKey("regionId"),"cn-hangzhou"));
         }
         return "ping success!";
    }
}