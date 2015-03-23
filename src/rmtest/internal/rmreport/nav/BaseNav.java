package rmtest.internal.rmreport.nav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import se.redmind.rmtest.selenium.framework.HTMLPage;


public class BaseNav extends HTMLPage {

	public BaseNav(WebDriver pDriver) {
		super(pDriver);
		pDriver.get("http://localhost:4567");
	}
	
	public WebElement getRedmindLogo(){
		return driver.findElement(By.id("home"));
	}
	
	public WebElement getGraphMenu(){
		return driver.findElement(By.id("graph_view"));
	}
	
	public WebElement getScreenshotMenu(){
		return driver.findElement(By.id("screenshot_view"));
	}

}
