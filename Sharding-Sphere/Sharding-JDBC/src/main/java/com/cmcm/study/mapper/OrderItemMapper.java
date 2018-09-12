package com.cmcm.study.mapper;

import com.cmcm.study.domain.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Spontaneously
 * @time 2018-09-07 下午2:24
 */
@Mapper
public interface OrderItemMapper {

//    @Insert("INSERT INTO t_order_item (\n" +
//            "        order_id, user_id, status\n" +
//            "        )\n" +
//            "        VALUES (\n" +
//            "        #{orderId,jdbcType=INTEGER},\n" +
//            "        #{userId,jdbcType=INTEGER},\n" +
//            "        #{status,jdbcType=VARCHAR}\n" +
//            "        )")
    Long insert(OrderItem model);
}
