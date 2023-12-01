package kevin.controller;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import kevin.service.MetricProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class MetricController {

    @Autowired
    private MetricProviderService metricProviderService;

    @GetMapping("/ping")
    public String ping(){
        long startTime = System.currentTimeMillis();
        try{
            metricProviderService.getLongCumulativeCounter().add(1,Attributes.of(AttributeKey.stringKey("regionId"),"cn-hangzhou"));
            metricProviderService.getLongCumulativeCounter().add(2,Attributes.of(AttributeKey.stringKey("regionId"),"cn-shanghai"));

            metricProviderService.getDoubleCumulativeCounter().add(1.1,Attributes.of(AttributeKey.stringKey("zoneId"),"A"));
            metricProviderService.getDoubleCumulativeCounter().add(1.1,Attributes.of(AttributeKey.stringKey("zoneId"),"B"));

            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(10));
        }catch (Throwable e){

        }finally {
            metricProviderService.getLongCumulativeHistogram().record(System.currentTimeMillis() - startTime,Attributes.of(AttributeKey.stringKey("regionId"),"cn-hangzhou"));
        }
        return "ping success!";
    }
}