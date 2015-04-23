package se.redmind.rmtest.report.nav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import se.redmind.rmtest.selenium.framework.HTMLPage;

public abstract class BaseController extends HTMLPage{

	public BaseController(WebDriver pDriver) {
		super(pDriver);
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
	
	protected String getUrl(){
		return driver.getCurrentUrl();
	}
	
}
