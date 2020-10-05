package com.wl.contentcenter.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: Share
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/09/24 12:30:23 
 * @Version: V1.0
 **/
@Entity
public class Share {
    private int id;
    private int userId;
    private String title;
    private Timestamp createTime;
    private Timestamp updateTime;
    private byte isOriginal;
    private String author;
    private String cover;
    private String summary;
    private int price;
    private String downloadUrl;
    private int buyCount;
    private byte showFlag;
    private String auditStatus;
    private String reason;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 80)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "is_original", nullable = false)
    public byte getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(byte isOriginal) {
        this.isOriginal = isOriginal;
    }

    @Basic
    @Column(name = "author", nullable = false, length = 45)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "cover", nullable = false, length = 256)
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Basic
    @Column(name = "summary", nullable = false, length = 256)
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "download_url", nullable = false, length = 256)
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Basic
    @Column(name = "buy_count", nullable = false)
    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
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
    @Column(name = "audit_status", nullable = false, length = 10)
    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Basic
    @Column(name = "reason", nullable = false, length = 200)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Share share = (Share) o;
        return id == share.id &&
                userId == share.userId &&
                isOriginal == share.isOriginal &&
                price == share.price &&
                buyCount == share.buyCount &&
                showFlag == share.showFlag &&
                Objects.equals(title, share.title) &&
                Objects.equals(createTime, share.createTime) &&
                Objects.equals(updateTime, share.updateTime) &&
                Objects.equals(author, share.author) &&
                Objects.equals(cover, share.cover) &&
                Objects.equals(summary, share.summary) &&
                Objects.equals(downloadUrl, share.downloadUrl) &&
                Objects.equals(auditStatus, share.auditStatus) &&
                Objects.equals(reason, share.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, createTime, updateTime, isOriginal, author, cover, summary, price, downloadUrl, buyCount, showFlag, auditStatus, reason);
    }
}
