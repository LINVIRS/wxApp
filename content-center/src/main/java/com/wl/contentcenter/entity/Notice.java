package com.wl.contentcenter.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: Notice
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/09/24 12:30:22 
 * @Version: V1.0
 **/
@Entity
public class Notice {
    private int id;
    private String content;
    private byte showFlag;
    private Timestamp createTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "show_flag", nullable = false)
    public byte getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(byte showFlag) {
        this.showFlag = showFlag;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notice notice = (Notice) o;
        return id == notice.id &&
                showFlag == notice.showFlag &&
                Objects.equals(content, notice.content) &&
                Objects.equals(createTime, notice.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, showFlag, createTime);
    }
}
