package se.redmind.rmtest.report.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import se.redmind.rmtest.report.nav.StartNav;
import se.redmind.rmtest.selenium.framework.RMReportScreenshot;
import se.redmind.rmtest.selenium.grid.DriverNamingWrapper;
import se.redmind.rmtest.selenium.grid.DriverProvider;
import se.redmind.rmtest.selenium.grid.Parallelized;



@RunWith(Parallelized.class)
public class StartPage {


	   private WebDriver tDriver;
	    private final DriverNamingWrapper urlContainer;
	    private final String driverDescription;
	    private final RMReportScreenshot rmrScreenshot;
	    private StartNav nav;

	    public StartPage(final DriverNamingWrapper driverWrapper, final String driverDescription) {
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
	    	this.nav = new StartNav(this.tDriver);
	    }
	    
	    @Test
	    public void isRedmindLogoPresent(){
	    	WebElement redmindlogo = this.nav.getRedmindLogo();
	    	new RMReportScreenshot(urlContainer).takeScreenshot("logo");
	    	assertTrue(redmindlogo.isDisplayed());
	    }
	    
	    @Test
	    public void isScreenshotPresent(){
	    	WebElement screenshot = this.nav.getScreenshot();
	    	new RMReportScreenshot(urlContainer).takeScreenshot("logo");
	    	assertTrue(screenshot.isDisplayed());
	    }
	    
	    @Test
	    public void isGraphViewPresent(){
	    	WebElement graphView = this.nav.getGraphView();
	    	new RMReportScreenshot(urlContainer).takeScreenshot("logo");
	    	assertTrue(graphView.isDisplayed());
	    }
	    

}