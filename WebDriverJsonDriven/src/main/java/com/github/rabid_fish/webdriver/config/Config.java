package com.github.rabid_fish.webdriver.config;

import java.util.List;

public class Config {

	private String url;
	private List<ConfigCommand> commands;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<ConfigCommand> getCommands() {
		return commands;
	}
	public void setCommands(List<ConfigCommand> commands) {
		this.commands = commands;
	}
}
