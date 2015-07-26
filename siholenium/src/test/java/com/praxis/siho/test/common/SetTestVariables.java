package com.praxis.siho.test.common;
import java.io.FileInputStream;
import java.util.Properties;

public class SetTestVariables {
	public static Properties configProp = new Properties();
	static {
		loadProperties("resources/" + System.getProperty("propertiesFile"), configProp);
	}

	public static void loadProperties(String fileName, Properties properties) {
		FileInputStream stream;
		try {
			stream = new FileInputStream(fileName);
			properties.load(stream);
			stream.close();
		} catch (Exception e) {
			System.out.println("Could not load properties from file: " + fileName);
			e.printStackTrace();
		}
	}
}
