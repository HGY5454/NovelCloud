package red.mlz.appconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import red.mlz.module.utils.Response;

@FeignClient(name = "app")
public interface UserServiceClient {

    @RequestMapping("/user/login/app")
    Response loginApp(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "password") String password);

    @RequestMapping("/user/register/app")
    Response registerApp(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "nick_name") String nickName,
            @RequestParam(name = "password") String password);
}