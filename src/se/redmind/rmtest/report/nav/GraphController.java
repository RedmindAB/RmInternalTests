package se.redmind.rmtest.report.nav;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import se.redmind.rmtest.report.expectedconditions.ChartReloadFinished;
import se.redmind.rmtest.report.expectedconditions.WebElementListSize;

public class GraphController extends BaseController{

	public GraphController(WebDriver pDriver) {
		super(pDriver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getGraph(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("chart1")));
		return driver.findElement(By.id("chart1"));
	}
	
//	public WebElement getChartTitle(){
//		WebElement titleElement = getElementByID("display-dropdown");
//		return titleText;
//	}
	
	public Chart getChart(){
		WebElement chartElement = getElementByID("chart1");
		return new Chart(chartElement);
	}
	
	public void waitForLegendListSize(int expectedSize){
		By by = By.className("highcharts-legend-item");
		driverFluentWait(15).until(new WebElementListSize(by, expectedSize));
	}
	
	public WebElement getLegendListItem(int index) {
		By legenditems = By.className("highcharts-legend-item");
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(legenditems));
		List <WebElement> list = driver.findElements(legenditems);
		return list.get(index);
	}
	
	public List <WebElement> getLegendList() {
		By legenditems = By.className("highcharts-legend-item");
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(legenditems));
		List <WebElement> list = driver.findElements(By.className("highcharts-legend-item"));
		return list;
	}
	
	public void clickOnLegend(int index){
		driverFluentWait(15).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("highcharts-legend-item"))));
		getLegendListItem(index).click();
	}
}
