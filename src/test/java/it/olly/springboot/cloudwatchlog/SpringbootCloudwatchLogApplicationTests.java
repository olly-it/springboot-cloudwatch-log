package it.olly.springboot.cloudwatchlog;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootCloudwatchLogApplicationTests {
	final Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void contextLoads() {
		logger.debug("debug log here");
		logger.debug("INFO LOG HERE");
	}

}
