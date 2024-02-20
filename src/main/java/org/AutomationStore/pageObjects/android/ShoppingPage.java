package org.AutomationStore.pageObjects.android;

import org.AutomationStore.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class ShoppingPage extends AndroidActions{

	AndroidDriver driver;
	
	public ShoppingPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void chooseProduct(String product)
	{
		scrollUntil(product);
		int products = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for (int i = 0; i < products; i++)
		{
			String namaProduct = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			System.out.println(namaProduct);
			if (namaProduct.equalsIgnoreCase(product))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			
			}
			else
			{
				System.out.println("Productnya " +namaProduct+ " gak match sama yang dicari (" +product+ ")");
			}
			
		}
	}
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement buttonCart;	
	
	public void clickButtonCart()
	{
		buttonCart.click();
	}
}

