package com.quruiqi.myadmin.system.repository;

import com.quruiqi.myadmin.system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:01
 **/
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * findByEmail
     * @param s
     * @return
     */
    User findByEmail(String s);

    /**
     * findByUsername
     * @param s
     * @return
     */
    User findByUsername(String s);

}
