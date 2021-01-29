package com.board.Config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
public class JasyptsampleApplication implements CommandLineRunner {
	
	@Value("${Jasypt.encryptor.password}")
	private String key;

	@Override
	public void run(String... args) throws Exception {
		StandardPBEStringEncryptor spe = new StandardPBEStringEncryptor();
		spe.setAlgorithm("PBEWithMD5AndDES");
		spe.setPassword(key);
		String name = spe.encrypt("seonghyeon");
		String pw = spe.encrypt("tjdgus");
		String mailname = spe.encrypt("seonghyeon");
		String mailpw = spe.encrypt("1020hani");
		String db = spe.encrypt("jdbc:mariadb://localhost:3307/officialad?characterEncoding=UTF-8&serverTimezone=Asia/Seoul");
	}

}
