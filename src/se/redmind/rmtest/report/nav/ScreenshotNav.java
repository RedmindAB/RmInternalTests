package se.redmind.rmtest.report.nav;

import org.openqa.selenium.WebDriver;

public class ScreenshotNav extends BaseNav{

	public ScreenshotNav(WebDriver pDriver) {
		super(pDriver);
	}

	@Override
	void navigate() {
		getFirstSuiteSection().click();;
		getScreenshot().click();
	}
}
