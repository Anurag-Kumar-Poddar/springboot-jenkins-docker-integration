package com.anurag.springboot_jenkins_docker_integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootJenkinsDockerIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJenkinsDockerIntegrationApplication.class, args);
	}
	
	@RequestMapping("/")
	public String greet() {
		return "<h1>Hello! Docker.</h1>";
	}

}
