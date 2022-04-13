package com.example.nowcoder;

import com.example.nowcoder.dao.DiscussPostMapper;
import com.example.nowcoder.entity.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,5);
        for(DiscussPost discussPost: list){
            System.out.println(discussPost);
        }
    }

    @Test
    public void testSelectDiscussPostRows(){
        int row = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(row);
    }
}
