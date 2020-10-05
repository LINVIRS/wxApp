package com.wl.contentcenter.service;

import com.wl.contentcenter.common.result.RestResult;
import com.wl.contentcenter.domain.dto.EditorSharesDto;
import com.wl.contentcenter.domain.dto.MyShareDto;
import com.wl.contentcenter.domain.dto.SearchDto;
import com.wl.contentcenter.domain.dto.ShareRequestDTO;
import com.wl.contentcenter.domain.vo.MyShareVo;

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
  List<MyShareVo> findShare(MyShareDto myShareDto);

  /**
   * 搜索接口
   *
   * @param searchDto
   * @return
   */
  List<MyShareVo> searchKey(SearchDto searchDto);
}
