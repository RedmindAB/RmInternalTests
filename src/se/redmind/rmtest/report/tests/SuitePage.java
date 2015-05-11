package se.redmind.rmtest.report.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import se.redmind.rmtest.report.nav.Chart;
import se.redmind.rmtest.report.nav.GraphNav;
import se.redmind.rmtest.selenium.framework.RMReportScreenshot;
import se.redmind.rmtest.selenium.grid.DriverNamingWrapper;
import se.redmind.rmtest.selenium.grid.DriverProvider;
import se.redmind.rmtest.selenium.grid.Parallelized;



@RunWith(Parallelized.class)
public class SuitePage {


	   private WebDriver tDriver;
	    private final DriverNamingWrapper urlContainer;
	    private final String driverDescription;
	    private final RMReportScreenshot rmrScreenshot;
	    private GraphNav nav;

	    public SuitePage(final DriverNamingWrapper driverWrapper, final String driverDescription) {
	        this.urlContainer = driverWrapper;
	        this.driverDescription = driverDescription;
	        this.rmrScreenshot = new RMReportScreenshot(urlContainer);
	    }
	    
	    private static Object[] getDrivers() {
//	        return DriverProvider.getDrivers("rmDeviceType", "mobile");
//	    	return DriverProvider.getDrivers(Platform.ANDROID);
	    	return DriverProvider.getDrivers();

	    }

	    @Parameterized.Parameters(name = "{1}")
	    public static Collection<Object[]> drivers() {
	        ArrayList<Object[]> returnList = new ArrayList<Object[]>();
	        Object[] wrapperList = getDrivers();
	        for (int i = 0; i < wrapperList.length; i++) {
	            returnList.add(new Object[]{wrapperList[i], wrapperList[i].toString()});
	        }
	        return returnList;
	    }

	    @AfterClass
	    public static void afterTest(){
//	    	DriverProvider.stopDrivers();
	    }
	    

	    @Before
	    public void beforeTest(){
	    	this.tDriver = this.urlContainer.startDriver();
	    	this.nav = new GraphNav(tDriver);
	    }
	    
        @Test
        public void test_OrderByFailPass () {
        	String before = nav.suite.getNameFrom("class", "0");
        	nav.suite.clickFailPass();
        	String after = nav.suite.getNameFrom("class", "0");
        	assertNotEquals(before, after);
        }
        
        @Test
        public void test_GoToMethods(){
        	String className  = nav.suite.getNameFrom("class", "0");
        	nav.suite.clickOnBar("class", "0");
        	assertEquals(className, nav.suite.getCurrentPossition().getText());
        }

        @Test
        public void test_GoToCases(){
        	nav.suite.clickOnBar("class", "0");
        	String methodName = nav.suite.getNameFrom("method", "0");
        	nav.suite.clickOnBar("method", "0");
        	assertEquals(methodName, nav.suite.getCurrentPossition().getText());
        }
        
        @Test
        public void test_ClickOnThisTestOnly(){
        	nav.suite.clickOnBar("class", "0");
        	nav.suite.clickOnBar("method", "0");
        	nav.suite.clickThisTestOnly("0");
        	String expectedName = "Ubuntu-14.04-UNKNOWN-chrome-42";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(expectedName, actualName);
        	assertEquals(expectedSize, actualSize);
        }
        
        @Test
        public void test_getErrorCase(){
        	nav.suite.clickOnBar("class", "0");
        	nav.suite.clickOnBar("method", "0");
        	nav.suite.clickOnBar("case", "0");
        	String stackTrace = nav.suite.getStackTrace();
        	int	colon = stackTrace.indexOf(":");
        	stackTrace = stackTrace.substring(0, colon);
        	String expected = "java.lang.AssertionError";
        	assertEquals(expected, stackTrace);
        }
        
        @Test
        public void test_ClickOnLastCase(){
        	nav.suite.clickOnBar("class", "0");
        	nav.suite.clickOnBar("method", "0");
        	nav.suite.clickOnBar("case", "15");
        	String stackTrace = nav.suite.getStackTrace();
        	String expected = "No Message To Display";
        	assertEquals(expected, stackTrace);
        }
        
        @Ignore
        @Test 
        public void test_CheckClass(){
        	nav.suite.checkBoxOn("class", "0");
        	nav.option.reloadGraph();
        	String expectedName = "Android";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(expectedName, actualName);
        	assertEquals(expectedSize, actualSize);
        }
        
        @Ignore
        @Test 
        public void test_CheckMethod(){
        	nav.suite.clickOnBar("class", "0");
        	nav.suite.checkBoxOn("method", "0");
        	nav.option.reloadGraph();
        }
        
        @Test 
        public void test_ClickOnClassReload(){
        	nav.suite.clickOnBar("class", "0");
        	nav.option.reloadGraph();
        	String expectedName = "RandomClass0";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(expectedName, actualName);
        	assertEquals(expectedSize, actualSize);
        }
        
        @Test
        public void test_FilterCleanUp(){
        	nav.suite.filterOn("random");
        	nav.suite.clickOnBar("class", "0");
        	String expected = "";
        	String actual = nav.suite.getFilterFieldText();
        	assertEquals(expected, actual);
        }
        
        @Test
        public void test_FilterOnChrome(){
        	nav.suite.clickOnBar("class", "0");
        	nav.suite.clickOnBar("method", "0");
        	nav.suite.filterOn("chrome");
        	int expected = 8;
        	int actual = nav.suite.getSizeOfCaseList();
        	nav.suite.waitForCaseListSize(expected);
        	assertEquals(expected, actual);
        }
        
	    @Test
	    public void test_ClickOnClassLink(){
	    	nav.suite.clickOnBar("class", "0");
	    	nav.suite.ClickOnSuiteLinkText();
	    	String actual = nav.graph.getUrl();
	    	assertTrue(actual.endsWith("/#/reports/classes"));
	    }
	    
	    @Test
	    public void test_clickOnMethodLink(){
	    	nav.suite.clickOnBar("class", "0");
	    	nav.suite.clickOnBar("method", "0");
	    	nav.suite.ClickOnSuiteLinkText();
	    	String actual = nav.graph.getUrl();
	    	assertTrue(actual.endsWith("/#/reports/methods"));
	    }
	    
	    @Test
	    public void test_getPassFailTextClass(){
	    	String actual = nav.suite.getPassFail("class", "0");
	    	String expected = "Skipped: 0 Failed: 28";
	    	assertEquals(expected, actual);
	    }
	    
	    @Test
	    public void test_getPassFailTextMethod(){
	    	nav.suite.clickOnBar("class", "0");
	    	String actual = nav.suite.getPassFail("method", "0");
	    	String expected = "Skipped: 0 Failed: 12";
	    	assertEquals(expected, actual);
	    }

	    
	    @Ignore
	    @Test
	    public void test_BreakOnBrowserDispTime(){
	    	nav.option.changeDisplayType("Run Time");
	    	nav.option.changeBreakPoint("Browser");
	    	nav.option.reloadGraph();
	    }

}
