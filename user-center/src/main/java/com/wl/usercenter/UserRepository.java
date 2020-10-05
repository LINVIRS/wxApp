package com.wl.usercenter;

import com.wl.usercenter.dao.UserDao;
import com.wl.usercenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @interface: UserRepository
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/09/24 11:40:59 
 * @Version: V1.0
 **/
public interface UserRepository   extends JpaRepository<User,Integer>, UserDao {
}
