package red.mlz.appconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import red.mlz.appconsumer.client.SmsServiceFeign;

import java.math.BigInteger;

@RestController
public class SmsConsumerController {

    @Autowired
    private SmsServiceFeign smsServiceFeign;

    @RequestMapping(value = "/send")
    public String uploadFile(@RequestPart("file") BigInteger phone) {
        return smsServiceFeign.send(phone);
    }
}