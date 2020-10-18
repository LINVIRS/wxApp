package com.wl.contentcenter.sqlUtil.dao;

/**
 * @interface: MidUserShareDao
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/10/14 15:49:26 
 * @Version: V1.0
 **/
public interface MidUserShareDao {
    /**
     * 查询是否兑换
     * @param userId
     * @param shareId
     * @return
     */
    Boolean findMidUser(int userId, int shareId);


}
