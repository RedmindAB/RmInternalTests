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
public class GraphPage {


	   private WebDriver tDriver;
	    private final DriverNamingWrapper urlContainer;
	    private final String driverDescription;
	    private final RMReportScreenshot rmrScreenshot;
	    private GraphNav nav;

	    public GraphPage(final DriverNamingWrapper driverWrapper, final String driverDescription) {
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

//	    @Test
//	    public void test_LoadTwentyRuns() {
//	    	nav.option.changeChartSuiteRunLimit("20");
//	    	nav.option.reloadGraph();
//		    WebElement chartSub = nav.getChartSubtitle();
//		    assertEquals("Showing 20 results", chartSub.getText());
//	    }
//	    
//	    @Test 
//	    public void test_LoadTenRuns() {
//	    	nav.option.changeChartSuiteRunLimit("10");
//	    	nav.option.reloadGraph();
//	    	WebElement chartSub = nav.getChartSubtitle();
//	    	assertEquals("Showing 10 results", chartSub.getText());
//	    }
//    
//	    
//	    @Test
//	    public void test_ShowPassFaill() {
//	    	String expected = "Percentage of passed tests";
//	    	WebElement chartTitle1 = nav.getChartTitle();
//	    	assertEquals(expected, chartTitle1.getText());
//	    	nav.option.changeDisplayType("Total Fail");
//	    	WebElement chartTitle2 = nav.getChartTitle();
//	    	assertNotEquals(expected, chartTitle2.getText());
//	    	nav.option.changeDisplayType("Pass/Fail");
//	    	WebElement chartTitle3 = nav.getChartTitle();
//	    	assertEquals(expected, chartTitle3.getText());
//	    }
//	    
//	    @Test
//	    public void test_TotalPass(){
//	    	nav.option.changeDisplayType("Total Pass");
//	    	String expected = "Passed tests";
//	    	WebElement chartTitle1 = nav.getChartTitle();
//	    	assertEquals(expected, chartTitle1.getText());
//	    }
//	    
//	    @Test
//	    public void test_TotalFailed(){
//	    	nav.option.changeDisplayType("Total Fail");
//	    	String expected = "Failed tests";
//	    	WebElement chartTitle1 = nav.getChartTitle();
//	    	assertEquals(expected, chartTitle1.getText());
//	    }
//	    
//	    @Test
//	    public void test_RunTime(){
//	    	nav.option.changeDisplayType("Run Time");
//	    	String expected = "Time to run in seconds";
//	    	WebElement chartTitle1 = nav.getChartTitle();
//	    	assertEquals(expected, chartTitle1.getText());
//	    }
//	    
//	    @Test
//	    public void test_CreateALine(){
//	    	nav.option.addToGraph();
//	    	int expected = 2;
//	    	int actual = nav.graph.getLegendList().size();
//	    	assertEquals(expected, actual);
//	    }
//	    
//	    @Test
//	    public void test_BreakOnBrowser(){
//	    	nav.option.changeBreakPoint("Browser");
//	    	nav.option.reloadGraph();
//	    	String expected = "firefox v.31";
//	    	String actual = nav.graph.getLegendListItem(0).getText();
//	    	assertEquals(expected, actual);
//	    	int expected2 = 2;
//	    	int actual2 = nav.graph.getLegendList().size();
//	    	assertEquals(expected2, actual2);
//    	}
//    	
//        @Test
//	    public void test_BreakOnVersion(){
//	    	nav.option.changeBreakPoint("Version");
//	    	nav.option.reloadGraph();
//	    	String expected = "Android 4.4.4";
//	    	String actual = nav.graph.getLegendListItem(0).getText();
//	    	assertEquals(expected, actual);
//	    	int expected2 = 4;
//	    	int actual2 = nav.graph.getLegendList().size();
//	    	assertEquals(expected2, actual2);
//	    }
//        
//        @Test
//	    public void test_BreakOnDevice(){
//	    	nav.option.changeBreakPoint("Device");
//	    	nav.option.reloadGraph();
//	    	String expected = "HTC ONE";
//	    	String actual = nav.graph.getLegendListItem(0).getText();
//	    	assertEquals(expected, actual);
//	    	int expected2 = 4;
//	    	int actual2 = nav.graph.getLegendList().size();
//	    	assertEquals(expected2, actual2);
//	    }
//        
//        @Test
//	    public void test_BreakOnPlatform(){
//        	nav.option.changeBreakPoint("Platform");
//        	nav.option.reloadGraph();
//        	String expected = "Android";
//	    	String actual = nav.graph.getLegendListItem(0).getText();
//	    	assertEquals(expected, actual);
//	    	int expected2 = 3;
//	    	int actual2 = nav.graph.getLegendList().size();
//	    	assertEquals(expected2, actual2);
//	    }
//	    
//        @Test
//	    public void test_RemoveALine(){
//        	nav.option.changeBreakPoint("Platform");
//        	nav.option.reloadGraph();
//        	nav.option.removeGraphLine("Android");
//        	
//        	String expFirst = "IOS";
//        	String firstObj = nav.graph.getLegendListItem(0).getText();
//
//        	String expSecond = "Ubuntu";
//        	String secendObj = nav.graph.getLegendListItem(1).getText();
//        	
//        	int listSize = nav.graph.getLegendList().size();
//        	int expSize = 2;
//        	assertEquals(expSize, listSize);
//        	assertEquals(expFirst, firstObj);
//        	assertEquals(expSecond, secendObj);
//        	
//	    }    
//    
//        @Test
//	    public void test_SpecificationsDevice_CheckDevice(){
//        	nav.option.changeBreakPoint("Device");
//        	nav.option.clickSpecifications();
//        	nav.option.clickPlatform("Android");
//        	nav.option.checkDevice("HTC ONE");
//        	nav.option.reloadGraph();
//        	String expectedName = "HTC ONE";
//        	int expectedSize = 1;
//        	String actualName = nav.graph.getLegendListItem(0).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName, actualName);
//        	assertEquals(expectedSize, actualSize);
//	    }
//	    
//        @Test
//	    public void test_SpecificationsDevice_CheckVersion(){
//        	nav.option.changeBreakPoint("Device");
//        	nav.option.clickSpecifications();
//        	nav.option.clickPlatform("Android");
//        	nav.option.checkVersion("4.4.4");
//        	nav.option.reloadGraph();
//        	String expectedName = "HTC ONE";
//        	int expectedSize = 1;
//        	String actualName = nav.graph.getLegendListItem(0).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName, actualName);
//        	assertEquals(expectedSize, actualSize);
//	    }
//        	
//	    
//        
//        @Test
//        public void test_SpecificationsDevice_CheckPlatform(){
//        	nav.option.changeBreakPoint("Device");
//        	nav.option.clickSpecifications();
//        	nav.option.clickPlatform("Android");
//        	nav.option.reloadGraph();
//        	String expectedName1 = "HTC ONE";
//        	String expectedName2 = "Nexus 6";
//        	int expectedSize = 2;
//        	String actualName1 = nav.graph.getLegendListItem(0).getText();
//        	String actualName2 = nav.graph.getLegendListItem(1).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName1, actualName1);
//        	assertEquals(expectedName2, actualName2);
//        	assertEquals(expectedSize, actualSize);
//        	
//        }
//
//	    
//        @Test
//	    public void test_Specifications_CheckDeviceGetVersion(){
//        	nav.option.changeBreakPoint("Version");
//        	nav.option.clickSpecifications();
//        	nav.option.clickPlatform("Android");
//        	nav.option.checkDevice("HTC ONE");
//        	nav.option.reloadGraph();
//        	String expectedName = "Android 4.4.4";
//        	int expectedSize = 1;
//        	String actualName = nav.graph.getLegendListItem(0).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName, actualName);
//        	assertEquals(expectedSize, actualSize);
//	    }
//        
//        @Test
//	    public void test_Specifications_Version(){
//        	nav.option.changeBreakPoint("Version");
//        	nav.option.clickSpecifications();
//        	nav.option.clickPlatform("Android");
//        	nav.option.checkVersion("4.4.4");
//        	nav.option.reloadGraph();
//        	String expectedName = "Android 4.4.4";
//        	int expectedSize = 1;
//        	String actualName = nav.graph.getLegendListItem(0).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName, actualName);
//        	assertEquals(expectedSize, actualSize);
//	    }
//        
//        @Test
//  	    public void test_Specifications_VersionPlatform(){
//          	nav.option.changeBreakPoint("Version");
//          	nav.option.clickSpecifications();
//          	nav.option.clickPlatform("Android");
//          	nav.option.reloadGraph();
//          	String expectedName1 = "Android 4.4.4";
//        	String expectedName2 = "Android 5.1";
//        	int expectedSize = 2;
//        	String actualName1 = nav.graph.getLegendListItem(0).getText();
//        	String actualName2 = nav.graph.getLegendListItem(1).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName1, actualName1);
//        	assertEquals(expectedName2, actualName2);
//        	assertEquals(expectedSize, actualSize);          	
//  	    }
//
//        
//        @Test
//	    public void test_Specifications_CheckDeviceGetPlatform(){
//        	nav.option.changeBreakPoint("Platform");
//        	nav.option.clickSpecifications();
//        	nav.option.clickPlatform("Android");
//        	nav.option.checkDevice("HTC ONE");
//        	nav.option.reloadGraph();
//         	String expectedName = "Android";
//        	int expectedSize = 1;
//        	String actualName = nav.graph.getLegendListItem(0).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName, actualName);
//        	assertEquals(expectedSize, actualSize);
//	    }
//        
//        @Test
//	    public void test_Specifications_Platform(){
//        	nav.option.changeBreakPoint("Platform");
//        	nav.option.clickSpecifications();
//        	nav.option.clickPlatform("Android");
//        	nav.option.reloadGraph();
//         	String expectedName = "Android";
//        	int expectedSize = 1;
//        	String actualName = nav.graph.getLegendListItem(0).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName, actualName);
//        	assertEquals(expectedSize, actualSize);
//	    }
//        
//        
//        @Test
// 	    public void test_Specifications_PlatformVersion(){
//         	nav.option.changeBreakPoint("Platform");
//         	nav.option.clickSpecifications();
//         	nav.option.clickPlatform("Android");
//         	nav.option.checkVersion("4.4.4");
//         	nav.option.reloadGraph();
//         	String expectedName = "Android";
//        	int expectedSize = 1;
//        	String actualName = nav.graph.getLegendListItem(0).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName, actualName);
//        	assertEquals(expectedSize, actualSize);
//        }
//        @Test
// 	    public void test_SpecificationsPlatform_CheckAndroidIOS(){
//         	nav.option.changeBreakPoint("Platform");
//         	nav.option.clickSpecifications();
//         	nav.option.clickPlatform("Android");
//         	nav.option.clickPlatform("IOS");
//         	nav.option.reloadGraph();
//         	String expectedName1 = "Android";
//         	String expectedName2 = "IOS";
//        	int expectedSize = 2;
//        	nav.graph.waitForLegendListSize(expectedSize);
//        	String actualName1 = nav.graph.getLegendListItem(0).getText();
//        	String actualName2 = nav.graph.getLegendListItem(1).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName1, actualName1);
//        	assertEquals(expectedName2, actualName2);
//        	assertEquals(expectedSize, actualSize);	
//        }
//        
//	    
//        @Test
//        public void test_SpecificationsBrowser_CheckChrome(){
//        	nav.option.changeBreakPoint("Browser");
//        	nav.option.clickSpecifications();
//        	nav.option.checkBrowser("chrome");
//        	nav.option.reloadGraph();
//        	String expectedName = "chrome v.42";
//        	int expectedSize = 1;
//        	String actualName = nav.graph.getLegendListItem(0).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName, actualName);
//        	assertEquals(expectedSize, actualSize);
//        }
//
//        
//        @Test
//        public void test_OrderByFailPass () {
//        	String before = nav.suite.getNameFrom("class", "0");
//        	nav.suite.clickFailPass();
//        	String after = nav.suite.getNameFrom("class", "0");
//        	assertNotEquals(before, after);
//        }
//        
//        @Test
//        public void test_ChooseTimeStampFromDropDrown() {
//        	nav.chooseTimestampFromDropdown("20150210080040");
//        	WebElement currentTimeStamp = nav.getElementByID("choose_timestamp");
//        	assertEquals("20150210080040", currentTimeStamp.getText());
//        }
//        
//        @Test
//        public void test_GoToMethods(){
//        	String className  = nav.suite.getNameFrom("class", "0");
//        	nav.suite.clickOnBar("class", "0");
//        	assertEquals(className, nav.suite.getCurrentPossition().getText());
//        }
//
//        @Test
//        public void test_GoToCases(){
//        	nav.suite.clickOnBar("class", "0");
//        	String methodName = nav.suite.getNameFrom("method", "0");
//        	nav.suite.clickOnBar("method", "0");
//        	assertEquals(methodName, nav.suite.getCurrentPossition().getText());
//        }
//        
//        @Test
//        public void test_ClickOnThisTestOnly(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.suite.clickOnBar("method", "0");
//        	nav.suite.clickThisTestOnly("0");
//        	String expectedName = "Ubuntu-14.04-UNKNOWN-chrome-42";
//        	int expectedSize = 1;
//        	String actualName = nav.graph.getLegendListItem(0).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName, actualName);
//        	assertEquals(expectedSize, actualSize);
//        }
//        
//        @Test
//        public void test_getErrorCase(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.suite.clickOnBar("method", "0");
//        	nav.suite.clickOnBar("case", "0");
//        	String stackTrace = nav.suite.getStackTrace();
//        	int	colon = stackTrace.indexOf(":");
//        	stackTrace = stackTrace.substring(0, colon);
//        	String expected = "java.lang.AssertionError";
//        	assertEquals(expected, stackTrace);
//        	
//        }
//        
//        @Test
//        public void test_ClickOnLastCase(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.suite.clickOnBar("method", "0");
//        	nav.suite.clickOnBar("case", "15");
//        	String stackTrace = nav.suite.getStackTrace();
//        	String expected = "No Message To Display";
//        	assertEquals(expected, stackTrace);
//        }
//        
//        @Ignore
//        @Test 
//        public void test_CheckClass(){
//        	nav.suite.checkBoxOn("class", "0");
//        	nav.option.reloadGraph();
//        	String expectedName = "Android";
//        	int expectedSize = 1;
//        	String actualName = nav.graph.getLegendListItem(0).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName, actualName);
//        	assertEquals(expectedSize, actualSize);
//        }
//        
//        @Ignore
//        @Test 
//        public void test_CheckMethod(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.suite.checkBoxOn("method", "0");
//        	nav.option.reloadGraph();
//        }
//        
//        @Test 
//        public void test_ClickOnClassReload(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.option.reloadGraph();
//        	String expectedName = "RandomClass0";
//        	int expectedSize = 1;
//        	String actualName = nav.graph.getLegendListItem(0).getText();
//        	int actualSize = nav.graph.getLegendList().size();
//        	assertEquals(expectedName, actualName);
//        	assertEquals(expectedSize, actualSize);
//        }
//        
//        @Test
//        public void test_FilterCleanUp(){
//        	nav.suite.filterOn("random");
//        	nav.suite.clickOnBar("class", "0");
//        	String expected = "";
//        	String actual = nav.suite.getFilterFieldText();
//        	assertEquals(expected, actual);
//        }
//        
//        @Test
//        public void test_FilterOnChrome(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.suite.clickOnBar("method", "0");
//        	nav.suite.filterOn("chrome");
//        	int expected = 8;
//        	int actual = nav.suite.getSizeOfCaseList();
//        	nav.suite.waitForCaseListSize(expected);
//        	assertEquals(expected, actual);
//        }  
//        
//        @Test
//        public void test_ClickOnSuiteLink(){
//        	nav.suite.ClickOnSuiteLinkText();
//        	String actual = nav.graph.getUrl();
//        	assertTrue(actual.endsWith("/#/home"));
//        }
//        
//	    @Test
//	    public void test_ClickOnClassLink(){
//	    	nav.suite.clickOnBar("class", "0");
//	    	nav.suite.ClickOnSuiteLinkText();
//	    	String actual = nav.graph.getUrl();
//	    	assertTrue(actual.endsWith("/#/reports/classes"));
//	    }
//	    
//	    @Test
//	    public void test_clickOnMethodLink(){
//	    	nav.suite.clickOnBar("class", "0");
//	    	nav.suite.clickOnBar("method", "0");
//	    	nav.suite.ClickOnSuiteLinkText();
//	    	String actual = nav.graph.getUrl();
//	    	assertTrue(actual.endsWith("/#/reports/methods"));
//	    }
	    
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
	    
	    
	    
//	    @Test
//	    public void test_hej5(){
//	    	nav.option.changeDisplayType("Total Fail");
//	    	nav.option.changeBreakPoint("Browser");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej6(){
//	    	nav.option.changeDisplayType("Total Pass");
//	    	nav.option.changeBreakPoint("Browser");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej7(){
//	    	nav.option.changeDisplayType("Pass/Fail");
//	    	nav.option.changeBreakPoint("Browser");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej8(){
//	    	nav.option.changeDisplayType("Run Time");
//	    	nav.option.changeBreakPoint("Version");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej9(){
//	    	nav.option.changeDisplayType("Total Fail");
//	    	nav.option.changeBreakPoint("Version");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej10(){
//	    	nav.option.changeDisplayType("Total Pass");
//	    	nav.option.changeBreakPoint("Version");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej11(){
//	    	nav.option.changeDisplayType("Pass/Fail");
//	    	nav.option.changeBreakPoint("Version");
//	    	nav.option.reloadGraph();
//	    }
//        
//	    @Test
//	    public void test_hej12(){
//	    	nav.option.changeDisplayType("Run Time");
//	    	nav.option.changeBreakPoint("Device");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej13(){
//	    	nav.option.changeDisplayType("Total Fail");
//	    	nav.option.changeBreakPoint("Device");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej14(){
//	    	nav.option.changeDisplayType("Total Pass");
//	    	nav.option.changeBreakPoint("Device");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej15(){
//	    	nav.option.changeDisplayType("Pass/Fail");
//	    	nav.option.changeBreakPoint("Device");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej16(){
//	    	nav.option.changeDisplayType("Run Time");
//	    	nav.option.changeBreakPoint("Platform");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej17(){
//	    	nav.option.changeDisplayType("Total Fail");
//	    	nav.option.changeBreakPoint("Platform");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej18(){
//	    	nav.option.changeDisplayType("Total Pass");
//	    	nav.option.changeBreakPoint("Platform");
//	    	nav.option.reloadGraph();
//	    }
//	    
//	    @Test
//	    public void test_hej19(){
//	    	nav.option.changeDisplayType("Pass/Fail");
//	    	nav.option.changeBreakPoint("Platform");
//	    	nav.option.reloadGraph();
//	    }
	    
	    @Test
	    public void test_ClearCheckBoxesBrowser(){
	    	nav.option.changeBreakPoint("Browser");
	    	nav.option.clickSpecifications();
	    	nav.option.checkBrowser("chrome");
	    	nav.option.clickClearCheckBoxes();
	    	nav.option.reloadGraph();
	    	int expected = 2;
	    	int actual = nav.graph.getLegendList().size();
	    	assertEquals(expected, actual);
	    }
	    
	    @Test
	    public void test_ClearCheckBoxesPlatform(){
	    	nav.option.changeBreakPoint("Platform");
	    	nav.option.clickSpecifications();
	    	nav.option.clickPlatform("Android");
	    	nav.option.clickClearCheckBoxes();
	    	nav.option.reloadGraph();
	    	int expected = 3;
	    	int actual = nav.graph.getLegendList().size();
	    	assertEquals(expected, actual);
	    }
	    
	    @Test
	    public void test_ClearCheckBoxesVersion(){
	    	nav.option.changeBreakPoint("Version");
	    	nav.option.clickSpecifications();
	    	nav.option.clickPlatform("Android");
	    	nav.option.checkVersion("4.4.4");
	    	nav.option.clickClearCheckBoxes();
	    	nav.option.reloadGraph();
	    	int expected = 4;
	    	int actual = nav.graph.getLegendList().size();
	    	assertEquals(expected, actual);
	    }
	    
	    @Test
	    public void test_ClearCheckBoxesDevice(){
	    	nav.option.changeBreakPoint("Device");
	    	nav.option.clickSpecifications();
	    	nav.option.clickPlatform("Android");
	    	nav.option.checkDevice("HTC ONE");
	    	nav.option.clickClearCheckBoxes();
	    	nav.option.reloadGraph();
	    	int expected = 4;
	    	int actual = nav.graph.getLegendList().size();
	    	assertEquals(expected, actual);
	    }
	    
	    @Test
	    public void test_checkShowingNumberResultsTen(){
	    	nav.option.changeChartSuiteRunLimit("10");
	    	nav.option.reloadGraph();
	    	nav.option.checkShowingNumberResults();
	    	String expected = "Showing 10 results";
	    	String actual = nav.option.checkShowingNumberResults();
	    	assertEquals(expected, actual);
	    }
	    
	    @Test
	    public void test_checkShowingNumberResultsTwenty(){
	    	nav.option.changeChartSuiteRunLimit("20");
	    	nav.option.reloadGraph();
	    	nav.option.checkShowingNumberResults();
	    	String expected = "Showing 20 results";
	    	String actual = nav.option.checkShowingNumberResults();
	    	assertEquals(expected, actual);
	    }
	    
	    @Test
	    public void test_checkShowingNumberResultsFifty(){
	    	nav.option.changeChartSuiteRunLimit("50");
	    	nav.option.reloadGraph();
	    	nav.option.checkShowingNumberResults();
	    	String expected = "Showing 50 results";
	    	String actual = nav.option.checkShowingNumberResults();
	    	assertEquals(expected, actual);
	    }
	    
	    @Test
	    public void test_checkShowingNumberResultsOneHundred(){
	    	nav.option.changeChartSuiteRunLimit("100");
	    	nav.option.reloadGraph();
	    	nav.option.checkShowingNumberResults();
	    	String expected = "Showing 50 results";
	    	String actual = nav.option.checkShowingNumberResults();
	    	assertEquals(expected, actual);
	    }
	    
	    @Test
	    public void test_checkShowingNumberResultsFiveHundred(){
	    	nav.option.changeChartSuiteRunLimit("500");
	    	nav.option.reloadGraph();
	    	nav.option.checkShowingNumberResults();
	    	String expected = "Showing 50 results";
	    	String actual = nav.option.checkShowingNumberResults();
	    	assertEquals(expected, actual);
	    }
	    
	    @Test
	    public void test_checkLegendListDownButton(){
	    	for (int i = 0; i < 19; i++) {
	    		nav.option.addToGraph();
			}
	    	String before = nav.graph.getListNumber();
	    	nav.graph.clickDownArrow();
	    	String after = nav.graph.getListNumber();
	    	assertNotEquals(before, after);
	    }
	    
	    @Test
	    public void test_checkLegendListUpButton(){
	    	for (int i = 0; i < 19; i++) {
	    		nav.option.addToGraph();
			}
	    	nav.graph.clickDownArrow();
	    	String before = nav.graph.getListNumber();
	    	nav.graph.clickUpArrow();
	    	String after = nav.graph.getListNumber();
	    	assertNotEquals(before, after);
	    }

}
