package com.wl.usercenter.dao.daoImpl;

import com.wl.usercenter.dao.UserDao;
import com.wl.usercenter.entity.QUser;
import com.wl.usercenter.util.BaseService;

/**
 * @ClassName: UserDaoImpl @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/24 11:16:12  @Version: V1.0
 */
public class UserDaoImpl extends BaseService implements UserDao {
  @Override
  public long findSize() {
    QUser qUser = QUser.user;
    return queryFactory.select(qUser.id.sum()).from(qUser).fetchCount();
  }
}
