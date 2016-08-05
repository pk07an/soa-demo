package com.meila.soa.product.service.innerservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meila.soa.product.dal.dao.user.UserMapper;
import com.meila.soa.product.dal.entity.user.User;
import com.meila.soa.product.service.innerservice.UserService;

@Service("userService")
// service已在applicationContext-service.xml中定义
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User registerExtUser(String partner, String slug, String userName, String avatar, String extUserId) {

        // String loginname = extUserId + "@" + partner;
        User u = userMapper.loadByLoginname(slug);
        if (u != null) {
            return u;
        }
        User user = new User();
        user.setLoginname(slug);
        user.setName(userName);
        user.setAvatar(avatar);
        user.setPartner(partner);
        user.setExtUserId(extUserId);
        user.setCode(slug);
        this.insert(user);

        user.setId(Long.parseLong(extUserId));
        return user;

    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public boolean updateByAdmin(User user) {
        return userMapper.updateByPrimaryKeySelective(user) > 0;

    }

    @Override
    public User selectUserByExtUserId(String extUserId) {
        return userMapper.selectUserByExtUserId(extUserId);

    }

    @Override
    public User load(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
