package test.java;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.BeforeClass;

import se.redmind.rmtest.selenium.example.GoogleExample;
import se.redmind.rmtest.selenium.grid.DriverProvider;




@RunWith(Suite.class)
@Suite.SuiteClasses( {GoogleExample.class})
public class GoogleTests {
    @BeforeClass
    public static void beforeAllTests(){
        
    }

    
    @AfterClass
    public static void afterAllTests(){
        DriverProvider.stopDrivers();
    }
}
