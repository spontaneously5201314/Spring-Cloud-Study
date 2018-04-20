//package com.cmcm.entity;
//
//import org.springframework.cassandra.core.PrimaryKeyType;
//import org.springframework.data.cassandra.mapping.Column;
//import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
//import org.springframework.data.cassandra.mapping.Table;
//
//import java.io.Serializable;
//import java.util.Date;
//
///**
// * @author hongfei
// * @create 2018-04-19 下午8:53
// */
//@Table(value = "arrow_table")
//@Data
//public class ArrowRoom implements Serializable {
//
//    private static final long serialVersionUID = 508653398236366595L;
//
//    /**
//     * 房间ID
//     */
//    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 1, name = "room_id", value = "room_id")
//    private Long roomId;
//
//    /**
//     * 状态：0 等待玩家加入 1 玩家已满 -1 房间已关闭
//     */
//    private Integer state;
//
//    /**
//     * 开房时间
//     */
//    @Column(value = "create_time")
//    private Date createTime;
//
//    /**
//     * 游戏开始时间
//     */
//    @Column(value = "begin_time")
//    private Date beginTime;
//
//    /**
//     * 当前存活人数
//     */
//    @Column(value = "alive_number")
//    private Integer aliveNumber;
//
//    /**
//     * 等级
//     */
//    @Column(value = "level")
//    private Integer level;
//
//    /**
//     * 总人数
//     */
//    @Column(value = "number")
//    private Integer number;
//    /**
//     * 机器人数
//     */
//    @Column(value = "robot_number")
//    private Integer robotNumber;
//    /**
//     * 竞技场类型 竞技场类型 1:初级 2:高级 3:午夜 4:nVn比赛
//     */
//    @Column(value = "room_type")
//    private Integer roomType;
//    /**
//     * 地图
//     */
//    @Column(value = "room_map")
//    private Integer roomMap;
//    /**
//     * 玩家列表详情
//     */
//    @Column(value = "elist")
//    private String elist;
//    /**
//     * 版本号
//     */
//    @Column(value = "room_version")
//    private Integer roomVersion;
//    /**
//     * 区域调度Key
//     */
//    @Column(value = "area_location")
//    private String areaLocation;
//    /**
//     * 房间组队类型
//     */
//    @Column(value = "pair_type")
//    private Integer pairType;
//
//    /**
//     * 房间匹配分数
//     */
//    @Column(value = "room_score")
//    private Integer roomScore;
//    /**
//     * 房间分组配进去的人数只有组队才会用到
//     */
//    @Column(value = "group_number")
//    private Integer groupNumber;
//
//    /**
//     * 游戏结束时间
//     */
//    @Column(value = "end_time")
//    private Date endTime;
//}