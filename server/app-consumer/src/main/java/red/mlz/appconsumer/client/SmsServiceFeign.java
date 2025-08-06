package red.mlz.appconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import red.mlz.module.utils.Response;

import java.math.BigInteger;

@FeignClient(name = "app")
public interface SmsServiceFeign {

    @RequestMapping("/send")
    String send(@RequestParam(name = "phone") BigInteger phone);

    @RequestMapping("/creat_task")
    String creatTask(@RequestParam(name = "phone") BigInteger phone);
}