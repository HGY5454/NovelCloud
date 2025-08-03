package red.mlz.appconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import red.mlz.appconsumer.client.HomeServiceClient;
import red.mlz.module.utils.Response;

@RestController
public class HomeConsumerController {

    @Autowired
    private HomeServiceClient homeServiceClient;

    @GetMapping("/home")
    public Response getHomeData() {
        return homeServiceClient.getHomeData();
    }
}