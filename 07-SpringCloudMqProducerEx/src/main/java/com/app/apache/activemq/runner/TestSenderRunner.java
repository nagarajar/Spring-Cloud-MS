package com.app.apache.activemq.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.apache.activemq.service.ProducerService;

@Component
public class TestSenderRunner 
//implements CommandLineRunner
{
	@Autowired
	private ProducerService service;
	

	/*
	 * @Override public void run(String... args) throws Exception {
	 * service.sendMessage("Hello : "+ new Date());
	 * 
	 * }
	 */
	// We can give the data continuously from producer to check Is Consumer fetching data continuously or Not ? 
	@Scheduled(cron = "*/10 * * * * *")
	public void sendMessage() {
		service.sendMessage("Hello : "+ new Date());
	}
}
