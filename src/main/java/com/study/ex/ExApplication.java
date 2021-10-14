package com.study.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class ExApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExApplication.class, args);

		System.out.println("드디어 실행 성공");
	}

}
