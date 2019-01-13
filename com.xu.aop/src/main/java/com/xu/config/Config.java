package com.xu.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	public static	String file = "config/config.properties";
	public static Config config = null;
	public static Properties  properties  = null;
		
	public Config () {
		properties = new Properties();
		InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(file);
		try {
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Config getConfig() {
		if (null == config) {
			config = new Config();
		}
		return config;
	}
	
	public String get(String key) {
		String property = properties.getProperty(key);
		return property;
	}
}
