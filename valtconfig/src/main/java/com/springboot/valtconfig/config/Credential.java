package com.springboot.valtconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("example")
public class Credential {

	private String username;
	private String password;
}
