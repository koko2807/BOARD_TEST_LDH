package com.aloha.board_test_ldh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BoardTestLdhApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardTestLdhApplication.class, args);
	}

}
