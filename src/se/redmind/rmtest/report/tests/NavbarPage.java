package se.redmind.rmtest.report.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

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

import se.redmind.rmtest.report.nav.NavbarNav;
import se.redmind.rmtest.report.nav.StartNav;
import se.redmind.rmtest.report.nav.VisualNav;
import se.redmind.rmtest.selenium.framework.RMReportScreenshot;
import se.redmind.rmtest.selenium.grid.DriverNamingWrapper;
import se.redmind.rmtest.selenium.grid.DriverProvider;
import se.redmind.rmtest.selenium.grid.Parallelized;

@RunWith(Parallelized.class)
public class NavbarPage {

	   private WebDriver tDriver;
	    private final DriverNamingWrapper urlContainer;
	    private final String driverDescription;
	    private final RMReportScreenshot rmrScreenshot;
	    private NavbarNav nav;
	    

	    public NavbarPage(final DriverNamingWrapper driverWrapper, final String driverDescription) {
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
	    	this.nav = new NavbarNav(this.tDriver);
	    }
	    
	    @Test
	    public void test_goToGrid(){
	    	nav.goToGrid();
	    	String expected = "#/grid";
	    	assertTrue(nav.getCurrentUrl().endsWith(expected));
	    }
	    
	    @Test
	    public void test_goToAdmin(){
	    	nav.goToAdmin();
	    	String expected = "#/admin";
	    	assertTrue(nav.getCurrentUrl().endsWith(expected));
	    }
	    
	    @Test
	    public void test_goToDashboard(){
	    	nav.goToAdmin();
	    	nav.goToDashboard();
	    	String expected = "#/home";
	    	assertTrue(nav.getCurrentUrl().endsWith(expected));
	    }
	    
	    @Test
	    public void test_changeProject(){
	    	nav.chooseProject(0);
	    	String expected = nav.getProjectNameFromList(0);
	    	String actual = nav.getCurrentProjectName();
	    	assertEquals(expected, actual);	    	
	    }
	    
	    @Test
	    public void test_clickLogo(){
	    	nav.goToAdmin();
	    	nav.clickLogo();
	    	String expected = "#/home";
	    	assertTrue(nav.getCurrentUrl().endsWith(expected));
	    }
	    
	    @Test
	    public void test_goToReports(){
	    	nav.chooseProject(0);
	    	nav.goToReports();
	    	String expected = "#/reports/classes";
	    	assertTrue(nav.getCurrentUrl().endsWith(expected));
	    }
	    
	    @Test
	    public void test_goToVisualizer(){
	    	nav.chooseProject(0);
	    	nav.goToVisualizer();
	    	String expected = "#/screenshots/classes";
	    	assertTrue(nav.getCurrentUrl().endsWith(expected));
	    }
	    
	    @Test
	    public void test_changeTimestamp(){
	    	nav.chooseProject(0);
	    	System.out.println();
	    	String expected = "20150219080049";
	    	String actual = nav.getCurrentTimestamp();
	    	nav.chooseTimeStamp(expected);
	    	assertEquals(expected, actual);
	    }
	    
	    
	    	
	    	
	    

}

	    
	    
	    

