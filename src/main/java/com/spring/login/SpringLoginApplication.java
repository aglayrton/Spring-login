package com.spring.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringLoginApplication {

	public static void main(String[] args) {
		
		System.out.println(new BCryptPasswordEncoder().encode("root"));
		
		//SpringApplication.run(SpringLoginApplication.class, args);
	}
	
}
