package com.carwash.userservice.repository;

import com.carwash.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    @Query("{userName:'?0'}")
    Optional<User> findByUserName(String userName);

    @Query("{phoneNo:'?0'}")
    Optional<User> findByPhoneNo(String phoneNo);

    @Query(value="{userName:'?0'}", delete = true)
     void deleteByUserName(String userName);

    @Query("{role: '?0' }")
    Optional<List<User>> findUserByRole(String role);

    @Query("{userName:'?0'}")
    User getByUserName(String userName);
}
