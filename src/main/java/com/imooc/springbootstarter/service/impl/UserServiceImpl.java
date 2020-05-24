package com.imooc.springbootstarter.service.impl;

import com.github.pagehelper.PageHelper;
import com.imooc.springbootstarter.mapper.SysUserMapper;
import com.imooc.springbootstarter.mapper.SysUserMapperCustom;
import com.imooc.springbootstarter.pojo.SysUser;
import com.imooc.springbootstarter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author we
 * @date 2020/5/20 22:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserMapperCustom sysUserMapperCustom;

    @Override
    public void saveUser(SysUser user) throws Exception {
        sysUserMapper.insert(user);
    }

    @Override
    public void updateUser(SysUser user) {
        //.updateByPrimaryKey没值的字段用null覆盖
        //sysUserMapper.updateByPrimaryKey(user);

        //updateByPrimaryKeySelective修改有值的字段
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public SysUser queryUserById(String userId) {
        return null;
    }

    @Override
    public List<SysUser> queryUserList(SysUser user) {
        return null;
    }

    @Override
    @Transactional
    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
        //开始分页
        PageHelper.startPage(page,pageSize);

        Example example = new Example(SysUser.class);
        Example.Criteria criteria=example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())){
            criteria.andLike("nickname","%"+user.getNickname()+"%");
        }
        example.orderBy("registTime").desc();
        List<SysUser> users = sysUserMapper.selectByExample(example);
        return users;
    }

    @Override
    public SysUser queryUserByIdCustom(String userId) {

        List<SysUser> list =sysUserMapperCustom.queryUserSimplyInfoById(userId);
        if (list!=null&&!list.isEmpty()){
            return (SysUser)list.get(0);
        }
        return null;
    }

    @Override
    public void saveUserTransactional(SysUser user) {

    }
}
