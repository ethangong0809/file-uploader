package com.ethangong.fileuploader;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ethangong.fileuploader.storage.StorageService;

@SpringBootApplication
public class FileUploaderApplication {
	
	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(FileUploaderApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
