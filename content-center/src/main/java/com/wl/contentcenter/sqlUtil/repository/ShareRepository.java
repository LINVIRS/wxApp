package com.wl.contentcenter.sqlUtil.repository;

import com.wl.contentcenter.entity.Share;
import com.wl.contentcenter.sqlUtil.dao.SharesDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: ShareRepository @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/24 12:57:05  @Version: V1.0
 */
public interface ShareRepository extends JpaRepository<Share, Integer>, SharesDao {}
