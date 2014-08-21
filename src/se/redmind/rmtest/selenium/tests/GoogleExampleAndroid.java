package se.redmind.rmtest.selenium.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import se.redmind.rmtest.selenium.grid.DriverNamingWrapper;
import se.redmind.rmtest.selenium.grid.DriverProvider;
import se.redmind.rmtest.selenium.grid.Parallelized;

@RunWith(Parallelized.class)
public class GoogleExampleAndroid{


	   private WebDriver tDriver;
	    private final DriverNamingWrapper driverWrapper;
	    private final String driverDescription;

	    public GoogleExampleAndroid(final DriverNamingWrapper driverWrapper, final String driverDescription) {
	        this.driverWrapper = driverWrapper;
	        this.driverDescription = driverDescription;
	    }
	    
	    private static Object[] getDrivers() {
	        return DriverProvider.getDrivers(Platform.ANDROID);

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
    
    @Test
    @Ignore
    public void testGoogle() throws Exception {
        tDriver = driverWrapper.getDriver();
        tDriver.get("http://stage.play.aftonbladet.se:8080");
       
        Cookie mobilCookie = new Cookie.Builder("ABTV-DIRECTSTREAM", "ABTV-DIRECTSTREAM").domain(".aftonbladet.se").build();
        
        tDriver.manage().addCookie(mobilCookie);
        mobilCookie = new Cookie.Builder("X-AB-Device-Type", "mobile").domain(".aftonbladet.se").build();
        tDriver.manage().addCookie(mobilCookie);
        // And now use this to visit Google
        tDriver.get("http://stage.play.aftonbladet.se:8080/webbtv/nyheter/samhalle-och-politik/oj-vilken-vecka/article716.ab?service=embedded&autoplay=false");
        System.out.println(tDriver.manage().getCookieNamed("ABTV-DIRECTSTREAM").getDomain());
        System.out.println(tDriver.manage().getCookieNamed("X-AB-Device-Type").getValue());
        // Find the text input element by its name
//        WebElement element = driver.findElement(By.name("q"));
        System.out.println("Page title is: " + tDriver.getTitle());
        
//        assertTrue(tDriver.getTitle().startsWith("Goo"));
//        assertFalse(driver.getTitle().startsWith("Goo"));
        
        
    }


    @Test 
    public void testAOS() throws Exception {
        tDriver = driverWrapper.getDriver();
        // And now use this to visit Google
        tDriver.get("http://www.aos.se");

        // Find the text input element by its name
//        WebElement element = driver.findElement(By.name("q"));
        System.out.println("Page title is: " + tDriver.getTitle());
        assertTrue(tDriver.getTitle().startsWith("Allt om Stockholm"));
    }


}