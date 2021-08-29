package com.hulkStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ConfigurationProperties
@PropertySource("classpath:application.properties")
public class HulkStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkStoreApplication.class, args);
	}

}
