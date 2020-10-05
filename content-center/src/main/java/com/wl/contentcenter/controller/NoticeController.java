package com.wl.contentcenter.controller;

import com.wl.contentcenter.domain.vo.NoticeVo;
import com.wl.contentcenter.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: NoticeController @Description: TODO @Author: WangLinLIN @Date:
 * 2020/10/05 13:06:09  @Version: V1.0
 */
@RestController
@RequestMapping("/notice")
@Api(tags = "公告接口", value = "公告相关的Api")
public class NoticeController {
  @Resource private NoticeService noticeService;

  @GetMapping("/findLast")
  @ApiOperation(value = "公告", notes = "查询公告")
  public NoticeVo findLast() {
    return noticeService.findLatestNotice();
  }
}
