package se.redmind.rmtest.report.nav;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import se.redmind.rmtest.report.expectedconditions.ChartReloadFinished;

public class GraphNav extends BaseNav {

	public GraphNav(WebDriver pDriver) {
		super(pDriver);
	}

	@Override
	void navigate() {
		getFirstSuiteSection().click();
	}
	
	public WebElement getGraph(){
		return driver.findElement(By.id("chart1"));
	}
	
	public WebElement getNumberOfSuiteRunsButton(){
		return getElementByID("suite_runs");
	}
	
	public WebElement getAddGraphLine(){
		return getElementByID("add_graph_line");
	}
	
	public WebElement getReload(){
		return getElementByID("button_reload");
	}
	
	public WebElement getChooseGraphView(){
		return getElementByID("choose_graph_view");
	}
	
	public WebElement getChooseBreakPoint(){
		return getElementByID("choose_break_point");
	}
	
	public WebElement getRemoveLineButton(){
		return getElementByID("button_break");
	}
	
//	public WebElement getChartTitle(){
//		WebElement titleElement = getElementByID("display-dropdown");
//		return titleText;
//	}
	
	public void reloadGraph(){
		WebElement reload = getReload();
		reload.click();
		driverFluentWait(20).until(new ChartReloadFinished());
	}
	
	public void addToGraph(){
		WebElement addTo = getAddGraphLine();
		addTo.click();
		driverFluentWait(20).until(new ChartReloadFinished());
	}
	
	public void clickAddToGraph(){
		WebElement addLine = getAddGraphLine();
		addLine.click();
		driverFluentWait(20).until(new ChartReloadFinished());
	}
	
	public void removeGraphLine(String removeName){
		getRemoveLineButton().click();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("remove-"+removeName)));
		getElementByID("remove-"+removeName).click();;
	}
	
	public void changeChartSuiteRunLimit(String limit){
		getNumberOfSuiteRunsButton().click();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("run-amount-"+limit)));
		getElementByID("run-amount-"+limit).click();;
	}
	
	public void changeDisplayType(String variantName){
		getChooseGraphView().click();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("display-"+variantName)));
		getElementByID("display-"+variantName).click();;
	}
	
	public void changeBreakPoint(String breakPoint){
		getChooseBreakPoint().click();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("breakpoint-"+breakPoint)));
		getElementByID("breakpoint-"+breakPoint).click();;
	}
	
	public void clickClearCheckBoxes(){
		getElementByID("clear-button").click();
	}
	
	public void clickSpecifications(){
		getElementByID("specifications").click();
	}
	
	public void clickPlatform(String platformName){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("spec-"+platformName)));
		getElementByID("spec-"+platformName).click();
	}
	
	public void checkBrowser(String browserName){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("browser-"+browserName)));
		getElementByID("browser-"+browserName).click();
	}
	
	public void checkDevice(String deviceName){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("device-"+deviceName)));
		getElementByID("device-"+deviceName).click();
	}
	
	public void checkVersion(String version){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("version-"+version)));
		getElementByID("version-"+version).click();
	}
	
	public Chart getChart(){
		WebElement chartElement = getElementByID("chart1");
		return new Chart(chartElement);
	}
}
