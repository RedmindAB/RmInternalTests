package se.redmind.rmtest.report.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

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
	    
	    @Test
	    public void nrSuiteRunsPresent(){
	    	boolean displayed = nav.getNumberOfSuiteRunsButton().isDisplayed();
	    	assertTrue(displayed);
	    }
	    
	    @Test
	    public void nrAddGraphLinePresent(){
	    	boolean displayed = nav.getAddGraphLine().isDisplayed();
	    	assertTrue(displayed);
	    }
	    
	    @Test
	    public void reloadButtonPresent(){
	    	boolean displayed = nav.getReload().isDisplayed();
	    	assertTrue(displayed);
	    }

	    @Test
	    public void chooseGraphViewPresent(){
	    	boolean displayed = nav.getChooseGraphView().isDisplayed();
	    	assertTrue(displayed);
	    }
	    
	    @Test
	    public void chooseBreakPointPresent(){
	    	boolean displayed = nav.getChooseBreakPoint().isDisplayed();
	    	assertTrue(displayed);
	    }
	    
	    @Test
	    public void assertChartSizeTo50(){
	    	Chart chart = nav.getChart();
	    	assertEquals(50, chart.getGraphResultSize());
	    }
	    
	    @Test
	    public void assertChartSizeTo100(){
	    	nav.changeChartSuiteRunLimit(100);
	    	nav.reloadGraph();
	    	Chart chart = nav.getChart();
	    	chart.getGraphResultSize();
	    	assertEquals(100, chart.getGraphResultSize());
	    }
	    
	    @Test
	    public void assertChartSizeTo10(){
	    	nav.changeChartSuiteRunLimit(10);
	    	nav.reloadGraph();
	    	Chart chart = nav.getChart();
	    	chart.getGraphResultSize();
	    	assertEquals(10, chart.getGraphResultSize());
	    }
	    
	    @Test
	    public void assertChartSizeTo20(){
	    	nav.changeChartSuiteRunLimit(20);
	    	nav.reloadGraph();
	    	Chart chart = nav.getChart();
	    	chart.getGraphResultSize();
	    	assertEquals(20, chart.getGraphResultSize());
	    }
	    
	    @Test
	    public void assertChartSizeTo200(){
	    	nav.changeChartSuiteRunLimit(500);
	    	nav.reloadGraph();
	    	Chart chart = nav.getChart();
	    	chart.getGraphResultSize();
	    	//There are only 200 results in this suite, so the result should be 200
	    	assertEquals(200, chart.getGraphResultSize());
	    }
}