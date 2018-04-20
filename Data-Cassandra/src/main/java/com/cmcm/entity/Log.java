package com.cmcm.entity;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 *  id                                   | business_type | left_num | log_type | op_desc | op_num | op_time | role_id
 --------------------------------------+---------------+----------+----------+---------+--------+---------+---------
 cbef4ed3-f359-4125-894b-38c965e00aca |          null |     null |     null |    null |   null |    null |       1
 d7b84991-6c04-419a-818d-aad04c019a41 |          null |     null |     null |    null |   null |    null |       1

 CREATE TABLE arrow_brawl.ab_log (
 id uuid PRIMARY KEY,
 business_type text,
 left_num int,
 log_type text,
 op_desc text,
 op_num int,
 op_time timestamp,
 role_id bigint
 ) WITH bloom_filter_fp_chance = 0.01
 AND caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}
 AND comment = ''
 AND compaction = {'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold': '32', 'min_threshold': '4'}
 AND compression = {'chunk_length_in_kb': '64', 'class': 'org.apache.cassandra.io.compress.LZ4Compressor'}
 AND crc_check_chance = 1.0
 AND dclocal_read_repair_chance = 0.1
 AND default_time_to_live = 0
 AND gc_grace_seconds = 864000
 AND max_index_interval = 2048
 AND memtable_flush_period_in_ms = 0
 AND min_index_interval = 128
 AND read_repair_chance = 0.0
 AND speculative_retry = '99PERCENTILE';
 CREATE INDEX idx_op_time ON arrow_brawl.ab_log (op_time);
 CREATE INDEX idx_role_id ON arrow_brawl.ab_log (role_id);

 * @author hongfei
 * @create 2018-04-20 下午3:37
 */
@Table(value = "ab_log")
public class Log implements Serializable{

    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID id;

    @Column("business_type")
    private String buss;

    @Column("left_num")
    private Integer left;

    @Column("log_type")
    private String logType;

    @Column("op_desc")
    private String opDesc;

    @Column("op_num")
    private Integer opNum;

    @Column("op_time")
    private Date opTime;

    @Column("role_id")
    private Long roleId;

    public Log(UUID id, String buss, Integer left, String logType, String opDesc, Integer opNum, Date opTime, Long roleId) {
        this.id = id;
        this.buss = buss;
        this.left = left;
        this.logType = logType;
        this.opDesc = opDesc;
        this.opNum = opNum;
        this.opTime = opTime;
        this.roleId = roleId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBuss() {
        return buss;
    }

    public void setBuss(String buss) {
        this.buss = buss;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getOpDesc() {
        return opDesc;
    }

    public void setOpDesc(String opDesc) {
        this.opDesc = opDesc;
    }

    public Integer getOpNum() {
        return opNum;
    }

    public void setOpNum(Integer opNum) {
        this.opNum = opNum;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", buss='" + buss + '\'' +
                ", left=" + left +
                ", logType='" + logType + '\'' +
                ", opDesc='" + opDesc + '\'' +
                ", opNum=" + opNum +
                ", opTime=" + opTime +
                ", roleId=" + roleId +
                '}';
    }
}
