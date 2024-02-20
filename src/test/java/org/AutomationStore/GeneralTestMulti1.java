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
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.AutomationStore.TestUtils.AndroidBaseTest;
import org.AutomationStore.pageObjects.android.FormPage;
import org.AutomationStore.pageObjects.android.ShoppingConfirmPage;
import org.AutomationStore.pageObjects.android.ShoppingPage;

public class GeneralTestMulti1 extends AndroidBaseTest{
	

@Test
	public void testBeliHalfEuy () throws InterruptedException
	{
								/* Fill Form Section */
		
		FormPage formPage = new FormPage(driver);
		formPage.chooseCountry("Argentina");
		formPage.fillName("Mustofa");
		formPage.chooseGender("Female");
		formPage.clickButtonNext();
		String error = driver.findElement(By.xpath("//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals(error, "Please enter your name");
	}
	
}
