package org.AutomationStore.pageObjects.android;

import java.time.Duration;
import java.util.List;

import org.AutomationStore.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class ShoppingConfirmPage extends AndroidActions{

	AndroidDriver driver;
	
	public ShoppingConfirmPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> priceBorongan;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalPrice;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement closePopup;
	
	@FindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement buttonProceed;
	
	public double totalPriceDisplay()
	{
		String totalPrices = totalPrice.getText();
		double priceDisplay = stringToDouble(totalPrices);
		System.out.println("Harga Display" + priceDisplay);
		return priceDisplay;
	}
	
	public double totalMultiplePriceEachProduct()
	{
		double harga = 0;
		int banyakProduct = priceBorongan.size();
		for(int i = 0; i< banyakProduct; i++)
		{
			double prices = stringToDouble(priceBorongan.get(i).getText());
			harga = harga + prices;
		}
		System.out.println("Harga Tiap Product" + harga);
		return harga;
	}

	public void checkBox()
	{
		checkBox.click();
	}
	
	
	public void openAndCloseTerms() throws InterruptedException
	{
		WebElement longPress = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPress(longPress);
		Thread.sleep(3000);
		closePopup.click();
	}
	
	public void proceedShoppingCart()
	{
		buttonProceed.click();
	}

}

