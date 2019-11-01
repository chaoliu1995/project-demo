package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ChaoLiu
 * @Description:
 * @Date: 2019/8/20 17:08
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByName(String name);
}
