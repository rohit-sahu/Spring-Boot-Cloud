package com.springboot.valtconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.springboot.valtconfig.config.Credential;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(Credential.class)
public class ValtconfigApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(ValtconfigApplication.class);

	private Credential credential;
	
	public ValtconfigApplication(Credential credential) {
		super();
		this.credential = credential;
	}

	public static void main(String[] args) {
		SpringApplication.run(ValtconfigApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("=========================================");
		logger.info("UserName : " + credential.getUsername());
		logger.info("Password : " + credential.getPassword());
		logger.info("=========================================");
	}

}
