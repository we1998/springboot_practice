package com.imooc.springbootstarter.Controller;

import com.imooc.springbootstarter.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author we
 * @date 2020/5/17 15:15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setName("老王");
        user.setAge(18);
        user.setPassword("imooc");
        user.setBirthday(new Date());
//        user.setDesc(null);
        return user;
    }


}
