package com.example.simplespringboottest.mapper;

import com.example.simplespringboottest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserMapper extends JpaRepository<User, Long> , Serializable {

}
