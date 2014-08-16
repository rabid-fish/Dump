package com.github.rabid_fish.webdriver.config;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rabid_fish.webdriver.config.Config;

public class ConfigTest {

	@Test
	public void testDeserializeJson() throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		URL url = getClass().getClassLoader().getResource("GoogleConfig.json");
		Config config = mapper.readValue(url, Config.class);
		assertNotNull(config);
	}
}
