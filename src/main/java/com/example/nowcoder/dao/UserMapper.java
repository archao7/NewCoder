package com.example.nowcoder.dao;

import com.example.nowcoder.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    //都是和resource下xml对应的sql方法;
    //service调用dao层，并不一定是说每个方法都对应，而是service里的逻辑会用到这些方法
    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
