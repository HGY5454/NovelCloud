package red.mlz.appconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import red.mlz.appconsumer.client.HomeServiceFeign;


import java.util.Map;

@RestController
public class HomeConsumerController {

    @Autowired
    private HomeServiceFeign homeServiceFeign;

    @GetMapping("/home")
    public Map<String, Object> getHomeData() {
        return homeServiceFeign.getHomeData();
    }
}