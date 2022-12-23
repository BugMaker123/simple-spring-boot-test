/*
package com.example.simplespringboottest.repository;

import com.example.simplespringboottest.entity.Article;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleRepositoryTest {


    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void test() {
        System.out.println("test start");
        elasticsearchTemplate.createIndex(new Article("test").getClass());
        System.out.println("test end");
    }
}
*/
