package resources;
import java.io.File;

import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class base {

public static Properties prop;
public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException
	{
		 prop=new Properties();
		 FileInputStream fis=new FileInputStream("C:\\Users\\smita\\eclipse-workspace\\EndtoEnd\\src\\main\\java\\resources\\data.properties");
		 prop.load(fis);
		 String browser=System.getProperty("browser");
		 //String browser=prop.getProperty("browser");
	
		 
	if (browser.equals("chrome"))
	{	
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\smita\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("headless");
		driver=new ChromeDriver();
	}
	
	
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
return driver;
}
	
public String getScreenShotPath(String testcase, WebDriver driver) throws IOException{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcase+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;
}
}
