package se.redmind.rmtest.report.expectedconditions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class UrlChanged implements ExpectedCondition<Boolean>{

	String currentUrl;
	
	public UrlChanged(String currentUrl) {
		this.currentUrl  = currentUrl; 
		System.out.println(currentUrl);
	}
	
	@Override
	public Boolean apply(WebDriver driver) {
		System.out.println(driver.getCurrentUrl());
		if (this.currentUrl.equals(driver.getCurrentUrl())) {
			return false;
		} else{
			return true;
		}
	}

}
