package SeleniumAutomation.TestComponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SeleniumAutomation.Utils.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public ReadConfig read;
	
	@BeforeMethod
	public void initailiseDriver() {
		
		read= new ReadConfig();
		if (read.getBroswer().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		
		else if (read.getBroswer().equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
		

		else if (read.getBroswer().equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		
		
		driver.get(read.getUrl());
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
	
	public String captureScreen(String tname, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "//report//" + tname + ".png");
		FileUtils.copyFile(source, target);
		String path =System.getProperty("user.dir") + "//report//" + tname + ".png";
		System.out.println(path);
		return System.getProperty("user.dir")+ "//report//" + tname + ".png";
		
	}

}
