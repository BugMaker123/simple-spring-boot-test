package com.example.simplespringboottest;

import com.example.simplespringboottest.springtests.facoryBeanTest.AlgorithmService;
import com.example.simplespringboottest.springtests.facoryBeanTest.Base;
import com.example.simplespringboottest.springtests.facoryBeanTest.BaseFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.simplespringboottest")
@EntityScan(basePackages = "com.example.simplespringboottest.entity")
//@EnableElasticsearchRepositories(basePackages = "com.example.simplespringboottest.repository")
public class SimpleSpringBootTestApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SimpleSpringBootTestApplication.class);
		ConfigurableApplicationContext ctx  = springApplication.run(args);
		Base bean1 = ctx.getBean(Base.class);
		System.out.println(bean1);

		BaseFactoryBean bean2 = ctx.getBean("&baseFactoryBean", BaseFactoryBean.class);
		System.out.println(bean2);

		AlgorithmService algorithmService = ctx.getBean(AlgorithmService.class);
		algorithmService.encrypt();


		//SpringApplication.run(SimpleSpringBootTestApplication.class, args);
	}

}
