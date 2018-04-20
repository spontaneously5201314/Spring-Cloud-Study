package com.cmcm.service.impl;

import com.cmcm.entity.Log;
import com.cmcm.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hongfei
 * @create 2018-04-20 下午3:43
 */
@Service
public class LogService implements ILogService{

    @Autowired
    private CassandraTemplate template;

//    @Autowired
//    private CassandraOperations operations;

    @Override
    public List<Log> findAllLog() {
        return template.queryForList("select * from ab_log", Log.class);
    }
}
