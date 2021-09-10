package it.olly.springboot.cloudwatchlog;

import org.junit.jupiter.api.Test;

import it.olly.springboot.cloudwatchlog.utils.SysConfig;

public class TestSysConfig {

	@Test
	public void doTest() {
		System.setProperty("env", "local");

		// load /local.properties setting all local's entries as system properties
		SysConfig.setSystemPropertiesFromResource("/${env}.properties");
	}
}
