package red.mlz.appconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name = "app")
public interface HomeServiceFeign {
    @RequestMapping("/home")
    Map<String, Object> getHomeData();
}
