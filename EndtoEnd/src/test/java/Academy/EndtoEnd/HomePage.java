package Academy.EndtoEnd;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LandingPage.LandingPage;
import LandingPage.LoginPage;
import resources.base;

public class HomePage extends base{
public static Logger log=LogManager.getLogger(base.class.getName());	
public WebDriver driver;

@BeforeTest
	public void Before() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("URL"));
		System.out.println("US Time");
		System.out.println("US Time");
		System.out.println("US Time");
		System.out.println("US Time");
		System.out.println("US Time");
		System.out.println("US Time");
		System.out.println("I am gonna devlop a robust framework");
}	
	
	
@Test(dataProvider="getData")
	public void basepageNaviagation(String username, String password, String text) throws IOException {
		
		driver.get(prop.getProperty("URL"));
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.login().click();
		log.info(text);
	}


@DataProvider
public Object[][] getData() {
	
	
	Object[][] data=new Object[2][3];
	
	data[0][0]="nonrestricteduser@qw.com";
	data[0][1]="password1";
	data[0][2]="Unrestricted user";
	 
	
	data[1][0]="restricteduser@qw.com"; 
	data[1][1]="password2";
	data[1][2]="Restricted user";
	 
	return data;		
}

@AfterTest
public void Close() {
	driver.close();
}


}
	