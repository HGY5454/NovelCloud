package red.mlz.app.controller.user;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.mlz.app.annotations.VerifiedUser;


import red.mlz.app.domain.user.UserInfoVo;
import red.mlz.app.domain.user.UserLoginInfoVo;
import red.mlz.module.module.user.entity.User;
import red.mlz.module.module.user.service.UserService;
import red.mlz.module.utils.*;

import java.math.BigInteger;




@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/user/login/app")
    public UserLoginInfoVo loginApp(@VerifiedUser User loginUser,
                             @RequestParam(name = "phone") String phone,
                             @RequestParam(name = "password") String password) {
        if (!BaseUtils.isEmpty(loginUser)) {
            return null;
        }

        //合法用户直接登录
        boolean result = userService.login(phone, password);
        if (!result) {
            return null;
        }
        User user = userService.getUserByPhone(phone);

        userService.refreshUserLoginContext(user.getId(), BaseUtils.currentSeconds());

        UserInfoVo userInfo = new UserInfoVo();
        userInfo.setNickName(user.getNickName());
        userInfo.setPhone(user.getPhone());
        userInfo.setUserId(user.getId());

        UserLoginInfoVo loginInfo = new UserLoginInfoVo();
        loginInfo.setSign(SignUtils.makeSign(user.getId()));

        loginInfo.setUserInfo(userInfo);
        return loginInfo;
    }

    @RequestMapping("/user/register/app")
    public  UserLoginInfoVo registerApp(
                                @RequestParam(name = "phone") String phone,
                                @RequestParam(name = "nick_name") String nickName,
                                @RequestParam(name = "password") String password
    ) {
//        if (!BaseUtils.isEmpty(loginUser)) {
//            return new Response(4004);
//        }
        User user = userService.extractByPhone(phone);
        BigInteger newUserId;
        if(!BaseUtils.isEmpty(user)){
            //如果用户被禁止登录
            if(user.getIsDeleted().equals(1)){
                return null;
            }
            newUserId = user.getId();
            userService.refreshUserLoginContext(user.getId(), BaseUtils.currentSeconds());
        }else {
            try {
                newUserId = userService.registerUser(nickName, phone, password);
            } catch (Exception exception) {
                return null;
            }

        }
        user = userService.getById(newUserId);

        UserInfoVo userInfo = new UserInfoVo();
        userInfo.setNickName(user.getNickName());
        userInfo.setPhone(user.getPhone());
        userInfo.setUserId(user.getId());

        UserLoginInfoVo loginInfo = new UserLoginInfoVo();
        loginInfo.setSign(SignUtils.makeSign(user.getId()));

        loginInfo.setUserInfo(userInfo);
        return  loginInfo;
    }
}
