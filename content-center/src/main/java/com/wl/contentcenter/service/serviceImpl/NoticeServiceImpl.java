package com.wl.contentcenter.service.serviceImpl;

import com.wl.contentcenter.domain.vo.NoticeVo;
import com.wl.contentcenter.service.NoticeService;
import com.wl.contentcenter.sqlUtil.repository.NoticeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: NoticeServiceImpl @Description: TODO @Author: WangLinLIN @Date:
 * 2020/10/05 13:07:08  @Version: V1.0
 */
@Service
public class NoticeServiceImpl implements NoticeService {
  @Resource private NoticeRepository noticeRepository;

  @Override
  public NoticeVo findLatestNotice() {
    return noticeRepository.findNotice();
  }
}
