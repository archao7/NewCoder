package com.example.nowcoder.dao;


import com.example.nowcoder.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@Param()用于给参数取别名；
    // 如果sql语句要用到参数并且函数只有一个参数时，必须要取别名，否则出错
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);
}
