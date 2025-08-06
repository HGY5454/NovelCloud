package red.mlz.consoleconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.mlz.consoleconsumer.client.UserServiceFeign;
import red.mlz.module.utils.Response;

@RestController
public class UserConsumerController {

    @Autowired
    private UserServiceFeign userServiceClient;

    @RequestMapping("/user/login/web")
    public Response loginWeb(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "password") String password) {
        if (userServiceClient.loginWeb(phone, password) == null) {
            return new Response<>(4004);
        }
        return new Response<>(1001,userServiceClient.loginWeb(phone, password));
    }
}