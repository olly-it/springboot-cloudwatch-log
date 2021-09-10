package it.olly.springboot.cloudwatchlog.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleController {
	final Logger logger = LoggerFactory.getLogger(getClass());

	@PostConstruct
	private void init() {
		logger.debug("debug init");
		logger.info("info init");
	}

	@GetMapping
	public ResponseEntity<String> get(@RequestParam(required = false) String param) {
		logger.debug("debug GET");
		logger.info("info GET");
		logger.warn("warn GET");
		return ResponseEntity.ok("requestProcessed!");
	}
}
