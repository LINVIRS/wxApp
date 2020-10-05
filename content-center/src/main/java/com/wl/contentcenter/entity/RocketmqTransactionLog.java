package com.wl.contentcenter.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName: RocketmqTransactionLog
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/09/24 12:30:23 
 * @Version: V1.0
 **/
@Entity
@Table(name = "rocketmq_transaction_log", schema = "content_center", catalog = "")
public class RocketmqTransactionLog {
    private int id;
    private String transactionId;
    private String log;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "transaction_Id", nullable = false, length = 45)
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "log", nullable = false, length = 45)
    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RocketmqTransactionLog that = (RocketmqTransactionLog) o;
        return id == that.id &&
                Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(log, that.log);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionId, log);
    }
}
