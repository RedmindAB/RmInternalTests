package se.redmind.rmtest.report.nav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import se.redmind.rmtest.selenium.framework.HTMLPage;

abstract class BaseNav extends HTMLPage{

	public BaseNav(WebDriver pDriver) {
		super(pDriver);
		this.driver.get("localhost:4567");
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
	
	public WebElement getFirstSuiteSection(){
		return driver.findElement(By.id("section"));
	}
	
	public WebElement getChartTitle(){
		WebElement firstSuiteSection = getFirstSuiteSection();
		WebElement findElement = firstSuiteSection.findElement(By.className("highcharts-title"));
		System.out.println("text: "+findElement.getText());
		return findElement;
	}
	
	protected WebElement getElementByID(String id){
		return this.driver.findElement(By.id(id));
	}
	
	protected WebElement getElementByClass(String className){
		return this.driver.findElement(By.className(className));
	}
	
	protected WebElement getElementByCss(String css){
		return this.driver.findElement(By.xpath(css));
	}
	


}
