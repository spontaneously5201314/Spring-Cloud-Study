package com.cmcm.study.dao;

import com.cmcm.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hongfei
 * @create 2018-05-16 下午6:47
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
