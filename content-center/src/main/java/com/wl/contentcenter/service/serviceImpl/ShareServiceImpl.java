package com.wl.contentcenter.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.wl.contentcenter.common.constant.ParameterConstant;
import com.wl.contentcenter.common.result.RestResult;
import com.wl.contentcenter.common.result.RestResultBuilder;
import com.wl.contentcenter.domain.dto.*;
import com.wl.contentcenter.domain.vo.MyShareVo;
import com.wl.contentcenter.entity.Share;
import com.wl.contentcenter.openFegin.UserFegin;
import com.wl.contentcenter.service.ShareService;
import com.wl.contentcenter.sqlUtil.repository.ShareRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.AsyncRestTemplate;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName: ShareServiceImpl @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/24 12:56:17  @Version: V1.0
 */
@Service
@Slf4j
public class ShareServiceImpl implements ShareService {
  @Resource private ShareRepository shareRepository;
  @Resource private RocketMQTemplate rocketMQTemplate;
  @Resource private AsyncRestTemplate asyncRestTemplate;
@Resource
private  UserFegin userFegin;
  @Override
  @Transactional(rollbackOn = RuntimeException.class)
  public RestResult contributeShare(ShareRequestDTO shareRequestDTO) {
    Share share = new Share();
    share.setUserId(shareRequestDTO.getUserId());
    share.setTitle(shareRequestDTO.getTitle());
    share.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
    share.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
    share.setIsOriginal(shareRequestDTO.getIsOriginal().byteValue());
    share.setAuthor(shareRequestDTO.getAuthor());
    share.setCover(shareRequestDTO.getCover());
    share.setSummary(shareRequestDTO.getSummary());
    share.setPrice(shareRequestDTO.getPrice());
    share.setDownloadUrl(shareRequestDTO.getDownloadUrl());
    share.setBuyCount(0);
    share.setShowFlag(ParameterConstant.IS_SHOW);
    share.setAuditStatus(ParameterConstant.AUDIT_STATUS_NOT_PASS);
    share.setReason("");
    shareRepository.save(share);
    return new RestResultBuilder<>().success();
  }

  @Override
  @Transactional(rollbackOn = RuntimeException.class)
  public RestResult editorShares(EditorSharesDto editorSharesDto) {
    shareRepository.editShares(editorSharesDto);
    return new RestResultBuilder<>().success();
  }

  @Override
  public List<MyShareVo> findMyShare(MyShareDto myShareDto) {
    List<MyShareVo> myShare = shareRepository.findMyShare(myShareDto);
    return myShare;
  }

  @Override
  public List<MyShareVo> findShare(MyShareDto myShareDto) {
    return shareRepository.findShare(myShareDto);
  }

  @Override
  public List<MyShareVo> searchKey(SearchDto searchDto) {
    return shareRepository.searchKey(searchDto);
  }

  /**
   * 一共以下几步 审核 更新帖子接口 其次 判断更新状态 通过 就加积分 并且 新增日志 不通过就不做下一步
   *
   * @param auditDto
   * @return
   */
  @Override
  @Transactional(rollbackOn = RuntimeException.class)
  public RestResult auditShare(AuditDto auditDto) {
    Optional<Share> optional = shareRepository.findById(auditDto.getShareId());
    Share share = optional.orElse(new Share());

    // 判断积分加减 这词通过
    if (auditDto.getAuditStatus().equals(ParameterConstant.AUDIT_STATUS_PASS)) {
      // 消息发送
      rocketMQTemplate.convertAndSend(
          "add-bonus", UserAddBonusDto.builder().bonus(50).userId(share.getUserId()).build());
    }

    long l = shareRepository.adminAudit(auditDto);
    return new RestResultBuilder<>().success();
  }

  @Override
  @Transactional(rollbackOn = RuntimeException.class)
  public RestResult auditShare1(AuditDto auditDto) {
    Optional<Share> optional = shareRepository.findById(auditDto.getShareId());
    Share share = optional.orElse(new Share());

    userFegin.AddBonus(UserAddBonusDto.builder().userId(share.getUserId()).bonus(50).build());
    return new RestResultBuilder<>().success();
  }

  @Override
  public RestResult auditShare2(AuditDto auditDto) {
    long startTime=System.currentTimeMillis();   //获取开始时间
    String url ="http://localhost:8083/users/add";
    Optional<Share> optional = shareRepository.findById(auditDto.getShareId());
    Share share = optional.orElse(new Share());
    //设置Header
    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add("Content-Type", "application/json;charset=UTF-8");
    UserAddBonusDto userAddBonusDto = UserAddBonusDto.builder().userId(share.getUserId()).bonus(50).build();
    HttpEntity<Object> httpEntity = new HttpEntity<>(userAddBonusDto,headers);
    ListenableFuture<ResponseEntity<Integer>> responseEntityListenableFuture = asyncRestTemplate.postForEntity(url, httpEntity, Integer.class);

    long endTime=System.currentTimeMillis(); //获取结束时间
    System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    return new RestResultBuilder<>().success();
  }

  @Override
  public RestResult auditShare3(AuditDto auditDto) {
    long startTime=System.currentTimeMillis();   //获取开始时间
    Optional<Share> optional = shareRepository.findById(auditDto.getShareId());
    Share share = optional.orElse(new Share());

    userFegin.AddBonus(UserAddBonusDto.builder().userId(share.getUserId()).bonus(50).build());
    try {
      Thread.sleep(10000);
      System.out.println("休眠结束");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long endTime=System.currentTimeMillis(); //获取结束时间
    System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    return new RestResultBuilder<>().success();
  }
}
