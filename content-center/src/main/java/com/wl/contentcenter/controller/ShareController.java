package com.wl.contentcenter.controller;

import com.sun.xml.bind.v2.model.core.ID;
import com.wl.contentcenter.common.result.RestResult;
import com.wl.contentcenter.domain.dto.*;
import com.wl.contentcenter.domain.vo.MyShareVo;
import com.wl.contentcenter.domain.vo.UserShareVo;
import com.wl.contentcenter.openFegin.UserFegin;
import com.wl.contentcenter.service.ShareService;
import com.wl.contentcenter.userEntiy.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @ClassName: ShareController @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/24 13:20:04  @Version: V1.0
 */
@RestController
@RequestMapping("/shares")
@Api(tags = "分享接口", value = "分享相关的Api")
public class ShareController {
  @Resource private ShareService shareService;

  @Resource private RestTemplate restTemplate;

  @Resource private UserFegin userFegin;
  /**
   * 投稿接口
   *
   * @param shareRequestDTO
   * @return
   */
  @PostMapping("/contribute")
  @ApiOperation(value = "投稿", notes = "用户投稿")
  public RestResult contributeShare(@RequestBody ShareRequestDTO shareRequestDTO) {
    return shareService.contributeShare(shareRequestDTO);
  }

  /**
   * 编辑接口
   *
   * @param editorSharesDto
   * @return
   */
  @PostMapping("/editor/contribute")
  @ApiOperation(value = "编辑接口", notes = "用户编辑投稿内容")
  public RestResult editorsContribute(@RequestBody EditorSharesDto editorSharesDto) {
    return shareService.editorShares(editorSharesDto);
  }

  /***
   * 查询我的发表的分享
   * @param myShareDto
   * @return
   */
  @ApiOperation(value = "查询分享", notes = "查询我的发表的分享")
  @PostMapping("/my/contributions")
  public List<MyShareVo> findMyShare(@RequestBody MyShareDto myShareDto) {
    return shareService.findMyShare(myShareDto);
  }

  @PostMapping("/find/share")
  @ApiOperation(value = "查询分享", notes = "查询所有发表的分享")
  public List<MyShareVo> findShare(@RequestBody MyShareDto myShareDto) {
    return shareService.findShare(myShareDto);
  }

  @PostMapping("/search/share")
  @ApiOperation(value = "搜索分享", notes = "搜索指定关键字分享")
  public List<MyShareVo> searchShare(@RequestBody SearchDto searchDto) {
    return shareService.searchKey(searchDto);
  }

  @PostMapping("/find/userShare/{id}")
  @ApiIgnore
  public UserShareVo userShare(@PathVariable("id") Integer id, @RequestBody MyShareDto myShareDto) {
    //    User user = restTemplate.getForObject("http://user-center/users/me/"+id, User.class);
    User user = userFegin.getUser(id);
    List<MyShareVo> share = shareService.findShare(myShareDto);
    return UserShareVo.builder()
        .userId(user.getId())
        .userName(user.getWxNickname())
        .myShareVoList(share)
        .build();
  }

  /**
   *
   * 投稿审核
   * @param auditDto
   * @return
   */
  @PostMapping("/audit/share")
  @ApiOperation(value = "审核投稿", notes = "审核投稿 管理员接口")
  public RestResult auditShare(@RequestBody AuditDto auditDto) {
    return shareService.auditShare(auditDto);
  }

  /**
   *
   * 投稿审核
   * @param auditDto
   * @return
   */
  @PostMapping("/audit/share1")
  @ApiOperation(value = "审核投稿", notes = "审核投稿 管理员接口")
  public RestResult auditShare1(@RequestBody AuditDto auditDto) {
    return shareService.auditShare1(auditDto);
  }



  @PostMapping("/audit/share2")
  @ApiOperation(value = "审核投稿", notes = "审核投稿 管理员接口")
  public RestResult auditShare2(@RequestBody AuditDto auditDto) {
    return shareService.auditShare2(auditDto);
  }

  @PostMapping("/audit/share3")
  @ApiOperation(value = "审核投稿", notes = "审核投稿 管理员接口")
  public RestResult auditShare3(@RequestBody AuditDto auditDto) {
    return shareService.auditShare3(auditDto);
  }
}
