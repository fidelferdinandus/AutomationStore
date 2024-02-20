package org.AutomationStore;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.io.IOException;
import java.util.HashMap;
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

public class GeneralTestSingle extends AndroidBaseTest{
	
	ExtentReports extent;
	
	
	@BeforeMethod
	public void preSetup()
	{
		//adb shell dumpsys window | find "mCurrentFocus" -> Windows
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
		driver.startActivity(activity);
		}

	
	@Test(dataProvider="getData")
	public void testBeli (HashMap<String, String> input) throws InterruptedException
	{
								/* Fill Form Section */
	ExtentTest test = extent.createTest("Initial Demo");
	FormPage formPage = new FormPage(driver);
	formPage.chooseCountry(input.get("country"));
	formPage.fillName(input.get("name"));
	formPage.chooseGender(input.get("gender"));
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
//	shoppingConfirm.checkBox();
	shoppingConfirm.openAndCloseTerms();
	shoppingConfirm.proceedShoppingCart();
	extent.flush();

}
	@DataProvider
	public Object[][] getData() throws IOException 
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\org\\AutomationStore\\testData\\storedata.json");
		return new Object[][] {{data.get(0)}, {data.get(1)} };
		
	}
//	public Object[][] getData() 
//	{
//		return new Object[][] {{"Bambang Huehe","male","Argentina"}, {"Lucinta Luna","male","Argentina"} };
//		
//	}

}
