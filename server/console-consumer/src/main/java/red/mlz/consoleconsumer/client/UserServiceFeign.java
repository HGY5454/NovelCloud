package red.mlz.consoleconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import red.mlz.consoleconsumer.domian.user.UserInfoVo;
import red.mlz.module.utils.Response;

@FeignClient(name = "console")
public interface UserServiceFeign {

    @RequestMapping("/user/login/web")
    UserInfoVo loginWeb(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "password") String password);
}