package se.redmind.rmtest.report.nav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetElementText;
import org.openqa.selenium.support.ui.ExpectedConditions;

import se.redmind.rmtest.report.expectedconditions.ChartReloadFinished;

public class OptionsController extends BaseController{

	public OptionsController(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getNumberOfSuiteRunsButton(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("suite_runs")));
		return getElementByID("suite_runs");
	}
	
	public WebElement getAddGraphLine(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("add_graph_line")));
		return getElementByID("add_graph_line");
	}
	
	public WebElement getReload(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("button_reload")));
		return getElementByID("button_reload");
	}
	

	public WebElement getChooseGraphView(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("choose_graph_view")));
		return getElementByID("choose_graph_view");
	}
	
	public WebElement getChooseBreakPoint(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("choose_break_point")));
		return getElementByID("choose_break_point");
	}
	
	public WebElement getRemoveLineButton(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("remove-series")));
		return getElementByID("button_break");
	}
	
	public void reloadGraph(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(getElementByID("button_reload")));
		getReload().click();
		driverFluentWait(20).until(new ChartReloadFinished());
//		driverFluentWait(15).until(ExpectedConditions.invisibilityOfElementLocated(By.className("highcharts-loading")));
	}
	
	
	public void addToGraph(){
		WebElement addTo = getAddGraphLine();
		addTo.click();
		driverFluentWait(20).until(new ChartReloadFinished());
	}
	
	public void clickAddToGraph(){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(getElementByID("add_graph_line")));
		getAddGraphLine().click();
		driverFluentWait(20).until(new ChartReloadFinished());
	}
	
	public void removeGraphLine(String removeName){
		getRemoveLineButton().click();
		driverFluentWait(15).until(ExpectedConditions.visibilityOf(getElementByID("remove-"+removeName)));
		getElementByID("remove-"+removeName).click();;
	}
	
	public void changeChartSuiteRunLimit(String limit){
		getNumberOfSuiteRunsButton().click();
		driverFluentWait(15).until(ExpectedConditions.visibilityOf(getElementByID("amount-results")));
		getElementByID("run-amount-"+limit).click();
	}
	
	public String checkShowingNumberResults(){
		driverFluentWait(15).until(ExpectedConditions.visibilityOf(getElementByClass("highcharts-subtitle")));
		String reportSubTitle = getElementByClass("highcharts-subtitle").getText();
		return reportSubTitle;
	}
	
	public void changeDisplayType(String variantName){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(getElementByID("button_reload")));
		getChooseGraphView().click();
		driverFluentWait(15).until(ExpectedConditions.visibilityOf(getElementByID("display-dropdown")));
		getElementByID("display-"+variantName).click();
	}
	
	public void changeBreakPoint(String breakPoint){
		getChooseBreakPoint().click();
		driverFluentWait(15).until(ExpectedConditions.visibilityOf(getElementByID("set-criteria")));
		getElementByID("breakpoint-"+breakPoint).click();
	}
	
	public void clickClearCheckBoxes(){
		getElementByID("clear-button").click();
	}
	
	public void clickSpecifications(){
		getElementByID("specifications").click();
	}
	
	
	public void clickPlatform(String platformName){
		driverFluentWait(15).until(ExpectedConditions.visibilityOf(getElementByID("spec-"+platformName)));
		getElementByID("spec-"+platformName).click();
	}
	
	public void checkBrowser(String browserName){
		driverFluentWait(15).until(ExpectedConditions.visibilityOf(getElementByID("browser-"+browserName)));
		getElementByID("browser-"+browserName).click();
	}
	
	public void checkDevice(String deviceName){
		driverFluentWait(15).until(ExpectedConditions.visibilityOf(getElementByID("device-"+deviceName)));
		getElementByID("device-"+deviceName).click();
	}
	
	public void checkVersion(String version){
		driverFluentWait(15).until(ExpectedConditions.visibilityOf(getElementByID("version-"+version)));
		getElementByID("version-"+version).click();
	}
}
