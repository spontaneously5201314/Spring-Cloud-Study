package com.cmcm.repository;

import com.cmcm.entity.Log;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

/**
 * @author hongfei
 * @create 2018-04-20 下午4:13
 */
public interface LogRepository extends CassandraRepository<Log>{

    @Override
    @Query("select * from ab_log")
    List<Log> findAll();
}
