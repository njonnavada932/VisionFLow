package com.visionflow.imageupload;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImageUploadServiceApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		SpringApplication.run(ImageUploadServiceApplication.class, args);
	}

}
