package com.imooc.springbootstarter.Controller;

import com.imooc.springbootstarter.pojo.IMoocJSONResult;
import com.imooc.springbootstarter.pojo.SysUser;
import com.imooc.springbootstarter.pojo.User;

import com.imooc.springbootstarter.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;
    @Autowired
    private Sid sid;

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

    @RequestMapping("/saveUser")
    public IMoocJSONResult saveUser() throws Exception{

        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("lee"+new Date());
        user.setNickname("lee"+new Date());
        user.setPassword("123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public IMoocJSONResult updateUser()throws Exception{
        SysUser user = new SysUser();
        user.setId("1001001");
        user.setUsername("1001001update");
        user.setPassword("1001001update");

        userService.updateUser(user);
        return IMoocJSONResult.ok("修改成功");
    }


}
