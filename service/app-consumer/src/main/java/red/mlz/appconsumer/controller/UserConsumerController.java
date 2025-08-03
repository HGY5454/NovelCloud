package red.mlz.appconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.mlz.appconsumer.client.UserServiceClient;
import red.mlz.module.utils.Response;

@RestController
public class UserConsumerController {

    @Autowired
    private UserServiceClient userServiceClient;

    @RequestMapping("/user/login/app")
    public Response loginApp(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "password") String password) {
        return userServiceClient.loginApp(phone, password);
    }

    @RequestMapping("/user/register/app")
    public Response registerApp(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "nick_name") String nickName,
            @RequestParam(name = "password") String password) {
        return userServiceClient.registerApp(phone, nickName, password);
    }
}