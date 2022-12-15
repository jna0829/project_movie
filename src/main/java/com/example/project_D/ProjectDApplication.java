package com.example.project_D;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProjectDApplication {

	public static void main(String[] args) {
		// 톰캣 실행하는 코드
		SpringApplication.run(ProjectDApplication.class, args);
	}

}
