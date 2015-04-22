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
		/*navigateByID("section").click();
		navigateByID("visual_view").click();*/
	}

	public WebElement getMethodID(){
		return getElementByID("methods_0");
	}
	
	public void chooseClass(){
		getElementByID("classes_0").click();
	}
	
	public WebElement getNav(String NavID){
		return driver.findElement(By.className(NavID));
	}
	
	public boolean isDisabled(String NavID){
		boolean isDisabled = false;
		WebElement list = driver.findElement(By.id(NavID));
		String disabled = list.getAttribute("class");
		if(disabled.equals(NavID + " disabled")){
			isDisabled = true;
		}
		else{
			isDisabled = false;
		}
		return isDisabled;
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
	
	public void goToGraph(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("go_graph_0")));
		getElementByID("go_graph_0").click();
	}
	
	public void goToScreenshots(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("go_ss_0")));
		getElementByID("go_ss_0").click();
	}
	
	public WebElement openTimestamp(){
		return getElementByID("choose_timestamp");
	}
	
	public WebElement getTimestamp(){
		return getElementByID("choose_timestamp");
	}
	
	public void changeTimestamp(String name){
		openTimestamp().click();
		WebElement dropDown = getElementByID("choose_timestamp_drop");
		List<WebElement> findElements = dropDown.findElements(By.tagName("a"));
		for (WebElement listItem : findElements) {
			if (listItem.getText().equals(name)) {
				listItem.click();
				return;
			}
		}
	}
	
	public void sleep(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void returnToPrevious(){
		getElementByClass("screenshot-nav-left").click();
	}
}
