package com.wl.contentcenter.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName: MidUserShare
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/09/24 12:30:22 
 * @Version: V1.0
 **/
@Entity
@Table(name = "mid_user_share", schema = "content_center", catalog = "")
public class MidUserShare {
    private int id;
    private int shareId;
    private int userId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "share_id", nullable = false)
    public int getShareId() {
        return shareId;
    }

    public void setShareId(int shareId) {
        this.shareId = shareId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MidUserShare that = (MidUserShare) o;
        return id == that.id &&
                shareId == that.shareId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shareId, userId);
    }
}
