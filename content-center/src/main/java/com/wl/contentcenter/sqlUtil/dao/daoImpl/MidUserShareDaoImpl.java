package com.wl.contentcenter.sqlUtil.dao.daoImpl;

import com.wl.contentcenter.entity.MidUserShare;
import com.wl.contentcenter.entity.QMidUserShare;
import com.wl.contentcenter.sqlUtil.dao.MidUserShareDao;
import com.wl.contentcenter.sqlUtil.util.BaseService;

/**
 * @ClassName: MidUserShareDaoImpl
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/10/14 15:49:42 
 * @Version: V1.0
 **/
public class MidUserShareDaoImpl extends BaseService implements MidUserShareDao {
    @Override
    public Boolean findMidUser(int userId, int shareId) {
        QMidUserShare qMidUserShare =QMidUserShare.midUserShare;
        MidUserShare midUserShare = queryFactory.select(qMidUserShare).from(qMidUserShare).where(
                qMidUserShare.shareId.eq(shareId)
                        .and(qMidUserShare.userId.eq(userId)))
                .fetchFirst();
        if (midUserShare==null){
            return false;
        }
        return true;
    }
}
