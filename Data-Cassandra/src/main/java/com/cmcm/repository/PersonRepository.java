package com.cmcm.repository;

import com.cmcm.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author hongfei
 * @create 2018-04-20 下午2:57
 */
public interface PersonRepository extends CrudRepository<Person, String>{
}
