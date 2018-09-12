package com.cmcm.study.mapper;

import com.cmcm.study.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Spontaneously
 * @time 2018-09-07 下午2:23
 */
@Mapper
public interface OrderMapper {

//    @Insert("INSERT INTO t_order (\n" +
//            "        user_id, status\n" +
//            "        )\n" +
//            "        VALUES (\n" +
//            "        #{userId,jdbcType=INTEGER},\n" +
//            "        #{status,jdbcType=VARCHAR}\n" +
//            "        )")
    Long insert(Order model);
}
