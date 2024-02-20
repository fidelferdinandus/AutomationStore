package org.AutomationStore;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Set;

import org.AutomationStore.TestUtils.AndroidBaseTest;
import org.AutomationStore.utils.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class browserTest extends AndroidBaseTest{

@Test
	public void testBrowser () throws InterruptedException
	{

	
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click(); 
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)", "");
		
		
		String text = driver.findElement(By.cssSelector("a[href='/angularAppdemo/products/3']")).getText();
		AssertJUnit.assertEquals(text, "Devops");
	
		Thread.sleep(6000);
	
	
//		driver.get("http://google.com");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("Airpods Pro 2");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		Thread.sleep(5000);		

	}
	
	
	
}
