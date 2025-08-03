package red.mlz.consoleconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.mlz.consoleconsumer.client.UserServiceClient;
import red.mlz.module.utils.Response;

@RestController
public class UserConsumerController {

    @Autowired
    private UserServiceClient userServiceClient;

    @RequestMapping("/user/login/web")
    public Response loginWeb(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "password") String password) {
        return userServiceClient.loginWeb(phone, password);
    }
}