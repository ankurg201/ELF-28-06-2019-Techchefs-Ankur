package com.techchefs.pool;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static PropertiesUtil propertiesUtil = null;
	private Properties properties = null;

	private PropertiesUtil() throws Exception {
		properties = new Properties();
		properties.load(new FileInputStream("db.properties"));
	}

	public static PropertiesUtil getPropertiesUtil() throws Exception {
		if (propertiesUtil == null) {
			propertiesUtil = new PropertiesUtil();
		}
		return propertiesUtil;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
