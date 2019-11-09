package com.zensar.clientapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ClientAppApplication {
	@Value("${some.property}")
	private String someProperty;
	@Autowired
	private ConfigClientPropertiesDemo property;

	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
	}
	
	@GetMapping
	public String readProdperty() {
		
		StringBuilder builder=new StringBuilder();
		
		builder.append(property.getProperty());
		
		builder.append("  ||  ");
		
		builder.append(someProperty);
		
		return builder.toString();
	}

}
