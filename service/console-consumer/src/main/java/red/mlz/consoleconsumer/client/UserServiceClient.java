package red.mlz.consoleconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import red.mlz.module.utils.Response;

@FeignClient(name = "console")
public interface UserServiceClient {

    @RequestMapping("/user/login/web")
    Response loginWeb(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "password") String password);
}