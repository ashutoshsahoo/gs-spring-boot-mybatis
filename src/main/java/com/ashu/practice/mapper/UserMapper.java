package com.ashu.practice.mapper;

import com.ashu.practice.domain.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<User> getUsers();
    User getUser(@Param("userId")Integer userId);
    @MapKey("ID")
    Map<Integer, Map<String, String>> getUsersInMap();
}
