package com.wl.contentcenter.service.serviceImpl;

import com.wl.contentcenter.common.constant.ParameterConstant;
import com.wl.contentcenter.common.result.RestResult;
import com.wl.contentcenter.common.result.RestResultBuilder;
import com.wl.contentcenter.domain.dto.EditorSharesDto;
import com.wl.contentcenter.domain.dto.MyShareDto;
import com.wl.contentcenter.domain.dto.SearchDto;
import com.wl.contentcenter.domain.dto.ShareRequestDTO;
import com.wl.contentcenter.domain.vo.MyShareVo;
import com.wl.contentcenter.entity.Share;
import com.wl.contentcenter.service.ShareService;
import com.wl.contentcenter.sqlUtil.repository.ShareRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName: ShareServiceImpl @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/24 12:56:17  @Version: V1.0
 */
@Service
public class ShareServiceImpl implements ShareService {
  @Resource private ShareRepository shareRepository;

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
}
