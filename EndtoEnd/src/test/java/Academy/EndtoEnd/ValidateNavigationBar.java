package Academy.EndtoEnd;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import LandingPage.LandingPage;
import resources.base;


public class ValidateNavigationBar extends base {
public WebDriver driver;

@BeforeTest

public void Before() throws IOException {
	driver=initializeDriver();
	driver.get(prop.getProperty("URL"));
}
	
@Test	
public void basepageNaviagation() throws IOException {
			
	LandingPage l=new LandingPage(driver);
	Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES2");
}

@AfterTest
public void Close() {
	driver.close();
}

}