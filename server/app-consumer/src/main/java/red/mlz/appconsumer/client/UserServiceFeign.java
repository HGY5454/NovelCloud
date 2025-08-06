package red.mlz.appconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import red.mlz.appconsumer.domain.user.UserLoginInfoVo;



@FeignClient(name = "app")
public interface UserServiceFeign {

    @RequestMapping("/user/login/app")
    UserLoginInfoVo loginApp(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "password") String password);

    @RequestMapping("/user/register/app")
    UserLoginInfoVo registerApp(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "nick_name") String nickName,
            @RequestParam(name = "password") String password);
}