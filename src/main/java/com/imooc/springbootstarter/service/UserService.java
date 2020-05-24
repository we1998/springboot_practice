package com.imooc.springbootstarter.service;

import com.imooc.springbootstarter.pojo.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author we
 * @date 2020/5/20 22:24
 */

public interface UserService {
    public void saveUser(SysUser user) throws Exception;

    public void updateUser(SysUser user);

    public void deleteUser(String userId);

    public SysUser queryUserById(String userId);

    public List<SysUser> queryUserList(SysUser user);

    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

    public SysUser queryUserByIdCustom(String userId);

    public void saveUserTransactional(SysUser user);
}
