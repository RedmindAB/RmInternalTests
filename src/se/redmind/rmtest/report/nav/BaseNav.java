package se.redmind.rmtest.report.nav;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import se.redmind.rmtest.report.expectedconditions.UrlChanged;
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
	
	public void goToGrid(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("grid_view")));
		String before = getCurrentUrl();
		WebElement gridButton = driver.findElement(By.id("grid_view"));
		gridButton.click();
		driverFluentWait(15).until(new UrlChanged(before));
	}
	
	public void goToAdmin(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("admin_view")));
		String before = getCurrentUrl();
		WebElement adminButton = driver.findElement(By.id("admin_view"));
		adminButton.click();
		driverFluentWait(15).until(new UrlChanged(before));
	}
	
	public void goToDashboard(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("dash_view")));
		String before = getCurrentUrl();
		WebElement dashButton = driver.findElement(By.id("dash_view"));
		dashButton.click();
		driverFluentWait(15).until(new UrlChanged(before));
	}
	
	public void chooseProject(int index){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("choose_project")));
		WebElement projectButton = driver.findElement(By.id("choose_project"));
		projectButton.click();
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.className("dropdown-menu")));
		WebElement dropdown = driver.findElement(By.className("dropdown-menu"));
		List<WebElement> projects = dropdown.findElements(By.tagName("a"));
		projects.get(index).click();
		
	}
	
	public String getProjectNameFromList(int index){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("choose_project")));
		WebElement projectButton = driver.findElement(By.id("choose_project"));
		projectButton.click();
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.className("dropdown-menu")));
		WebElement dropdown = driver.findElement(By.className("dropdown-menu"));
		List<WebElement> projects = dropdown.findElements(By.tagName("a"));
		return projects.get(index).getText();
	}
	
	public void chooseTimeStamp(String timestamp){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("choose_timestamp")));
		WebElement timestampButton = driver.findElement(By.id("choose_timestamp"));
		timestampButton.click();
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("dropdown-timestamp")));
		WebElement dropdown = driver.findElement(By.id("dropdown-timestamp"));
		List<WebElement> timestamps = dropdown.findElements(By.tagName("a"));
		for (WebElement webElement : timestamps) {
			if (webElement.getText().equals(timestamp)) {
				webElement.click();
				return;
				
			}
			
		}
		


	}
	
	public String getCurrentTimestamp(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("choose_timestamp")));
		WebElement timestampButton = driver.findElement(By.id("choose_timestamp"));
		return timestampButton.getText();
	}
	
	public String getCurrentProjectName(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("choose_project")));
		WebElement projectButton = driver.findElement(By.id("choose_project"));
		return projectButton.getText();
	}
	
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public void clickLogo(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.className("navbar-brand")));
		String before = getCurrentUrl();
		WebElement logoButton = driver.findElement(By.className("navbar-brand"));
		logoButton.click();
		driverFluentWait(15).until(new UrlChanged(before));
	}
	
	public void goToReports(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("reports_view")));
		String before = getCurrentUrl();
		WebElement reportsButton = driver.findElement(By.id("reports_view"));
		reportsButton.click();
		driverFluentWait(15).until(new UrlChanged(before));
	}
	
	public void goToVisualizer(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(By.id("visual_view")));
		String before = getCurrentUrl();
		WebElement visualizerButton = driver.findElement(By.id("visual_view"));
		visualizerButton.click();
		driverFluentWait(15).until(new UrlChanged(before));
	}
}
