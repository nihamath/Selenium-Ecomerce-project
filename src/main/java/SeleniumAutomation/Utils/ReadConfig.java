package SeleniumAutomation.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig() {
		File src=new File(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public String getUrl() {
		String url= pro.getProperty("url");
		return url;
	}
	
	public String getUserName() {
		String userName= pro.getProperty("username");
		return userName;
	}
	
	public String getPassword() {
		String password= pro.getProperty("password");
		return password;
	}
	
	public String getProduct() {
		String product= pro.getProperty("product");
		return product;
	}
	
	public String getBroswer() {
		String browser= pro.getProperty("browser");
		return browser;
	}
	

}
