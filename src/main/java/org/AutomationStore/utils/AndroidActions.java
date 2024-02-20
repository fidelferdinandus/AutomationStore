package org.AutomationStore.utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class AndroidActions extends AppiumUtils{

	public AndroidDriver driver;

	public AndroidActions(AndroidDriver driver)
	{
//		super(driver);
		this.driver = driver;
	}
	
	public void scrollUntil(String menu)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+menu+"\"))"));
	}
	
	public void scrollSpesific()
	{
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0));
	}
	
	public void longPress(WebElement longPress)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture"
				, ImmutableMap.of("elementId",((RemoteWebElement)longPress).getId(),
				"duration",3000));
	}
	
	public void swipe(WebElement swipe)
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)swipe).getId(),
				"direction", "left",
			    "percent", 0.75));
	}
	
	public void drag(WebElement drag)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId", ((RemoteWebElement) drag).getId(),
			    "endX", 815,
			    "endY", 781
			));
	}
	
}
	
