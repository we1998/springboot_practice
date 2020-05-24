package com.imooc.springbootstarter.Controller;

import com.imooc.springbootstarter.pojo.IMoocJSONResult;
import com.imooc.springbootstarter.pojo.SysUser;
import com.imooc.springbootstarter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author we
 * @date 2020/5/24 12:09
 */
@RestController
@RequestMapping("/mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;



    @RequestMapping("/queryUserListPaged")
    public IMoocJSONResult queryUserListPaged(Integer page) {

        if (page == null) {
            page = 1;
        }

        int pageSize = 10;

        SysUser user = new SysUser();
//		user.setNickname("lee");

        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

        return IMoocJSONResult.ok(userList);
    }
    @RequestMapping("/queryUserByCustom")
    public IMoocJSONResult queryUserByCustom(String id){
        SysUser user = userService.queryUserByIdCustom(id);
        return IMoocJSONResult.ok(user);
    }
}
