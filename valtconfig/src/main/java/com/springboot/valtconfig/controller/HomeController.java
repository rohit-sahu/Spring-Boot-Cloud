package com.springboot.valtconfig.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.core.VaultSysOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultTransitOperations;
import org.springframework.vault.support.VaultMount;
import org.springframework.vault.support.VaultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.valtconfig.config.Credential;

@RestController
@RefreshScope
@RequestMapping("/home")
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private VaultTemplate vaultTemplate;
	
	@Autowired
	private Credential credential;

	@GetMapping("/")
	public String home () {
		logger.info("Home : " + credential.getPassword());
		
		VaultResponse response = vaultTemplate.opsForKeyValue("secret", KeyValueBackend.KV_2).get("spring-vault-config");
		logger.info("UserName : " + response.getData().get("example.username"));
		logger.info("UserName : " + response.getData().get("example.password"));
		
		// Let's encrypt some data using the Transit backend.
	    VaultTransitOperations transitOperations = vaultTemplate.opsForTransit();

	    // We need to setup transit first (assuming you didn't set up it yet).
	    VaultSysOperations sysOperations = vaultTemplate.opsForSys();
	    
	    if (!sysOperations.getMounts().containsKey("transit/")) {
	    	logger.info("============creating foo-key ====================");
	        sysOperations.mount("transit", VaultMount.create("transit"));

	        transitOperations.createKey("foo-key");
	      }

	      // Encrypt a plain-text value
	      String ciphertext = transitOperations.encrypt("foo-key", "Secure message");

	      System.out.println("Encrypted value");
	      System.out.println("-------------------------------");
	      System.out.println(ciphertext);
	      System.out.println("-------------------------------");
	      System.out.println();

	      // Decrypt

	      String plaintext = transitOperations.decrypt("foo-key", ciphertext);

	      System.out.println("Decrypted value");
	      System.out.println("-------------------------------");
	      System.out.println(plaintext);
	      System.out.println("-------------------------------");
	      System.out.println();
		
		return credential.getUsername();
	}
}
