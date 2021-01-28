package com.board.Config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimplePBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
	
	@Value("${Jasypt.encryptor.password}")
	private String key;
	
	@Bean("jasyptStringEncrptor")
	public StringEncryptor stringEncryptor() {
	PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
	SimplePBEConfig config = new SimplePBEConfig();
	config.setPassword(key);
	config.setAlgorithm("PBEWithMD5AndDES");
	config.setPoolSize(1);
	encryptor.setConfig(config);
	return encryptor;
	}

}