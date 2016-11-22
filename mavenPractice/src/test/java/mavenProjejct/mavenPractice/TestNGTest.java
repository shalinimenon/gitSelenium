package mavenProjejct.mavenPractice;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNGTest {
	private WebDriver driver;
	private String baseURL;
	static Logger log = Logger.getLogger(TestNGTest.class);
	expediaPageFactoryTestNGlog4jElements expe;
	
	@BeforeClass
	  public void beforeClass() {
		PropertyConfigurator.configure("log4j.properties");
	    driver = new FirefoxDriver();
	    expe = new expediaPageFactoryTestNGlog4jElements(driver);
	    baseURL = "https://www.expedia.ca/?rfrr=Redirect.From.www.expedia.com%2F";
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.get(baseURL);
	  }
	
  @Test
  public void test1() {
	  expe.clickFlightsTab();
	  expe.fillOriginCity("New York");
	  expe.fillDestinationCity("Chicago");
	  expe.fillDepartureDate("24/12/2016");
	  expe.fillReturningDate("25/12/2016");
  }
  
  @Test
  public void test2() {
    expe.clickAdvancedOptions();
    expe.clickNonstopCheckbox();
    expe.selectPreferredClass(driver, "first");
    expe.clickSearchButton();
  }
  

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }

}
