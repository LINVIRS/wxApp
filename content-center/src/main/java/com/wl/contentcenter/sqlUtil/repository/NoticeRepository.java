package com.wl.contentcenter.sqlUtil.repository;

import com.wl.contentcenter.entity.Notice;
import com.wl.contentcenter.sqlUtil.dao.NoticeDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @interface: NoticeRepository
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/10/05 12:57:52 
 * @Version: V1.0
 **/
public interface NoticeRepository extends JpaRepository<Notice,Integer>, NoticeDao {
}
