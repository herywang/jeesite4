/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Application
 * @author ThinkGem
 * @version 2018-10-13
 */
@SpringBootApplication(scanBasePackages = "top.cangtai")
public class Application extends SpringBootServletInitializer {

	@Value("${mongodb.host}")
	private String mongoHost;

	@Value("${mongodb.port}")
	private Integer mongoPort;

	@Value("${mongodb.database}")
	private String mongoDatabase;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		this.setRegisterErrorPageFilter(false); // 错误页面有容器来处理，而不是SpringBoot
		return builder.sources(Application.class);

	}

	@Bean
	public MongoTemplate initMongoTemplate(){
		MongoClient mongoClient = new MongoClient(mongoHost,mongoPort);
		MongoDbFactory clientFactory = new SimpleMongoDbFactory(mongoClient,mongoDatabase);
		return new MongoTemplate(clientFactory);
	}
}