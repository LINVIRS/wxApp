package com.wl.contentcenter.service;

import com.wl.contentcenter.common.result.RestResult;
import com.wl.contentcenter.domain.dto.*;
import com.wl.contentcenter.domain.vo.MyShareVo;
import com.wl.contentcenter.domain.vo.ShareInfo;

import java.util.List;

/**
 * @ClassName: ShareService @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/24 12:55:05  @Version: V1.0
 */
public interface ShareService {
  /**
   * 投稿分享
   *
   * @param shareRequestDTO
   * @return
   */
  RestResult contributeShare(ShareRequestDTO shareRequestDTO);

  /**
   * 编辑分享
   *
   * @param editorSharesDto
   * @return
   */
  RestResult editorShares(EditorSharesDto editorSharesDto);

  /**
   * 查询我的分享
   *
   * @param myShareDto
   * @return
   */
  List<MyShareVo> findMyShare(MyShareDto myShareDto);

  /**
   * 发现接口
   *
   * @param myShareDto
   * @return
   */
  List<MyShareVo> findShare(MyShareDto myShareDto,Integer userId);

  /**
   * 搜索接口
   *
   * @param searchDto
   * @return
   */
  List<MyShareVo> searchKey(SearchDto searchDto);

  /**
   * 查找我的兑换
   * @param searchDto
   * @return
   */
  List<MyShareVo> findMyDuiHuan(MyShareDto myShareDto);
  /**
   * 审核帖子
   * 管理员接口
   * @param auditDto
   * @return
   */
  RestResult auditShare(AuditDto auditDto);
  /**
   * 审核帖子
   * 管理员接口
   * @param auditDto
   * @return
   */
  RestResult auditShare1(AuditDto auditDto);


  /**
   * 审核帖子
   * 管理员接口
   * @param auditDto
   * @return
   */
  RestResult auditShare2(AuditDto auditDto);



  /**
   * 审核帖子
   * 管理员接口
   * @param auditDto
   * @return
   */
  RestResult auditShare3(AuditDto auditDto);

  /**
   * 根据id查找shareId
   * @param ShareId
   * @return
   */
  ShareInfo findShareById(Integer ShareId);

}
