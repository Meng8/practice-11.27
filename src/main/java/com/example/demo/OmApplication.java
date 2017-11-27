package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.pojo.Animal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class OmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OmApplication.class, args);
		 ObjectMapper mapper = context.getBean(ObjectMapper.class);
		 Animal animal = new Animal("貔貅", "金黄", 22);
		 animal.setName("麒麟");
		 animal.setColor("红");
		 animal.setAge(1000);
		 
		 
		 try {
			System.out.println(mapper.writeValueAsString(animal));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //json 文件格式
		 String json = "{\"name\":\"乌龟\",\"color\":\"绿\",\"age\":1000}";
		 
		 try {
			Animal animal2 = mapper.readValue(json, Animal.class);
			System.out.println(animal2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		 
	}
	
	
	@Bean
	public ObjectMapper objectMapper() {
		
		return new ObjectMapper();
	}
	
}
