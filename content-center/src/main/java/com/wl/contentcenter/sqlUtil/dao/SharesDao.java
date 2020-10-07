package com.wl.contentcenter.sqlUtil.dao;

import com.wl.contentcenter.common.result.RestResult;
import com.wl.contentcenter.domain.dto.*;
import com.wl.contentcenter.domain.vo.MyShareVo;

import java.util.List;

/**
 * @ClassName: SharesDao @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/24 12:43:23  @Version: V1.0
 */
public interface SharesDao {
  /**
   * 编辑分析
   *
   * @param editorSharesDto
   * @return
   */
  long editShares(EditorSharesDto editorSharesDto);

  /**
   * 分页查询我的分享
   *
   * @param myShareDto
   * @return
   */
  List<MyShareVo> findMyShare(MyShareDto myShareDto);

  /**
   * 查询分享
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

  /**
   * 审核接口
   * @param auditDto
   * @return
   */
  long  adminAudit(AuditDto auditDto);
}
