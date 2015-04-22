package se.redmind.rmtest.report.nav;

import org.openqa.selenium.WebDriver;

public class GraphNav extends BaseNav {

	public GraphController graph;
	public SuiteController suite;
	
	public GraphNav(WebDriver pDriver) {
		super(pDriver);
		graph = new GraphController(pDriver);
		suite = new SuiteController(pDriver);
	}

	@Override
	void navigate() {
		getFirstSuiteSection().click();
	}
	
	
}
