package com.wl.contentcenter.sqlUtil.dao.daoImpl;

import com.querydsl.core.types.Projections;
import com.wl.contentcenter.common.constant.ParameterConstant;
import com.wl.contentcenter.common.result.RestResult;
import com.wl.contentcenter.domain.dto.*;
import com.wl.contentcenter.domain.vo.MyShareVo;
import com.wl.contentcenter.entity.QMidUserShare;
import com.wl.contentcenter.entity.QShare;
import com.wl.contentcenter.entity.Share;
import com.wl.contentcenter.sqlUtil.dao.SharesDao;
import com.wl.contentcenter.sqlUtil.util.BaseService;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Queue;

/**
 * @ClassName: ShareDaoImpl @Description: TODO @Author: WangLinLIN @Date:
 * 2020/09/24 12:44:38  @Version: V1.0
 */
public class SharesDaoImpl extends BaseService implements SharesDao {
  @Override
  public long editShares(EditorSharesDto editorSharesDto) {
    QShare qShare = QShare.share;
    return queryFactory
        .update(qShare)
        .set(qShare.downloadUrl, editorSharesDto.getDownloadUrl())
        .set(qShare.isOriginal, editorSharesDto.getIsOriginal().byteValue())
        .set(qShare.summary, editorSharesDto.getSummary())
        .set(qShare.cover, editorSharesDto.getCover())
        .set(qShare.price, editorSharesDto.getPrice())
        .set(qShare.title, editorSharesDto.getTitle())
        .where(qShare.id.eq(editorSharesDto.getId()))
        .execute();
  }

  @Override
  public List<MyShareVo> findMyShare(MyShareDto myShareDto) {
    QShare qShare = QShare.share;
    QMidUserShare qMidUserShare = QMidUserShare.midUserShare;
    return queryFactory
        .select(
            Projections.bean(
                MyShareVo.class,
                qShare.author.as("author"),
                qShare.downloadUrl.as("downloadUrl"),
                qShare.isOriginal.as("isOriginal"),
                qShare.price.as("price"),
                qShare.summary.as("summary"),
                qShare.title.as("title"),
                qShare.cover.as("cover")))
        .from(qShare)
        .rightJoin(qMidUserShare)
        .on(qShare.id.eq(qMidUserShare.shareId))
        .where(
            qShare
                .userId
                .eq(myShareDto.getUserId())
                .and(qShare.showFlag.eq(ParameterConstant.IS_SHOW))
                .and(qShare.auditStatus.eq(ParameterConstant.AUDIT_STATUS_NOT_PASS)))
        .offset(myShareDto.getPageIndex() * myShareDto.getPageSize())
        .limit(myShareDto.getPageSize())
        .orderBy(qShare.updateTime.desc())
        .fetch();
  }

  @Override
  public List<MyShareVo> findMyDuiHuan(MyShareDto myShareDto) {
    QShare qShare =QShare.share;
    QMidUserShare qMidUserShare =QMidUserShare.midUserShare;
    return  queryFactory.select( Projections.bean(
            MyShareVo.class,
            qShare.id.as("id"),
            qShare.author.as("author"),
            qShare.downloadUrl.as("downloadUrl"),
            qShare.isOriginal.as("isOriginal"),
            qShare.price.as("price"),
            qShare.summary.as("summary"),
            qShare.title.as("title"),
            qShare.cover.as("cover"))).from(qShare)
           .rightJoin(qMidUserShare).on(qShare.id.eq(qMidUserShare.shareId))
            .where(qMidUserShare.userId.eq(myShareDto.getUserId()))
            .offset(myShareDto.getPageIndex()*myShareDto.getPageSize())
            .limit(myShareDto.getPageSize())
            .orderBy(qShare.createTime.desc())
           .fetch();


  }

  @Override
  public List<MyShareVo> findShare(MyShareDto myShareDto) {
    QShare qShare = QShare.share;
    return queryFactory
        .select(
            Projections.bean(
                MyShareVo.class,
                qShare.author.as("author"),
                qShare.downloadUrl.as("downloadUrl"),
                qShare.isOriginal.as("isOriginal"),
                qShare.price.as("price"),
                qShare.summary.as("summary"),
                qShare.title.as("title"),
                qShare.cover.as("cover"),
                    qShare.id.as("id")))
        .from(qShare)
        .where(
            qShare
                .showFlag
                .eq(ParameterConstant.IS_SHOW)
                .and(qShare.auditStatus.eq(ParameterConstant.AUDIT_STATUS_PASS)))
        .offset(myShareDto.getPageIndex() * myShareDto.getPageSize())
        .limit(myShareDto.getPageSize())
        .orderBy(qShare.buyCount.desc(), qShare.createTime.desc())
        .fetch();
  }

  @Override
  public List<MyShareVo> searchKey(SearchDto searchDto) {
    QShare qShare = QShare.share;
    return queryFactory
        .select(
            Projections.bean(
                MyShareVo.class,
                qShare.author.as("author"),
                qShare.downloadUrl.as("downloadUrl"),
                qShare.isOriginal.as("isOriginal"),
                qShare.price.as("price"),
                qShare.summary.as("summary"),
                qShare.title.as("title"),
                qShare.cover.as("cover")))
        .from(qShare)
        .where(
            qShare
                .author
                .contains(searchDto.getSearchKey())
                .or(qShare.summary.contains(searchDto.getSearchKey()))
                .or(qShare.title.contains(searchDto.getSearchKey()))
                .and(qShare.auditStatus.eq(ParameterConstant.AUDIT_STATUS_PASS))
                .and(qShare.showFlag.eq(ParameterConstant.IS_SHOW)))
        .offset(searchDto.getPageIndex() *searchDto.getPageSize())
        .limit( searchDto.getPageSize())
        .orderBy(qShare.updateTime.desc(), qShare.buyCount.desc())
        .fetch();
  }

  @Override
  public long adminAudit(AuditDto auditDto) {
    QShare qShare = QShare.share;
    return queryFactory
        .update(qShare)
        .set(qShare.reason, auditDto.getReason())
        .set(qShare.auditStatus, auditDto.getAuditStatus())
        .where(qShare.id.eq(auditDto.getShareId()))
        .execute();
  }
}
