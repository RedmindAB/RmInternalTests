package se.redmind.rmtest.selenium.navigation;

import com.google.common.base.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import se.redmind.rmtest.selenium.framework.HTMLPage;

public class RMNav extends HTMLPage {
	private Actions builder;

	/**
	 * @param pDriver
	 */
	public RMNav(WebDriver pDriver, String serverUrl) throws Exception {
		super(pDriver);
		driver = pDriver;
		
		int i = 0;
		while (i < 10) {
			try {
				driver.get(Objects.firstNonNull(serverUrl, "http://www.redmind.se"));
				//driverFluentWait(6).until(ExpectedConditions.presenceOfElementLocated(By.id("abMeasure")));
				break;
			}
			catch (Exception e) {
				System.out.println(i + " AbMobileNav: " + e);
				i = i + 1;
				Thread.sleep(500);
			}
		}
	}
	
	
	public void clickOnMenu(String pMenuText) throws Exception {
		System.out.println("Clicking: " + pMenuText);
		driver.findElement(By.cssSelector(pMenuText)).click();
		
	}	
	
	
	public void openTpi(String Menu, String SubMenu) throws Exception {
		builder = new Actions(driver);

		builder.moveToElement(driver.findElement(By.id(Menu))).perform();

		// System.out.println("Hovering over " + Menu);
		Thread.sleep(2000L);
		// System.out.println("Pressing " + SubMenu);
		driver.findElement(By.id(SubMenu)).click();
	}

	public void openManag(String pMenu, String pSubMenu) throws Exception {
		builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.linkText(pMenu))).perform();

		// System.out.println("Hovering over " + pMenu);
		Thread.sleep(500L);
		System.out.println("Pressing " + pSubMenu);
		driver.findElement(By.linkText(pSubMenu)).click();
	}

	public void openRyk(String pText, String pSubText) throws Exception {
		builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.linkText(pText))).perform();

		// System.out.println("Hovering over " + pMenu);
		Thread.sleep(500L);
		System.out.println("Pressing " + pSubText);
		driver.findElement(By.linkText(pSubText)).click();
	}
	
	public void openClAc(String Text, String SubText) throws Exception {
		builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.linkText(Text))).perform();

		// System.out.println("Hovering over " + pMenu);
		Thread.sleep(500L);
		System.out.println("Pressing " + SubText);
		driver.findElement(By.linkText(SubText)).click();
	}
	
	public void openKTj(String menu, String subMenu1, String subMenu2) throws Exception {
		builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.linkText(menu))).perform();
		Thread.sleep(500L);
		builder.moveToElement(driver.findElement(By.linkText(subMenu1))).perform();
		Thread.sleep(500L);;
		driver.findElement(By.linkText(subMenu2)).click();
		
	}
}
