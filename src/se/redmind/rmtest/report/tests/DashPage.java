package se.redmind.rmtest.report.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import se.redmind.rmtest.report.nav.DashNav;
import se.redmind.rmtest.report.utils.ErrorMsg;
import se.redmind.rmtest.selenium.framework.RMReportScreenshot;
import se.redmind.rmtest.selenium.grid.DriverNamingWrapper;
import se.redmind.rmtest.selenium.grid.DriverProvider;
import se.redmind.rmtest.selenium.grid.Parallelized;



@RunWith(Parallelized.class)
public class DashPage {


	   private WebDriver tDriver;
	    private final DriverNamingWrapper urlContainer;
	    private final String driverDescription;
	    private final RMReportScreenshot rmrScreenshot;
	    private DashNav nav;

	    public DashPage(final DriverNamingWrapper driverWrapper, final String driverDescription) {
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
	    	this.nav = new DashNav(tDriver);
	    }
	    
	    /* ID: DASH-A.01.01
         * Edited: 2015-06-11
         */
	    @Test
	    public void test_filterOnGraph(){
	    	
	    	assertTrue(ErrorMsg.ShouldBeEnabled + "1 \n", nav.dash.isEnabled("passed"));
	    	nav.dash.clickLegend("passed");
	    	assertTrue(ErrorMsg.ShouldNotBeEnabled + "w \n", !nav.dash.isEnabled("passed"));
	    	
	    	assertTrue(ErrorMsg.ShouldBeEnabled + "3 \n", nav.dash.isEnabled("skipped"));
	    	nav.dash.clickLegend("skipped");
	    	assertTrue(ErrorMsg.ShouldNotBeEnabled + "4 \n", !nav.dash.isEnabled("skipped"));
	    	
	    	assertTrue(ErrorMsg.ShouldBeEnabled + "5 \n", nav.dash.isEnabled("failed"));
	    	nav.dash.clickLegend("failed");
	    	assertTrue(ErrorMsg.ShouldNotBeEnabled + "6 \n", !nav.dash.isEnabled("failed"));
	    }
	    
}