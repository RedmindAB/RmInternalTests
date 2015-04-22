package se.redmind.rmtest.report.nav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuiteController extends BaseController {

	public SuiteController(WebDriver pDriver) {
		super(pDriver);
	}

	public String getNameFrom(String type, String index){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(type+"-name-"+index)));
		return getElementByID(type+"-name-"+index).getText();
	}
	
	public String getRunTimeFrom(String type, String index){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(type+"-runtime-"+index)));
		return getElementByID(type+"-runtime-"+index).getText();
	}
	
	public void clickRunTime(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("order_by_runtime")));
		getElementByID("order_by_runtime").click();
	}
	
	public void clickFailPass(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("order_by_fail_pass")));
		getElementByID("order_by_fail_pass").click();
	}
	
	public void clickOnBar(String type, String index){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(type+"-"+index)));
		getElementByID(type+"-"+index).click();
		
	}
	
	public void chooseTimestampFromDropdown(String timestamp){
		getElementByID("choose_timestamp").click();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("timestamp-dropdown")));
		getElementByID("timestamp-suite-"+timestamp).click();
	}
	
	public void filterOn(String text){
		getElementByID("filter-field").sendKeys(text);
	}
	
	public void checkBoxOn(String type, String index){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(type+"-name-"+index)));
		getElementByID("checkbox"+index).click();
	}
	
	public void clickThisTestOnly(String index){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("case-thistest-"+index)));
		getElementByID("case-thistest-"+index).click();
	}
	
}
