package com.imooc.springbootstarter.mapper;


import com.imooc.springbootstarter.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapperCustom{
    List<SysUser> queryUserSimplyInfoById(String id);
}