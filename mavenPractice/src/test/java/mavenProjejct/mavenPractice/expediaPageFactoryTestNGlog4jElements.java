package mavenProjejct.mavenPractice;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class expediaPageFactoryTestNGlog4jElements {
static Logger log = Logger.getLogger(expediaPageFactoryTestNGlog4jElements.class);
WebDriver driver;
WebElement element;

@FindBy(id="tab-flight-tab")
WebElement flightTab;

@FindBy(id="flight-origin")
WebElement originCity;

@FindBy(id="flight-destination")
WebElement destinationCity;

@FindBy(id="flight-departing")
WebElement departureDate;

@FindBy(id="flight-returning")
WebElement returnDate;

@FindBy(id="search-button")
WebElement searchButton;

@FindBy(id="advanced-options")
WebElement advancedOptions;

@FindBy(id="advanced-flight-nonstop")
WebElement nonstopCheckBox;



public expediaPageFactoryTestNGlog4jElements(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void clickFlightsTab(){
	flightTab.click();
	log.info("Clicked flights tab");
}

public void clickSearchButton(){
	searchButton.click();
	log.info("Clicked search button");
}

public void fillOriginCity(String origin){
	originCity.sendKeys(origin);
	log.info("Entered origin city as " + origin);
}

public void fillDestinationCity(String destination){
	destinationCity.sendKeys(destination);
	log.info("Entered destination city as " + destination);
}

public void fillDepartureDate(String departuredate){
	departureDate.sendKeys(departuredate);
	log.info("Entered departure date as " + departuredate);
	
}

public void fillReturningDate(String returningdate){
	returnDate.clear();
	returnDate.sendKeys(returningdate);
	log.info("Entered return date as " + returningdate);
}

public void clickAdvancedOptions(){
	advancedOptions.click();
	log.info("Clicked advanced options");
}

public void clickNonstopCheckbox(){
	nonstopCheckBox.click();
	log.info("Checked non stop check box");
	
}

public void selectPreferredClass(WebDriver driver, String classname){
	Select listPreferredClass = new Select(driver.findElement(By.id("flight-advanced-preferred-class")));
	/*List<WebElement> options = listPreferredClass.getOptions();
	for(int i=0; i<options.size(); i++){
		String op = options.get(i).getText();
		System.out.println("options is :" + op);
	}*/
	listPreferredClass.selectByValue(classname);
	log.info("Selected preferred class as " + classname);
}

public void clickonMorningFlights(WebDriver driver) throws InterruptedException{
	/*WebElement element = WaitTypes.getWhenVisible(driver, By.id("leg0-morning-departure"), 30);
	if(element.isDisplayed()){
		log.info("Checkbox is displayed");
		element.click();
		System.out.println("Clicked? " +element.isSelected());
	}*/
	Thread.sleep(40000);
	WebElement element = driver.findElement(By.id("leg0-morning-departure"));
	element.click();
	System.out.println("Clicked? " +element.isSelected());
	log.info("Clicked on Morning Time to filter the results");

}

public void clearAllfields(WebDriver driver){
	originCity.clear();
	destinationCity.clear();
	departureDate.clear();
	returnDate.clear();
}

}
