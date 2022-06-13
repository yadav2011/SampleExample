package com.test.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.demo.Int.IContract;
import com.test.demo.Int.IDemoService;
import com.test.demo.Int.IZone;
import com.test.demo.Int.impl.ContractImpl;
import com.test.demo.Int.impl.DemoService;
import com.test.demo.Int.impl.ZoneImpl;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public IZone getZone() {
		return new ZoneImpl();
	}

	@Bean
	public IContract getContract() {
		return new ContractImpl();
	}

	@Bean
	public IDemoService getDemoService() {
		return new DemoService();
	}

	@Override
	public void run(String... args) throws Exception {
		getDemoService().runService();
	}
	
}