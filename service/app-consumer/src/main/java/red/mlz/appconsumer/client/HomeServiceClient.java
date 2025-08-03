package red.mlz.appconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import red.mlz.module.utils.Response;

import java.util.Map;

@FeignClient(name = "app")
public interface HomeServiceClient {

    @GetMapping("/home")
    Response getHomeData();
}