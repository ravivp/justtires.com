package core.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

	private static final Properties defaultProp= new Properties();


	static {
		String propertyPath="src/main/resources/configuration.properties";
		try {
			FileReader read= new FileReader(propertyPath);
			try {
				defaultProp.load(read);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	
	public static String getUser() {
		
	return (String)defaultProp.get("user");
		
	}

	public static String getPasswod() {
		
		return (String)defaultProp.get("password");
			
		}

	public static String getURL() {
		
		return (String)defaultProp.get("orangedemo.url");
			
		}

  public static String getName() {
	  
	  
	  Object ob= defaultProp.get("name");
	  
	  return (String)ob;
	  
  }	
}
