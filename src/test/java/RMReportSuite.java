package test.java;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.BeforeClass;

import se.redmind.rmtest.report.tests.GraphPage;
import se.redmind.rmtest.report.tests.GridPage;
import se.redmind.rmtest.report.tests.NavbarPage;
import se.redmind.rmtest.report.tests.StartPage;
import se.redmind.rmtest.report.tests.SuitePage;
import se.redmind.rmtest.report.tests.VisualPage;
import se.redmind.rmtest.selenium.example.GoogleExample;
import se.redmind.rmtest.selenium.grid.DriverProvider;




@RunWith(Suite.class)
@Suite.SuiteClasses( {GraphPage.class, SuitePage.class, VisualPage.class, NavbarPage.class, StartPage.class, GridPage.class})
public class RMReportSuite {
    @BeforeClass
    public static void beforeAllTests(){
        
    }

    
    @AfterClass
    public static void afterAllTests(){
        DriverProvider.stopDrivers();
    }
    
}
