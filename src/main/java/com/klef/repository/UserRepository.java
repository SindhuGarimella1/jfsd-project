package com.klef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klef.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select count(U) from User U where U.username =:uname")
    public int validateUsername(@Param("uname") String uname);
    
    @Query("select count(U) from User U where U.username =:uname and U.password =:pwd")
    public int validateLogin(@Param("uname") String username, @Param("pwd") String password);
    
    User findByUsername(String username);

}