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
import se.redmind.rmtest.report.expectedconditions.UrlChanged;

public class VisualNav extends BaseNav{
	
	public VisualNav(WebDriver pDriver) {
		super(pDriver);
	}

	@Override
	void navigate() {
		getElementByID("section_2").click();
		getElementByID("visual_view").click();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("classes_0")));
	}

	public WebElement getMethodID(){
		return getElementByID("methods_0");
	}
	
	public void chooseClass(String id){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		getElementByID(id).click();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("method_0")));
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
	
	public void goTo(String byID){
		String currentURL = driver.getCurrentUrl();
		getElementByID("go_to_" + byID).click();
		driverFluentWait(15).until(new UrlChanged(currentURL));
	}
	
	public WebElement getGoBackButton(){
		return getElementByClass("screenshot-nav-left");
	}
	
	public boolean isAtClassView(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("go-to-suites")));
		if(getElementByID("go-to-suites").isDisplayed())
			return true;
		else 
			return false;
	}
	
	public void openMethod(String method){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("method_" + method)));
		getElementByID("method_" + method).click();
	}
	
	public boolean isThumbnailPresent(String method){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("table_" + method)));
		if(getElementByID("table_" + method).isDisplayed()){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void openScreenshot(String num){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("screenshot" + num)));
		getElementByID("screenshot" + num).click();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.className("slide-animation")));
	}
	
	public boolean isScreenshotPresent(){
		if(getElementByClass("slide-animation").isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean isScreenShotSwitched(){
		String textBefore;
		String textAfter;
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.className("white")));
		textBefore = getElementByClass("white").getText();
		System.out.println("textBefore: " + textBefore);
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("arrow_prev")));
		getElementByID("arrow_prev").click();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.className("white")));
		textAfter = getElementByClass("white").getText();
		System.out.println("textAfter: " + textAfter);
		if(textBefore.equals(textAfter))
			return false;
		else
			return true;
	}
	
}