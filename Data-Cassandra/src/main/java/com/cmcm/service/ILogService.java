package com.cmcm.service;

import com.cmcm.entity.Log;

import java.util.List;

/**
 * @author hongfei
 * @create 2018-04-20 下午3:42
 */
public interface ILogService {

    List<Log> findAllLog();
}
