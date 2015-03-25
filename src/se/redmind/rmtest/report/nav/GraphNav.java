package se.redmind.rmtest.report.nav;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	
	public void reloadGraph(){
		WebElement reload = getReload();
		reload.click();
		driverFluentWait(20).until(new ChartReloadFinished());
	}
	
	public void changeChartSuiteRunLimit(int limit){
		getNumberOfSuiteRunsButton().click();
		WebElement dropDown = getElementByID("suite_runs_drop");
		List<WebElement> findElements = dropDown.findElements(By.tagName("a"));
		for (WebElement listItem : findElements) {
			if (listItem.getText().equals(""+limit)) {
				listItem.click();
				return;
			}
		}
	}
	
	public Chart getChart(){
		WebElement chartElement = getElementByID("chart1");
		return new Chart(chartElement);
	}
}
