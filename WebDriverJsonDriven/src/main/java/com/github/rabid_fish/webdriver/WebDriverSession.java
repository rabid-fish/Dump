package com.github.rabid_fish.webdriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rabid_fish.webdriver.config.Config;

public class WebDriverSession {

	private static Logger LOG = LoggerFactory.getLogger(WebDriverSession.class);
	
	public static void main(String[] args) {

		try {
			validateCommandLineArgs(args);
			
			WebDriverSession session = new WebDriverSession();
			String configPath = args[0];
			session.run(configPath);
			
		} catch (Exception e) {
			printUsage(e);
		}
	}
	
	private static void validateCommandLineArgs(String[] args) throws FileNotFoundException {
		
		if (args == null || args.length < 1) {
			throw new IllegalArgumentException("Missing one or more arguments");
		}
		
		String path = args[0];
		File file = new File(path);
		if (!file.exists()) {
			URL url = WebDriverSession.class.getClassLoader().getResource(path);
			if (url == null) {
				throw new FileNotFoundException("Unable to find file or classpath resource at path '" + path + "'");
			}
		}
	}

	private static void printUsage(Exception e) {
		
		String message =
				"Usage: java -jar <this jar> com.github.rabid_fish.webdriver.WebDriverSession"
				+ "\"path_to_config\"";
		
		if (e != null) {
			message = e.getMessage() + "\n" + message;
		}
		
		System.out.println(message);
	}

	public void run(String configPath) throws JsonParseException, JsonMappingException, IOException {
		
		Config config = readConfiguration(configPath);
		
		LOG.info("Initializing browser");
		WebDriver driver = new FirefoxDriver();
		
		try {
			LOG.info("Connecting to url '" + config.getUrl() + "'");
			driver.get(config.getUrl());
			
			
		} finally {
			LOG.info("Closing browser");
			driver.quit();
		}
	}
	
	public Config readConfiguration(String path) throws JsonParseException, JsonMappingException, IOException {
		
		Config config = null;
		ObjectMapper mapper = new ObjectMapper();
		
		File file = new File(path);
		if (file.exists()) {
			LOG.info("Reading configuration from file path");
			config = mapper.readValue(file, Config.class);
		} else {
			LOG.info("Reading configuration from resource");
			URL url = getClass().getClassLoader().getResource(path);
			config = mapper.readValue(url, Config.class);
		}
		
		return config;
	}
}
