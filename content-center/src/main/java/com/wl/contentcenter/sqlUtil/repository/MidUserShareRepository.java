package com.wl.contentcenter.sqlUtil.repository;

import com.wl.contentcenter.entity.MidUserShare;
import com.wl.contentcenter.sqlUtil.dao.MidUserShareDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @interface: MidUserShareRepository
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/10/14 16:01:03 
 * @Version: V1.0
 **/
public interface MidUserShareRepository  extends JpaRepository<MidUserShare,Integer>, MidUserShareDao {
}
