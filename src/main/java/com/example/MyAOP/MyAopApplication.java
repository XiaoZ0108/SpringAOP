package com.example.MyAOP;

import com.example.MyAOP.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication

public class MyAopApplication implements CommandLineRunner {

	@Autowired
	private MyService myService;

	public static void main(String[] args) {
		SpringApplication.run(MyAopApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		myService.dummyMethod(1,2,3,4);
		myService.dummyMethod2();
		myService.throwErrorMethod();
	}
}
