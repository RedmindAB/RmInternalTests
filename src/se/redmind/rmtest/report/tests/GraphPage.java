package se.redmind.rmtest.report.tests;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	    	return DriverProvider.getDrivers(Platform.MAC);

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
//	    public void nrSuiteRunsPresent(){
//	    	boolean displayed = nav.getNumberOfSuiteRunsButton().isDisplayed();
//	    	assertTrue(displayed);
//	    }
//	    
//	    @Test
//	    public void nrAddGraphLinePresent(){
//	    	boolean displayed = nav.getAddGraphLine().isDisplayed();
//	    	assertTrue(displayed);
//	    }
//	    
//	    @Test
//	    public void reloadButtonPresent(){
//	    	boolean displayed = nav.getReload().isDisplayed();
//	    	assertTrue(displayed);
//	    }
//
//	    @Test
//	    public void chooseGraphViewPresent(){
//	    	boolean displayed = nav.getChooseGraphView().isDisplayed();
//	    	assertTrue(displayed);
//	    }
//	    
//	    @Test
//	    public void chooseBreakPointPresent(){
//	    	boolean displayed = nav.getChooseBreakPoint().isDisplayed();
//	    	assertTrue(displayed);
//	    }
//	    
//	    @Test
//	    public void assertChartSizeTo50(){
//	    	Chart chart = nav.getChart();
//	    	assertEquals(50, chart.getGraphResultSize());
//	    }
//	    
//	    @Test
//	    public void assertChartSizeTo100(){
//	    	nav.changeChartSuiteRunLimit(100);
//	    	nav.reloadGraph();
//	    	Chart chart = nav.getChart();
//	    	chart.getGraphResultSize();
//	    	assertEquals(100, chart.getGraphResultSize());
//	    }
//	    
//	    @Test
//	    public void assertChartSizeTo10(){
//	    	nav.changeChartSuiteRunLimit(10);
//	    	nav.reloadGraph();
//	    	Chart chart = nav.getChart();
//	    	chart.getGraphResultSize();
//	    	assertEquals(10, chart.getGraphResultSize());
//	    }
//	    
//	    @Test
//	    public void assertChartSizeTo20(){
//	    	nav.changeChartSuiteRunLimit(20);
//	    	nav.reloadGraph();
//	    	Chart chart = nav.getChart();
//	    	chart.getGraphResultSize();
//	    	assertEquals(20, chart.getGraphResultSize());
//	    }
//	    
//	    @Test
//	    public void assertChartSizeTo200(){
//	    	nav.changeChartSuiteRunLimit(500);
//	    	nav.reloadGraph();
//	    	//There are only 200 results in this suite, so the result should be 200
//	    	assertEquals(200, nav.getChart().getGraphResultSize());
//	    }
//	    
//	    @Test
//	    public void getCharVariant() throws InterruptedException{
//	    	nav.changeDisplayType("Total Fail");
//	    	WebElement title = nav.getChartTitle();
//	    	Thread.sleep(10000);
//	    	
//	    }
	    
	    
//	    @Test
//	    public void test() throws InterruptedException{
//	    	nav.suite.clickOnBar("class", "0");
//	    	nav.suite.clickOnBar("method", "0");
//	    	nav.suite.clickThisTestOnly("0");
//	    	Thread.sleep(10000);
//	    }
//	    
	//    Mina!
	    

//	    
	    @Test
	    public void test_LoadTwentyRuns() {
	    	nav.graph.changeChartSuiteRunLimit("20");
	    	nav.graph.reloadGraph();
		    WebElement chartSub = nav.getChartSubtitle();
		    assertEquals("Showing 20 results", chartSub.getText());
		    }
	    
	    @Test 
	    public void test_LoadTenRuns() {
	    	nav.graph.changeChartSuiteRunLimit("10");
	    	nav.graph.reloadGraph();
	    	WebElement chartSub = nav.getChartSubtitle();
	    	assertEquals("Showing 10 results", chartSub.getText());
	    }
    
	    
	    @Test
	    public void test_ShowPassFaill() {
	    	String expected = "Percentage of passed tests";
	    	WebElement chartTitle1 = nav.getChartTitle();
	    	assertEquals(expected, chartTitle1.getText());
	    	nav.graph.changeDisplayType("Total Fail");
	    	WebElement chartTitle2 = nav.getChartTitle();
	    	assertNotEquals(expected, chartTitle2.getText());
	    	nav.graph.changeDisplayType("Pass/Fail");
	    	WebElement chartTitle3 = nav.getChartTitle();
	    	assertEquals(expected, chartTitle3.getText());
	    }
	    
	    @Test
	    public void test_TotalPass(){
	    	nav.graph.changeDisplayType("Total Pass");
	    	String expected = "Passed tests";
	    	WebElement chartTitle1 = nav.getChartTitle();
	    	assertEquals(expected, chartTitle1.getText());
	    }
	    
	    @Test
	    public void test_TotalFailed(){
	    	nav.graph.changeDisplayType("Total Fail");
	    	String expected = "Failed tests";
	    	WebElement chartTitle1 = nav.getChartTitle();
	    	assertEquals(expected, chartTitle1.getText());
	    }
	    
	    @Test
	    public void test_RunTime(){
	    	nav.graph.changeDisplayType("Run Time");
	    	String expected = "Time to run in seconds";
	    	WebElement chartTitle1 = nav.getChartTitle();
	    	assertEquals(expected, chartTitle1.getText());
	    }
	    
//	    @Test
//	    public void test_CreateALine(){
//	    	nav.graph.addToGraph();
//	    }
//	    
//	    @Test
//	    public void test_CreateALine_Browser(){
//	    	nav.graph.changeBreakPoint("Browser");
//	    	nav.graph.reloadGraph();
//    	}
//    	
//        @Test
//	    public void test_CreateALine_Version(){
//	    	nav.graph.changeBreakPoint("Version");
//	    	nav.graph.reloadGraph();
//	    }
//        
//        @Test
//	    public void test_CreateALine_Device(){
//	    	nav.graph.changeBreakPoint("Device");
//	    	nav.graph.reloadGraph();
//	    }
//        
//        @Test
//	    public void test_CreateALine_Platform(){
//        	nav.graph.changeBreakPoint("Platform");
//        	nav.graph.reloadGraph();
//	    }
//	    
//        @Test
//	    public void test_RemoveALine(){
//        	nav.graph.changeBreakPoint("Platform");
//        	nav.graph.reloadGraph();
//        	nav.graph.removeGraphLine("Android");	
//	    }
//        
//      @Test
//	    public void test_DeviceNone(){
//        	nav.graph.changeBreakPoint("Device");
//        	nav.graph.reloadGraph();
//	    }
//    
//        @Test
//	    public void test_Specifications_Device(){
//        	nav.graph.changeBreakPoint("Device");
//        	nav.graph.clickSpecifications();
//        	nav.graph.clickPlatform("Android");
//        	nav.graph.checkDevice("HTC ONE");
//        	nav.graph.reloadGraph();
//	    }
//	    
//        @Test
//	    public void test_Specifications_CheckVersionGetDevice(){
//        	nav.graph.changeBreakPoint("Device");
//        	nav.graph.clickSpecifications();
//        	nav.graph.clickPlatform("Android");
//        	nav.graph.checkVersion("4.4.4");
//        	nav.graph.reloadGraph();
//	    }
//        
//        @Test
//        public void test_Specifications_CheckPlatformGetDevice(){
//        	nav.graph.changeBreakPoint("Device");
//        	nav.graph.clickSpecifications();
//        	nav.graph.clickPlatform("Android");
//        	nav.graph.reloadGraph();
//        }
//        
//        @Test
//  	    public void test_VersionNone(){
//          	nav.graph.changeBreakPoint("Version");
//          	nav.graph.reloadGraph();
//  	    }
//	    
//        @Test
//	    public void test_Specifications_CheckDeviceGetVersion(){
//        	nav.graph.changeBreakPoint("Version");
//        	nav.graph.clickSpecifications();
//        	nav.graph.clickPlatform("Android");
//        	nav.graph.checkDevice("HTC ONE");
//        	nav.graph.reloadGraph();
//	    }
//        
//        @Test
//	    public void test_Specifications_Version(){
//        	nav.graph.changeBreakPoint("Version");
//        	nav.graph.clickSpecifications();
//        	nav.graph.clickPlatform("Android");
//        	nav.graph.checkVersion("4.4.4");
//        	nav.graph.reloadGraph();
//	    }
//        
//        @Test
//  	    public void test_Specifications_VersionPlatform(){
//          	nav.graph.changeBreakPoint("Version");
//          	nav.graph.clickSpecifications();
//          	nav.graph.clickPlatform("Android");
//          	nav.graph.reloadGraph();
//  	    }
//        
//        @Test
//	    public void test_PlatformNone(){
//        	nav.graph.changeBreakPoint("Platform");
//        	nav.graph.reloadGraph();
//        }
//        
//        @Test
//	    public void test_Specifications_CheckDeviceGetPlatform(){
//        	nav.graph.changeBreakPoint("Platform");
//        	nav.graph.clickSpecifications();
//        	nav.graph.clickPlatform("Android");
//        	nav.graph.checkDevice("HTC ONE");
//        	nav.graph.reloadGraph();
//	    }
//        
//        @Test
//	    public void test_Specifications_Platform(){
//        	nav.graph.changeBreakPoint("Platform");
//        	nav.graph.clickSpecifications();
//        	nav.graph.clickPlatform("Android");
//        	nav.graph.reloadGraph();
//	    }
//        
//        
//        @Test
// 	    public void test_Specifications_PlatformVersion(){
//         	nav.graph.changeBreakPoint("Platform");
//         	nav.graph.clickSpecifications();
//         	nav.graph.clickPlatform("Android");
//         	nav.graph.checkVersion("4.4.4");
//         	nav.graph.reloadGraph();
// 	    }
//        
//	    
//        @Test
//        public void test_Specifications_Browser(){
//        	nav.graph.changeBreakPoint("Browser");
//        	nav.graph.clickSpecifications();
//        	nav.graph.checkBrowser("chrome");
//        	nav.graph.reloadGraph();
//        }
//        
//        @Test
//	    public void test_BrowserNone(){
//        	nav.graph.changeBreakPoint("Browser");
//        	nav.graph.reloadGraph();
//        }
//        
        @Test
        public void test_OrderByFailPass () {
        	String before = nav.suite.getNameFrom("class", "0");
        	nav.suite.clickFailPass();
        	String after = nav.suite.getNameFrom("class", "0");
        	assertNotEquals(before, after);
        }
        
        @Test
        public void test_ChooseTimeStampFromDropDrown() {
        	nav.suite.chooseTimestampFromDropdown("20150210080040");
        	WebElement currentTimeStamp = tDriver.findElement(By.id("choose_timestamp"));
        	assertEquals("20150210080040", currentTimeStamp.getText());
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
//        
//        @Test
//        public void test_ClickOnThisTestOnly(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.suite.clickOnBar("method", "0");
//        	nav.suite.clickThisTestOnly("0");
//        }
//        
//        @Test
//        public void test_ClickOnCase(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.suite.clickOnBar("method", "0");
//        	nav.suite.clickOnBar("case", "0");
//        }
//        
//        @Test
//        public void test_ClickOnLastCase(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.suite.clickOnBar("method", "0");
//        	nav.suite.clickOnBar("case", "7");
//        }
//        
//        @Test 
//        public void test_CheckClass(){
//        	nav.suite.checkBoxOn("class", "0");
//        	nav.graph.reloadGraph();
//        }
//        
//        @Test 
//        public void test_CheckMethod(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.suite.checkBoxOn("method", "0");
//        	nav.graph.reloadGraph();
//        }
//        
//        @Test 
//        public void test_ClickOnClassReload(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.graph.reloadGraph();
//        }
//        
//        @Test
//        public void test_FilterCleanUp(){
//        	nav.suite.filterOn("random");
//        	nav.suite.clickOnBar("class", "0");
//        }
//        
//        @Test
//        public void test_FilterOnChrome(){
//        	nav.suite.clickOnBar("class", "0");
//        	nav.suite.clickOnBar("method", "0");
//        	nav.suite.filterOn("chrome");
//        }
        
}
