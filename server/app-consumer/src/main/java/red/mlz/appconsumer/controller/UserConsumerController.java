package red.mlz.appconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import red.mlz.appconsumer.client.UserServiceFeign;
import red.mlz.module.utils.Response;

@RestController
public class UserConsumerController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @RequestMapping("/user/login/app")
    public Response loginApp(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "password") String password) {
        if (userServiceFeign.loginApp(phone, password) == null){
            return new Response<>(4004);
        }else {
            return new Response<>(1001,userServiceFeign.loginApp(phone, password));
        }
    }

    @RequestMapping("/user/register/app")
    public Response registerApp(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "nick_name") String nickName,
            @RequestParam(name = "password") String password) {
        if (userServiceFeign.registerApp(phone, nickName, password) == null){
            return new Response<>(4004);
        }else {
            return new Response<>(1001,userServiceFeign.registerApp(phone, nickName, password));
        }
    }
}