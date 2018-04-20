package com.cmcm.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hongfei
 * @create 2018-04-20 下午3:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonTest {

//    @Autowired
//    private PersonRepository personRepository;

    @Autowired
    private CassandraTemplate operations;

    @Test
    public void insertPerson(){
        Person person = new Person("1", "hongfei", 26);
        operations.insert(person);
        Person result = operations.selectOneById(Person.class, "1");
        System.out.println(result);
    }
}
