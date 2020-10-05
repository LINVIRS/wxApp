package com.wl.contentcenter.sqlUtil.dao;

import com.wl.contentcenter.domain.vo.NoticeVo;

/**
 * @interface: NoticeDao @Description: TODO @Author: WangLinLIN @Date:
 *     2020/10/05 12:54:43  @Version: V1.0
 */
public interface NoticeDao {
  /**
   * 查询最新一条公告
   * @return
   */
  NoticeVo findNotice();
}
