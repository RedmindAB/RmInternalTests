package se.redmind.rmtest.report.nav;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import se.redmind.rmtest.report.expectedconditions.ChartReloadFinished;
import se.redmind.rmtest.report.expectedconditions.SizeOfWebelement;
import se.redmind.rmtest.report.expectedconditions.UrlChanged;

public class SuiteController extends BaseController {

	public SuiteController(WebDriver pDriver) {
		super(pDriver);
	}

	public String getNameFrom(String type, String index){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(type+"-name-"+index)));
		return getElementByID(type+"-name-"+index).getText();
	}
	
	public String getRunTimeFrom(String type, String index){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(type+"-runtime-"+index)));
		return getElementByID(type+"-runtime-"+index).getText();
	}
	
	public void clickRunTime(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("order_by_runtime")));
		getElementByID("order_by_runtime").click();
	}
	
	public void clickFailPass(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("order_by_fail_pass")));
		getElementByID("order_by_fail_pass").click();
	}
	
	public void clickOnBar(String type, String index){
		String currentUrl = driver.getCurrentUrl();
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(type+"-"+index)));
		getElementByID(type+"-"+index).click();
		if (!type.equals("case")) {
			driverFluentWait(15).until(new UrlChanged(currentUrl));
		}
	}
	
	public void filterOn(String text){
		getElementByID("filter-field").sendKeys(text);
	}
	
	public String getFilterFieldText (){
		return getElementByID("filter-field").getText();
	}
	
	public void checkBoxOn(String type, String index){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(type+"-name-"+index)));
		getElementByID("checkbox"+index).click();
	}
	
	public void clickThisTestOnly(String index){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("case-thistest-"+index)));
		getElementByID("case-thistest-"+index).click();
		//driverFluentWait(20).until(new ChartReloadFinished());
		driverFluentWait(15).until(ExpectedConditions.invisibilityOfElementLocated(By.className("highcharts-loading")));
	}
	
	public WebElement getCurrentPossition(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("suite-position")));
		return getElementByID("suite-position");
	}
	
	public String getStackTrace(){
		driverFluentWait(15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[contains(@class, ' in')]//*/pre[contains(@class, 'stack-trace')]")));
		WebElement stackTrace = driver.findElement(By.xpath("//*/div[contains(@class, ' in')]//*/pre[contains(@class, 'stack-trace')]"));
		return stackTrace.getText();
	}
	
	public int getSizeOfCaseList(){
		WebElement group= driver.findElement(By.id("case-group"));
		WebElement panelGroup = group.findElement(By.className("panel-group"));
		List <WebElement> caseList = panelGroup.findElements(By.className("panel-heading"));
		return caseList.size();
	}
	
	
	public String getPassFail(String type, String index){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id(type+"-passfail-"+index)));
		WebElement getClassText = getElementByID(type+"-passfail-"+index);
		return getClassText.getText();
	}
	
	public void ClickOnSuiteLinkText(){
		driverFluentWait(15).until(ExpectedConditions.presenceOfElementLocated(By.id("suite-position")));
		String current = getUrl();
		getElementByID("suite-position").click();
		driverFluentWait(15).until(new UrlChanged(current));
	}

	
	/**
	 * This waits for x buttons to the right of the testcases, should be changed to something more steady.
	 * @param expectedSize
	 */
	public void waitForCaseListSize(int expectedSize) {
		By by = By.cssSelector(".accordion-toggle > .btn");
		driverFluentWait(15).until(new SizeOfWebelement(by, expectedSize));
	}
	
}
