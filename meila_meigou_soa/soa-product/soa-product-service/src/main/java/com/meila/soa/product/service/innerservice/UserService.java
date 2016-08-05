package com.meila.soa.product.service.innerservice;

import com.meila.soa.product.dal.entity.user.User;

/**
 * @author jamesp
 * 
 */
public interface UserService {

    // public User registerExtUser(String partner, String slug, String userName, String avatar,String extUserId)
    User registerExtUser(String partner, String slug, String userName, String avatar, String extUserId);

    /**
     * 管理员更新用户信息 （姓名，身份证号码， 店铺id)
     * 
     * @param user
     * @return
     */
    boolean updateByAdmin(User user);

    User selectUserByExtUserId(String extUserId);

    User load(Long ownerId);

    int insert(User record);

}
