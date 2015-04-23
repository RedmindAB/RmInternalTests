package se.redmind.rmtest.report.nav;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import se.redmind.rmtest.report.expectedconditions.ChartReloadFinished;

public class VisualNav extends BaseNav{
	
	public VisualNav(WebDriver pDriver) {
		super(pDriver);
	}

	@Override
	void navigate() {
		getElementByID("section").click();
		getElementByID("visual_view").click();
	}

	public WebElement getMethodID(){
		return getElementByID("methods_0");
	}
	
	public void chooseClass(String id){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		getElementByID(id).click();
	}
	
	public WebElement getNav(String NavID){
		return driver.findElement(By.className(NavID));
	}
	
	public boolean isEnabled(String NavID){
		boolean isEnabled = false;
		WebElement list = driver.findElement(By.id(NavID));
		String enabled = list.getAttribute("class");
		if(enabled.equals(NavID + " active")){
			isEnabled = true;
		}
		else{
			isEnabled = false;
		}
		return isEnabled;
	}
	
	public WebElement getTimestamp(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("timestamp_0")));
		return getElementByID("choose_timestamp");
	}
	
	public boolean isTimestampSet(String timestamp){
		boolean isActive = false;
		System.out.println("Is: " + getTimestamp().getText() + " = " + timestamp);
    	if(getTimestamp().getText().equals(timestamp))
    		isActive = true;
    	return isActive;
	}
	
	public void changeTimestamp(String timestamp){
		getTimestamp().click();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("choose_timestamp_drop")));
		WebElement dropDown = getElementByID("choose_timestamp_drop");
		List<WebElement> findElements = dropDown.findElements(By.tagName("a"));
		for (WebElement listItem : findElements) {
			if (listItem.getText().equals(timestamp)) {
				listItem.click();
				return;
			}
		}
	}
	
	public boolean checkAmountOfClasses(int amount){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("class_container")));
		WebElement dropDown = getElementByID("class_container");
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("class_name")));
		List<WebElement> findElements = dropDown.findElements(By.id("class_name"));
		if(findElements.size() > amount)
			return true;
		else
			return false;
	}
	
	public void openSysos(String id){
		chooseClass(id);
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("syso-header")));
		getElementByID("syso-header").click();
	}
	
	public boolean isSysosOpen(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("syso-header")));
		if(getElementByID("syso-header").isDisplayed())
			return true;
		else 
			return false;
	}
	
	public void closeSysos(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("close")));
		getElementByID("close").click();
	}
	
	public boolean isSysosClosed(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("close")));
		if(!getElementByID("close").isDisplayed())
			return true;
		else 
			return false;
	}
	
	public void sleep(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void returnToPrevious(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.className("screenshot-nav-left")));
		getElementByClass("screenshot-nav-left").click();
	}
	
	public boolean isAtClassView(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.className("go-to-suites")));
		if(getElementByClass("go-to-suites").isDisplayed())
			return true;
		else 
			return false;
	}
}
