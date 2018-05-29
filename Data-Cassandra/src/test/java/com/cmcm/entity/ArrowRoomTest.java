//package com.cmcm.entity;
//
//importannotation org.junit.Test;
//importannotation org.junit.runner.RunWith;
//importannotation org.springframework.beans.factory.annotation.Autowired;
//importannotation org.springframework.cglib.beans.BeanCopier;
//importannotation org.springframework.data.cassandra.core.CassandraOperations;
//importannotation org.springframework.data.cassandra.repository.MapId;
//importannotation org.springframework.data.cassandra.repository.Query;
//importannotation org.springframework.data.cassandra.repository.support.BasicMapId;
//importannotation org.springframework.test.context.ContextConfiguration;
//importannotation org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//importannotation java.util.Date;
//importannotation java.util.List;
//
///**
// * @author hongfei
// * @create 2018-04-19 下午8:56
// */
////@Ignore
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:config/service/applicationContext-*.xml"})
//public class ArrowRoomTest {
//    @Autowired
//    private CassandraOperations cassandraTemplate;
//
//    @Autowired
//    private RoomService roomService;
//
//    @Autowired
//    private ArrowRoomRepository roomRepository;
//
//    /**
//     * 保存数据测试
//     */
//    @Test
//    public void insertTest() {
//        Room room = roomService.selectByPrimaryKey(11L);
//        if (room != null) {
//            ArrowRoom arrowRoom = new ArrowRoom();
//
//            BeanCopier copier = BeanCopier.create(Room.class, ArrowRoom.class, false);
//            copier.copy(room, arrowRoom, null);
//            System.out.println(JSON.toJSONString(arrowRoom));
//            arrowRoom.setEndTime(new Date());
////            List<ArrowRoom> select = cassandraTemplate.select("select * from arrow_room", ArrowRoom.class);
//            cassandraTemplate.insert(arrowRoom);
//        }
////        ArrowRoom arrowRoom = cassandraTemplate.selectOneById(12L, ArrowRoom.class);
//    }
//
//
//    /**
//     * 删除数据测试
//     */
//    @Test
//    public void deleteRoomByCassandraTest() {
////        ArrowRoom arrowRoom = new ArrowRoom();
////        arrowRoom.setRoomId(12l);
////
////        cassandraTemplate.delete(arrowRoom);
//        MapId mapId = BasicMapId.id("roomId", 11l);
//        cassandraTemplate.deleteById(mapId, ArrowRoom.class);
//    }
//
//    /**
//     * 查询数据列表
//     */
//    @Test
//    public void findListTest() {
//        //第一种
//        List<ArrowRoom> select1 = cassandraTemplate.select("select * from arrow_room", ArrowRoom.class);
//        System.out.println("data1=" + JSON.toJSONString(select1));
//
////        Query query = Query.query(Criteria.where("roomId").is("foo")).and(Criteria.where("userComment").is("bar"))
////                .sort(Sort.by("foo", "bar")) //
////                .columns(Columns.from("foo").ttl("bar")) //
////                .limit(5);
//
////        Select select = QueryBuilder.select().from("productprice");
////        select.where(QueryBuilder.eq("productid",productId));
////        select.allowFiltering();
//
//        //第二种
//        List<ArrowRoom> select2 = cassandraTemplate.select(Query.query(), ArrowRoom.class);
//        System.out.println("data2=" + JSON.toJSONString(select2));
//    }
//
//    /**
//     * 更新数据查询
//     */
//    @Test
//    public void updateTest() {
//        MapId mapId = BasicMapId.id("roomId", 14L);
//        ArrowRoom arrowRoom = cassandraTemplate.selectOneById(mapId, ArrowRoom.class);
//        if (arrowRoom != null) {
//            arrowRoom.setState(-1);
//            arrowRoom.setEndTime(new Date());
//            cassandraTemplate.update(arrowRoom);
//        }
//    }
//}