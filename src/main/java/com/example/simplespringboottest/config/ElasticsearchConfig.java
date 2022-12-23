/*
package com.example.simplespringboottest.config;

import org.elasticsearch.client.Client;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@Configuration
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration.class})
public class ElasticsearchConfig {

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        ElasticsearchConfig elasticsearchConfig = new ElasticsearchConfig();
        ElasticsearchTemplate elasticsearchTemplate = elasticsearchConfig.elasticsearchTemplate();
        return elasticsearchTemplate;
    }

}
*/
