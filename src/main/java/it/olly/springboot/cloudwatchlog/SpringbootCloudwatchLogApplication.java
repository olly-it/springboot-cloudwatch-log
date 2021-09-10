package it.olly.springboot.cloudwatchlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.olly.springboot.cloudwatchlog.utils.SysConfig;

@SpringBootApplication
public class SpringbootCloudwatchLogApplication {

	public static void main(String[] args) {
		// load properties from a file and set it as system's properties
		// (used here to load aws's key/secret from a file instead of env variables
		SysConfig.setSystemPropertiesFromResource("/${env}.properties");

		SpringApplication.run(SpringbootCloudwatchLogApplication.class, args);
	}

}
