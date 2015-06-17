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
import se.redmind.rmtest.report.utils.ErrorMsg;
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
	    
	    /* ID:REP-A.02.01
	     * Edited: 2015-06-11
	     */
        @Test
        public void test_OrderByFailPass () {
        	String before = nav.suite.getNameFrom("class", "0");
        	nav.suite.clickFailPass();
        	String after = nav.suite.getNameFrom("class", "0");
        	assertNotEquals(ErrorMsg.ClassBarTextIsSame + "1 \n" + "Before:\n" + before + "\n" + "After:\n" + after + "\n", before, after);
        }
        
        /* ID:REP-A.02.16
	     * Edited: 2015-06-11
	     */
        @Test
        public void test_GoToMethods(){
        	String className  = nav.suite.getNameFrom("class", "0");
        	nav.suite.clickOnBar("class", "0");
        	assertEquals(ErrorMsg.ClassNameIsDifferent + "1 \n", className, nav.suite.getCurrentPossition().getText());
        }
        
        /* ID:REP-A.02.15
	     * Edited: 2015-06-11
	     */
        @Test
        public void test_GoToCases(){
        	nav.suite.clickOnBar("class", "0");
        	String methodName = nav.suite.getNameFrom("method", "0");
        	nav.suite.clickOnBar("method", "0");
        	assertEquals(ErrorMsg.MethodNameIsDifferent + "1 \n", methodName, nav.suite.getCurrentPossition().getText());
        }
        
        /* ID:REP-A.02.04
	     * Edited: 2015-06-11
	     */
        @Test
        public void test_ClickOnThisTestOnly(){
        	nav.suite.clickOnBar("class", "0");
        	nav.suite.clickOnBar("method", "0");
        	//System.out.println(nav.suite.getNameFrom("case", "0"));
        	nav.suite.clickThisTestOnly("0");
        	String expectedName = "Ubuntu-14.04-UNKNOWN-chrome-42";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n",expectedName, actualName);
        	assertEquals(ErrorMsg.LegendListSize + "2 \n", expectedSize, actualSize);
        }
        
        /* ID:REP-A.02.14
	     * Edited: 2015-06-11
	     */
        @Test
        public void test_getErrorCase(){
        	nav.suite.clickOnBar("class", "0");
        	nav.suite.clickOnBar("method", "0");
        	nav.suite.clickOnBar("case", "0");
        	String stackTrace = nav.suite.getStackTrace();
        	int	colon = stackTrace.indexOf(":");
        	stackTrace = stackTrace.substring(0, colon);
        	String expected = "java.lang.AssertionError";
        	assertEquals(ErrorMsg.StackTraceIsDifferent + "1 \n", expected, stackTrace);
        }
        
        /* ID:REP-A.02.13
	     * Edited: 2015-06-11
	     */
        @Test
        public void test_ClickOnLastCase(){
        	nav.suite.clickOnBar("class", "0");
        	nav.suite.clickOnBar("method", "0");
        	nav.suite.clickOnBar("case", "15");
        	String stackTrace = nav.suite.getStackTrace();
        	String expected = "This test passed";
        	assertEquals(ErrorMsg.StackTraceIsDifferent + "1 \n", expected, stackTrace);
        }
        
        @Ignore
        /* ID:REP-A.02.07
	     * Edited: 2015-04-21
	     */
        @Test 
        public void test_CheckClass(){
        	nav.suite.checkBoxOn("class", "0");
        	nav.option.reloadGraph();
        	String expectedName = "Android";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
        	assertEquals(ErrorMsg.LegendListSize + "2 \n", expectedSize, actualSize);
        }
        
        @Ignore
        /* ID:REP-A.02.03
	     * Edited: 2015-04-21
	     */
        @Test 
        public void test_CheckMethod(){
        	nav.suite.clickOnBar("class", "0");
        	nav.suite.checkBoxOn("method", "0");
        	String beforeReload = nav.graph.getLegendListItem(0).getText();
        	int expectedSize = 1;
        	nav.option.reloadGraph();
        	String afterReload = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertNotEquals(ErrorMsg.LegendListTextIsSame + "1 \n",beforeReload, afterReload);
        	assertEquals(ErrorMsg.LegendListSize + "2 \n", expectedSize, actualSize);
        }
        
        /* ID:REP-A.02.10
	     * Edited: 2015-06-11
	     */
        @Test 
        public void test_ClickOnClassReload(){
        	nav.suite.clickOnBar("class", "0");
        	nav.option.reloadGraph();
        	String expectedName = "RandomClass0";
        	int expectedSize = 1;
        	String actualName = nav.graph.getLegendListItem(0).getText();
        	int actualSize = nav.graph.getLegendList().size();
        	assertEquals(ErrorMsg.LegendListTextIsDifferent + "1 \n", expectedName, actualName);
        	assertEquals(ErrorMsg.LegendListSize + "2 \n", expectedSize, actualSize);
        }
        
        /* ID:REP-A.02.11
	     * Edited: 2015-06-11
	     */
        @Test
        public void test_FilterCleanUp(){
        	nav.suite.filterOn("random");
        	nav.suite.clickOnBar("class", "0");
        	String expected = "";
        	String actual = nav.suite.getFilterFieldText();
        	assertEquals(ErrorMsg.FilterFieldTextIsDifferent + "1 \n", expected, actual);
        }
        
        /* ID:REP-A.02.12
	     * Edited: 2015-06-11
	     */
        @Test
        public void test_FilterOnChrome(){
        	nav.suite.clickOnBar("class", "0");
        	nav.suite.clickOnBar("method", "0");
        	nav.suite.filterOn("chrome");
        	int expected = 8;
        	int actual = nav.suite.getSizeOfCaseList();
        	nav.suite.waitForCaseListSize(expected);
        	assertEquals(ErrorMsg.CaseListSizeIsDifferent + "1 \n", expected, actual);
        }
        
        /* ID:REP-A.02.08
	     * Edited: 2015-06-11
	     */
	    @Test
	    public void test_ClickOnClassLink(){
	    	nav.suite.clickOnBar("class", "0");
	    	nav.suite.ClickOnSuiteLinkText();
	    	String actual = nav.graph.getUrl();
	    	assertTrue(ErrorMsg.PageRedirect + "1 \n", actual.endsWith("/#/reports/classes"));
	    }
	    
	    /* ID:REP-A.02.09
	     * Edited: 2015-06-11
	     */
	    @Test
	    public void test_clickOnMethodLink(){
	    	nav.suite.clickOnBar("class", "0");
	    	nav.suite.clickOnBar("method", "0");
	    	nav.suite.ClickOnSuiteLinkText();
	    	String actual = nav.graph.getUrl();
	    	assertTrue(ErrorMsg.PageRedirect + "1 \n", actual.endsWith("/#/reports/methods"));
	    }
	    
	    /* ID:REP-A.02.05
	     * Edited: 2015-06-11
	     */
	    @Test
	    public void test_getPassFailTextClass(){
	    	String actual = nav.suite.getPassFail("class", "0");
	    	String expected = "Skipped: 0 Failed: 28";
	    	assertEquals(ErrorMsg.ClassBarTextIsDifferent + "1 \n" + "Expected:" + expected + "\n" + "Actual:" + actual, expected, actual);
	    }
	    
	    /* ID:REP-A.02.06
	     * Edited: 2015-06-11
	     */
	    @Test
	    public void test_getPassFailTextMethod(){
	    	nav.suite.clickOnBar("class", "0");
	    	String actual = nav.suite.getPassFail("method", "0");
	    	String expected = "Skipped: 0 Failed: 12";
	    	assertEquals(ErrorMsg.MethodBarTextIsDifferent + "1 \n" + "Expected:" + expected + "\n" + "Actual:" + actual, expected, actual);
	    }

	    
	    @Ignore
	    @Test
	    public void test_BreakOnBrowserDispTime(){
	    	nav.option.changeDisplayType("Run Time");
	    	nav.option.changeBreakPoint("Browser");
	    	nav.option.reloadGraph();
	    }

}
