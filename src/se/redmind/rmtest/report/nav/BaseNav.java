package se.redmind.rmtest.report.nav;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import se.redmind.rmtest.selenium.framework.HTMLPage;

abstract class BaseNav extends HTMLPage{

	public BaseNav(WebDriver pDriver) {
		super(pDriver);
		this.driver.get("http://192.168.75.120:4567");
		initialWait();
		navigate();
	}

	public void initialWait(){
		driverFluentWait(15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("highcharts-series-group")));
	}
	
	abstract void navigate();
	
	public WebElement getRedmindLogo(){
		return this.driver.findElement(By.id("home"));
	}
	
	public WebElement getGraphView(){
		return this.driver.findElement(By.id("graph_view"));
	}
	
	public WebElement getScreenshot(){
		return this.driver.findElement(By.id("screenshot_view"));
	}

	public void click(WebElement element){
		element.click();
	}
	
	public WebElement getElementByXPath(String xPath){
		return driver.findElement(By.cssSelector(xPath));
	}
	
	public WebElement getElementByID(String NavClass){
		return driver.findElement(By.id(NavClass));
	}
	
	public WebElement getElementByClass(String NavClass){
		return driver.findElement(By.className(NavClass));
	}
	
	public void chooseTimestampFromDropdown(String timestamp){
		getElementByID("choose_timestamp").click();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(timestamp)));
		WebElement chooseTimestamp = getElementByID(timestamp);
		chooseTimestamp.click();
	}
	
	public void getFirstSuiteSection(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.className("highcharts-series")));
		WebElement rect = getElementByClass("highcharts-series");
		List<WebElement> findElements = rect.findElements(By.tagName("rect"));
		WebElement listItem = findElements.get(0);
		listItem.click();
	}
	
	public WebElement getChartTitle(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("button_reload")));
		WebElement findElement = driver.findElement(By.className("highcharts-title"));
		return findElement;
	}
	
	public WebElement getChartSubtitle(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("button_reload")));
		return driver.findElement(By.className("highcharts-subtitle"));
	}
}
