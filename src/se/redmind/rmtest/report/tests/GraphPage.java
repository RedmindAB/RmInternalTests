package se.redmind.rmtest.report.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
import se.redmind.rmtest.report.utils.ErrorMsg;
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
	    
//		ID: REP-A.01.01
//	    Edited 2015-06-09
	    @Test
	    public void test_ShowPassFail() {
	    	String expected = "Percentage of passed tests";
	    	WebElement chartTitle1 = nav.getChartTitle();
	    	assertEquals(ErrorMsg.ChartTitleIsDifferent + "1 \n", expected, chartTitle1.getText());
	    	nav.option.changeDisplayType("Total Fail");
	    	WebElement chartTitle2 = nav.getChartTitle();
	    	assertNotEquals(ErrorMsg.ChartTitleIsSame+"2 \n", expected, chartTitle2.getText());
	    	nav.option.changeDisplayType("Pass/Fail");
	    	WebElement chartTitle3 = nav.getChartTitle();
	    	assertEquals(ErrorMsg.ChartTitleIsDifferent+"3 \n", expected, chartTitle3.getText());
	    }
	    
//		ID: REP-A.01.02
//	    Edited 2015-06-09
	    @Test
	    public void test_TotalPass(){
	    	nav.option.changeDisplayType("Total Pass");
	    	String expected = "Passed tests";
	    	WebElement chartTitle1 = nav.getChartTitle();
	    	assertEquals(ErrorMsg.ChartTitleIsDifferent + "1 \n", expected, chartTitle1.getText());
	    }
	    
//		ID: REP-A.01.03
//	    Edited 2015-06-09
	    @Test
	    public void test_TotalFailed(){
	    	nav.option.changeDisplayType("Total Fail");
	    	String expected = "Failed tests";
	    	WebElement chartTitle1 = nav.getChartTitle();
	    	assertEquals(ErrorMsg.ChartTitleIsDifferent + "1 \n", expected, chartTitle1.getText());
	    }
	    
//		ID: REP-A.01.04
//	    Last edited 2015-06-09
	    @Test
	    public void test_RunTime(){
	    	nav.option.changeDisplayType("Run Time");
	    	String expected = "Time to run in seconds";
	    	WebElement chartTitle1 = nav.getChartTitle();
	    	assertEquals(ErrorMsg.ChartTitleIsDifferent + "1 \n", expected, chartTitle1.getText());
	    }
	    
//		ID: REP-A.01.05
//	    Last edited 2015-06-09
	    @Test
	    public void test_CreateALine(){
	    	String expectedName1 = "Aggregation";
	    	String actualName1 = nav.graph.getLegendListItem(0).getText();
	    	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName1, actualName1);
	    	nav.option.changeBreakPoint("None");
	    	nav.option.reloadGraph();
	    	String expectedName2 = nav.graph.getProjectName(0).getText();
	    	String actualName2 = nav.graph.getLegendListItem(0).getText();
	    	assertEquals(ErrorMsg.LegendListTextIsDifferent + "2 \n", expectedName2, actualName2);
	    	int expectedSize = 1;
	    	int actualSize = nav.graph.getLegendList().size();
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
	    }
	    
//		ID: REP-A.01.06
//	    Last edited 2015-06-09
	    @Test
	    public void test_BreakOnBrowser(){
	    	nav.option.changeBreakPoint("Browser");
	    	nav.option.reloadGraph();
	    	String expectedName = "firefox v.31";
	    	String actualName = nav.graph.getLegendListItem(0).getText();
	    	int expectedSize = 2;
	    	int actualSize = nav.graph.getLegendList().size();
	    	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
    	}
	    
//		ID: REP-A.01.07
//	    Last edited 2015-06-09
        @Test
	    public void test_BreakOnVersion(){
	    	nav.option.changeBreakPoint("Version");
	    	nav.option.reloadGraph();
	    	String expectedName = "Android 4.4.4";
	    	String actualName = nav.graph.getLegendListItem(0).getText();
	    	int expectedSize = 4;
	    	int actualSize = nav.graph.getLegendList().size();
	    	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
	    }
	    
//		ID: REP-A.01.08
//	    Last edited 2015-06-09
        @Test
	    public void test_BreakOnDevice(){
	    	nav.option.changeBreakPoint("Device");
	    	nav.option.reloadGraph();
	    	String expectedName = "HTC ONE";
	    	String actualName = nav.graph.getLegendListItem(0).getText();
	    	int expectedSize = 4;
	    	int actualSize = nav.graph.getLegendList().size();
	    	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
	    }
	    
//		ID: REP-A.01.09
//	    Last edited 2015-06-09
        @Test
	    public void test_BreakOnPlatform(){
        	nav.option.changeBreakPoint("Platform");
        	nav.option.reloadGraph();
        	String expectedName = "Android";
	    	String actualName = nav.graph.getLegendListItem(0).getText();
	    	int expectedSize = 3;
	    	int actualSize = nav.graph.getLegendList().size();
	    	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
	    }
	    
//		ID: REP-A.01.10
//	    Last edited 2015-06-09
        @Test
	    public void test_RemoveALine(){
        	nav.option.changeBreakPoint("Platform");
        	nav.option.reloadGraph();
        	nav.option.removeGraphLine("Android");
        	String expectedName1 = "IOS";
        	String actualName1 = nav.graph.getLegendListItem(0).getText();
        	String expectedName2 = "Ubuntu";
        	String actualName2 = nav.graph.getLegendListItem(1).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	int expectedSize = 2;
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName1, actualName1);
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "2 \n",expectedName2, actualName2);
        	assertEquals(ErrorMsg.LegendListSize,expectedSize, actualSize);	
	    }    
	    
//		ID: REP-A.01.19
//	    Last edited 2015-06-10
        @Test
	    public void test_SpecificationsDevice_CheckDevice(){
        	nav.option.changeBreakPoint("Device");
        	nav.option.clickSpecifications();
        	nav.option.clickPlatform("Android");
        	nav.option.checkDevice("HTC ONE");
        	nav.option.reloadGraph();
        	String expectedName = "HTC ONE";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
	    }

//		ID: REP-A.01.20
//	    Last edited 2015-06-10
        @Test
	    public void test_SpecificationsDevice_CheckVersion(){
        	nav.option.changeBreakPoint("Device");
        	nav.option.clickSpecifications();
        	nav.option.clickPlatform("Android");
        	nav.option.checkVersion("4.4.4");
        	nav.option.reloadGraph();
        	String expectedName = "HTC ONE";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
	    }

//		ID: REP-A.01.21
//	    Last edited 2015-06-10
        @Test
        public void test_SpecificationsDevice_CheckPlatform(){
        	nav.option.changeBreakPoint("Device");
        	nav.option.clickSpecifications();
        	nav.option.clickPlatform("Android");
        	nav.option.reloadGraph();
        	String expectedName1 = "HTC ONE";
        	String expectedName2 = "Nexus 6";
        	int expectedSize = 2;
        	String actualName1 = nav.graph.getLegendListItem(0).getText();
        	String actualName2 = nav.graph.getLegendListItem(1).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName1, actualName1);
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n",expectedName2, actualName2);
        	assertEquals(ErrorMsg.LegendListSize,expectedSize, actualSize);	
        	
        }

//		ID: REP-A.01.22
//	    Last edited 2015-06-10
        @Test
	    public void test_Specifications_CheckDeviceGetVersion(){
        	nav.option.changeBreakPoint("Version");
        	nav.option.clickSpecifications();
        	nav.option.clickPlatform("Android");
        	nav.option.checkDevice("HTC ONE");
        	nav.option.reloadGraph();
        	String expectedName = "Android 4.4.4";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
	    }

//		ID: REP-A.01.23
//	    Last edited 2015-06-10
        @Test
	    public void test_Specifications_Version(){
        	nav.option.changeBreakPoint("Version");
        	nav.option.clickSpecifications();
        	nav.option.clickPlatform("Android");
        	nav.option.checkVersion("4.4.4");
        	nav.option.reloadGraph();
        	String expectedName = "Android 4.4.4";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent  + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
	    }

//		ID: REP-A.01.24
//	    Last edited 2015-06-10
        @Test
  	    public void test_Specifications_VersionPlatform(){
          	nav.option.changeBreakPoint("Version");
          	nav.option.clickSpecifications();
          	nav.option.clickPlatform("Android");
          	nav.option.reloadGraph();
          	String expectedName1 = "Android 4.4.4";
        	String expectedName2 = "Android 5.1";
        	int expectedSize = 2;
        	String actualName1 = nav.graph.getLegendListItem(0).getText();
        	String actualName2 = nav.graph.getLegendListItem(1).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName1, actualName1);
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "2 \n",expectedName2, actualName2);
        	assertEquals(ErrorMsg.LegendListSize,expectedSize, actualSize);	         	
  	    }

//		ID: REP-A.01.25
//	    Last edited 2015-06-10        
        @Test
	    public void test_Specifications_CheckDeviceGetPlatform(){
        	nav.option.changeBreakPoint("Platform");
        	nav.option.clickSpecifications();
        	nav.option.clickPlatform("Android");
        	nav.option.checkDevice("HTC ONE");
        	nav.option.reloadGraph();
         	String expectedName = "Android";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
	    }

//		ID: REP-A.01.26
//	    Last edited 2015-06-10  
        @Test
	    public void test_Specifications_Platform(){
        	nav.option.changeBreakPoint("Platform");
        	nav.option.clickSpecifications();
        	nav.option.clickPlatform("Android");
        	nav.option.reloadGraph();
         	String expectedName = "Android";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
	    }
        
//		ID: REP-A.01.27
//	    Last edited 2015-06-10  
        @Test
 	    public void test_Specifications_PlatformVersion(){
         	nav.option.changeBreakPoint("Platform");
         	nav.option.clickSpecifications();
         	nav.option.clickPlatform("Android");
         	nav.option.checkVersion("4.4.4");
         	nav.option.reloadGraph();
         	String expectedName = "Android";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
        }
        
//		ID: REP-A.01.28
//	    Edited: 2015-06-10  
        @Test
 	    public void test_SpecificationsPlatform_CheckAndroidIOS(){
         	nav.option.changeBreakPoint("Platform");
         	nav.option.clickSpecifications();
         	nav.option.clickPlatform("Android");
         	nav.option.clickPlatform("IOS");
         	nav.option.reloadGraph();
         	String expectedName1 = "Android";
         	String expectedName2 = "IOS";
        	int expectedSize = 2;
        	nav.graph.waitForLegendListSize(expectedSize);
        	String actualName1 = nav.graph.getLegendListItem(0).getText();
        	String actualName2 = nav.graph.getLegendListItem(1).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName1, actualName1);
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "2 \n",expectedName2, actualName2);
        	assertEquals(ErrorMsg.LegendListSize,expectedSize, actualSize);	
        }

//		ID: REP-A.01.29
//	    Edited: 2015-06-10  	    
        @Test
        public void test_SpecificationsBrowser_CheckChrome(){
        	nav.option.changeBreakPoint("Browser");
        	nav.option.clickSpecifications();
        	nav.option.checkBrowser("chrome");
        	nav.option.reloadGraph();
        	String expectedName = "chrome v.42";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
	    	assertEquals(ErrorMsg.LegendListSize, expectedSize, actualSize);
        }
        
//      Ignored for time being because it does the same thing as ID: VIS-A.01.02, waiting for more fluctuent test data
        
        /* ID: REP-A.01.34
         * Edited: 2015-06-11
         */
		@Ignore
        @Test
        public void test_ChooseTimeStampFromDropDrown() {
        	nav.chooseTimestampFromDropdown("2015-02-10 08:00");
        	WebElement currentTimeStamp = nav.getElementByID("choose_timestamp");
        	assertEquals("2015-02-10 08:00", currentTimeStamp.getText());
        }
        
        /* ID: REP-A.01.30
         * Edited: 2015-06-11
         */
        @Test
        public void test_ClickOnSuiteLink(){
        	nav.suite.ClickOnSuiteLinkText();
        	String actual = nav.graph.getUrl();
        	assertTrue(ErrorMsg.PageRedirect, actual.endsWith("/#/home"));
        }
        
        /* ID: REP-A.01.31
         * Edited: 2015-06-11
         */
	    @Test
	    public void test_ClearCheckBoxesBrowser(){
	    	nav.option.changeBreakPoint("Browser");
	    	nav.option.clickSpecifications();
	    	nav.option.checkBrowser("chrome");
	    	nav.option.clickClearCheckBoxes();
	    	nav.option.reloadGraph();
	    	int expected = 2;
	    	int actual = nav.graph.getLegendList().size();
	    	assertEquals(ErrorMsg.LegendListSize, expected, actual);
	    }
	    
	    /* ID: REP-A.01.32
         * Edited: 2015-06-11
         */
	    @Test
	    public void test_ClearCheckBoxesPlatform(){
	    	nav.option.changeBreakPoint("Platform");
	    	nav.option.clickSpecifications();
	    	nav.option.clickPlatform("Android");
	    	nav.option.clickClearCheckBoxes();
	    	nav.option.reloadGraph();
	    	int expected = 3;
	    	int actual = nav.graph.getLegendList().size();
	    	assertEquals(ErrorMsg.LegendListSize, expected, actual);
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
	    	assertEquals(ErrorMsg.LegendListSize, expected, actual);
	    }
	    
	    /* ID: REP-A.01.33
         * Edited: 2015-06-11
         */
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
	    	assertEquals(ErrorMsg.LegendListSize,expected, actual);
	    }
	    
//		ID: REP-A.01.11
//	    Last edited 2015-06-10
	    @Test
	    public void test_changeRunLimit_10(){
	    	nav.option.changeChartSuiteRunLimit("10");
	    	nav.option.reloadGraph();
	    	String expected = "Showing 10 results";
	    	String actual = nav.option.checkShowingNumberResults();
	    	assertEquals(ErrorMsg.HighchartsSubTitle, expected, actual);
	    }
	    
//		ID: REP-A.01.12
//	    Last edited 2015-06-10
	    @Test
	    public void test_changeRunLimit_20(){
	    	nav.option.changeChartSuiteRunLimit("20");
	    	nav.option.reloadGraph();
	    	String expected = "Showing 20 results";
	    	String actual = nav.option.checkShowingNumberResults();
	    	assertEquals(ErrorMsg.HighchartsSubTitle, expected, actual);
	    }
	    
//		ID: REP-A.01.13
//	    Last edited 2015-06-10
	    @Test
	    public void test_changeRunLimit_50(){
	    	nav.option.changeChartSuiteRunLimit("50");
	    	nav.option.reloadGraph();
	    	String expected = "Showing 50 results";
	    	String actual = nav.option.checkShowingNumberResults();
	    	assertEquals(ErrorMsg.HighchartsSubTitle, expected, actual);
	    }
	    
//		ID: REP-A.01.14
//	    Last edited 2015-06-10
	    @Test
	    public void test_changeRunLimit_100(){
	    	nav.option.changeChartSuiteRunLimit("100");
	    	nav.option.reloadGraph();
	    	String expected = "Showing 50 results";
	    	String actual = nav.option.checkShowingNumberResults();
	    	assertEquals(ErrorMsg.HighchartsSubTitle, expected, actual);
	    }
	    
//		ID: REP-A.01.15
//	    Last edited 2015-06-10
	    @Test
	    public void test_changeRunLimit_500(){
	    	new RMReportScreenshot(urlContainer).takeScreenshot("BeforeSearch");
	    	nav.option.changeChartSuiteRunLimit("500");
	    	nav.option.reloadGraph();
//	    	nav.option.checkShowingNumberResults();
	    	String expected = "Showing 50 results";
	    	String actual = nav.option.checkShowingNumberResults();
	    	new RMReportScreenshot(urlContainer).takeScreenshot("AfterSearch");
	    	assertEquals(ErrorMsg.HighchartsSubTitle, expected, actual);
	    }

//		ID: REP-A.01.16
//	    Last edited 2015-06-10
	    @Test
	    public void test_clickLegendListDownButton(){
	    	for (int i = 0; i < 19; i++) {
	    		nav.option.addToGraph();
			}
	    	String before = nav.graph.getListNumber();
	    	nav.graph.clickDownArrow();
	    	String after = nav.graph.getListNumber();
	    	assertNotEquals(ErrorMsg.LegendListDown, before, after);
	    }

//		ID: REP-A.01.17
//	    Last edited 2015-06-10
	    @Test
	    public void test_clickLegendListUpButton(){
	    	for (int i = 0; i < 19; i++) {
	    		nav.option.addToGraph();
			}
	    	nav.graph.clickDownArrow();
	    	String before = nav.graph.getListNumber();
	    	nav.graph.clickUpArrow();
	    	String after = nav.graph.getListNumber();
	    	assertNotEquals(ErrorMsg.LegendListUp, before, after);
	    }
	    
	    /* ID: REP-A.01.35
         * Edited: 2015-06-11
         */
	    @Test
	    public void test_AddChoicesToGraph(){
	    	nav.option.addToGraph();
	    	int expected = 2;
	    	int actual = nav.graph.getLegendList().size();
	    	assertEquals(ErrorMsg.LegendListSize,expected, actual);
	    }

//	    ID: REP-A.01.36
//	    Edited: 2015-06-15
	    @Test
	    public void test_totalPassDifferentColors(){
	    
	    	nav.option.changeBreakPoint("Browser");
	    	nav.option.addToGraph();
	    	nav.option.changeDisplayType("Total Pass");
	    	List<String> colors = nav.graph.getLegendListColors();
	    	System.out.println(colors.toString());
	    	int expectedsize = 3;
	    	int actualsize = colors.size();
	    	assertEquals(ErrorMsg.LegendListSize, expectedsize, actualsize);
	    	HashSet<String> colorset = new HashSet<String>(colors);
	    	assertEquals(ErrorMsg.HashSetSizeIsDifferent, expectedsize,colorset.size());
	    	
	    }
	    
}