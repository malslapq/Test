package com.board.Config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JasyptsampleApplication implements CommandLineRunner {
	@Value("${Jasypt.encryptor.password")
	private String key;
	public static void main(String[] args) {
		SpringApplication.run(JasyptsampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StandardPBEStringEncryptor spe = new StandardPBEStringEncryptor();
		spe.setAlgorithm("PBEWithMD5AndDES");
		spe.setPassword(key);
		System.out.println("db username = " + spe.encrypt("root"));
		System.out.println("db password = " + spe.encrypt("1111"));
	}

}
