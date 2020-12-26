package com.woc.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class WocBmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WocBmsApplication.class, args);
	}

}
