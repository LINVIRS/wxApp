package com.wl.contentcenter.service;

import com.wl.contentcenter.domain.vo.NoticeVo;

/**
 * @interface: NoticeService @Description: TODO @Author: WangLinLIN @Date:
 *     2020/10/05 13:06:54  @Version: V1.0
 */
public interface NoticeService {

  /**
   * 查询最新一条公告
   *
   * @return
   */
  NoticeVo findLatestNotice();
}
