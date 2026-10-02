package com.module1.firstModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstModuleApplication implements CommandLineRunner {

//	@Autowired
//	PaymentService paymentService;
	final Notification notification;

	public FirstModuleApplication(@Qualifier("sms") Notification notification) {
		this.notification = notification;
	}

	public static void main(String[] args) {
		SpringApplication.run(FirstModuleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		paymentService.print();
		notification.send("Send Hello message");
	}
}
