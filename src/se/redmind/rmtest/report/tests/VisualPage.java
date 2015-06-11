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
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import se.redmind.rmtest.report.nav.StartNav;
import se.redmind.rmtest.report.nav.VisualNav;
import se.redmind.rmtest.selenium.framework.RMReportScreenshot;
import se.redmind.rmtest.selenium.grid.DriverNamingWrapper;
import se.redmind.rmtest.selenium.grid.DriverProvider;
import se.redmind.rmtest.selenium.grid.Parallelized;

@RunWith(Parallelized.class)
public class VisualPage {

	   private WebDriver tDriver;
	    private final DriverNamingWrapper urlContainer;
	    private final String driverDescription;
	    private final RMReportScreenshot rmrScreenshot;
	    private VisualNav nav;

	    public VisualPage(final DriverNamingWrapper driverWrapper, final String driverDescription) {
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
	    	this.nav = new VisualNav(this.tDriver);
	    }
	    
	    /* ID: VIS-A.01.03
	     * Edited: 2015-06-09 */
	    @Test
	    public void openSysos(){
	    	nav.openSysos("class-0");
	    	assertTrue(nav.isSysosOpen());
	    }	    

	    /* ID: VIS-A.01.06
		 * Edited: 2015-06-09 */
		@Test
		public void openCloseSyso(){
			nav.openSysos("class-0");
			nav.closeSysos();
			assertTrue(nav.isSysosClosed());
		}
		
		/* ID: VIS-A.01.01
		 * Edited: 2015-06-09 */
		@Test
		public void chooseAnotherClass(){
			nav.chooseClass("class-0");
			String methods = nav.getTitle();
			nav.goToScopeByID("1");
			String classes = nav.getTitle();
			assertNotEquals(methods, classes);
		}
		
		/* ID: VIS-A.01.02
		 * Edited: 2015-06-09 */
		@Test
		public void chooseTimestamp(){
			nav.changeProject("MockedTestSuite");
			nav.changeTimestamp("20150101080000");
			assertTrue(nav.isTimestampSet("20150101080000"));	
		}
		
	    /* ID: VIS-A.01.05
		 * Edited: 2015-06-09 */
	    @Test
	    public void changeProject(){
			nav.changeProject("MockedTestSuite");
			assertTrue(nav.isProjectSet("MockedTestSuite"));	
	    }
		
	    /* ID: VIS-A.01.04
		 * Edited: 2015-06-09 */
		@Test
		public void isThumbnailPresent(){
			nav.changeProject("MockedTestSuite");
			nav.changeTimestamp("2015-01-01 08:00");
			nav.chooseClass("class-0");
			nav.openMethod("0");
			assertTrue(nav.isThumbnailPresent("0"));
		}
		/*
		@Test
		public void isScreenShotPresent(){
			nav.changeProject("LongerTestSuite");
			nav.changeTimestamp("20150101080000");
			nav.chooseClass("class-0");
			nav.openMethod("0");
			nav.openScreenshot("0");
			nav.waitForSlideAnimation();
			assertTrue(nav.isScreenshotPresent());
		} 
		*/
		/*
		@Test
		public void isScreenShotSwitched(){
			nav.changeProject("LongerTestSuite");
			nav.changeTimestamp("20150101080000");
			nav.chooseClass("class-0");
			nav.openMethod("0");
			nav.openScreenshot("0");
			assertTrue(nav.isScreenShotSwitched());
		}
		*/
}


	    	
	    
	    

