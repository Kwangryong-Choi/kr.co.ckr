package kr.co.ckrjjang;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration			// 환경설정  =>  config.xml
// @PropertySource("classpath:/application.properties")	// properties 파일을 로드할 수 있도록 하는 어노테이션
public class dbinfos {
	/*
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	@Bean
	public DataSource mysqldb() {
		return DataSourceBuilder.create().build();
	}
	*/
}
