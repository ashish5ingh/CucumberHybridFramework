package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public Properties initializeProperties() {
		
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/resources/configs/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return prop;
	}
}
