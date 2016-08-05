package com.meila.soa.product.dal.dao.user;

import java.util.List;

import com.meila.soa.product.dal.entity.user.User;
import com.meila.soa.product.dal.entity.user.UserExample;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByExtUserId(String extUserId);

    User loadByLoginname(String slug);
}
