package org.AutomationStore;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.AutomationStore.TestUtils.AndroidBaseTest;
import org.AutomationStore.pageObjects.android.FormPage;
import org.AutomationStore.pageObjects.android.ShoppingConfirmPage;
import org.AutomationStore.pageObjects.android.ShoppingPage;

public class GeneralTest extends AndroidBaseTest{
	
	@BeforeMethod
	public void preSetup()
	{
		//adb shell dumpsys window | find "mCurrentFocus" -> Windows
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
		driver.startActivity(activity);
	}

//	@Test(dataProvider="getData")	
//	public void testBeliHalfEuy (String name, String gender, String country) throws InterruptedException
//	{
//								/* Fill Form Section */
//		
//		FormPage formPage = new FormPage(driver);
//		formPage.chooseCountry(country);
//		formPage.fillName(name);
//		formPage.chooseGender(gender);
//		formPage.clickButtonNext();
////		String error = driver.findElement(By.xpath("//android.widget.Toast)[1]")).getAttribute("name");
////		Assert.assertEquals(error, "Please enter your name");
//
//	}
	
	@Test(dataProvider="getData")
	public void testBeli (String name, String gender, String country) throws InterruptedException
	{
								/* Fill Form Section */
	
	FormPage formPage = new FormPage(driver);
	formPage.chooseCountry(country);
	formPage.fillName(name);
	formPage.chooseGender(gender);
	formPage.clickButtonNext();
	
	Thread.sleep(3000);
	
								/* Choosing Product */
	
	ShoppingPage shoppingPage = new ShoppingPage(driver);
	shoppingPage.chooseProduct("Converse All Star");
	shoppingPage.clickButtonCart();
	
	Thread.sleep(3000);
	
							/* Farebreakdown Section */
	ShoppingConfirmPage shoppingConfirm = new ShoppingConfirmPage(driver);
	double hargaProduct = shoppingConfirm.totalMultiplePriceEachProduct();
	double hargaDisplay = shoppingConfirm.totalPriceDisplay();
	AssertJUnit.assertEquals(hargaProduct, hargaDisplay);
	shoppingConfirm.checkBox();
	shoppingConfirm.openAndCloseTerms();
	shoppingConfirm.proceedShoppingCart();
	
	Thread.sleep(6000);
	
							/*Hybrid Handling (Native - WebView) */
	Set <String> contexts = driver.getContextHandles();
	for(String contextName : contexts)
	{
		System.out.println(contextName);
	}
	driver.context("WEBVIEW_com.androidsample.generalstore");
	driver.findElement(By.name("q")).sendKeys("Airpods Pro 2");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	Thread.sleep(5000);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.context("NATIVE_APP");
	Thread.sleep(5000);

}
	@DataProvider
	public Object[][] getData() 
	{
		return new Object[][] {{"Bambang Huehe","male","Argentina"}};
		
	}

}
