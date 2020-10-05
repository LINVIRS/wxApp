package com.wl.contentcenter.sqlUtil.dao.daoImpl;

import com.querydsl.core.types.Projections;
import com.wl.contentcenter.common.constant.ParameterConstant;
import com.wl.contentcenter.domain.vo.NoticeVo;
import com.wl.contentcenter.entity.QNotice;
import com.wl.contentcenter.sqlUtil.dao.NoticeDao;
import com.wl.contentcenter.sqlUtil.util.BaseService;
import javafx.print.PaperSource;

/**
 * @ClassName: NoticeDaoImpl @Description: TODO @Author: WangLinLIN @Date:
 * 2020/10/05 12:57:10  @Version: V1.0
 */
public class NoticeDaoImpl extends BaseService implements NoticeDao {
  @Override
  public NoticeVo findNotice() {
    QNotice qNotice = QNotice.notice;
    return queryFactory
        .select(Projections.bean(NoticeVo.class,
                qNotice.content.as("content"),
                qNotice.createTime,
                qNotice.id,
                qNotice.showFlag))
        .from(qNotice)
        .where(qNotice.showFlag.eq(ParameterConstant.SHOW_FLAG))
        .orderBy(qNotice.createTime.desc())
        .fetchFirst();
  }
}
