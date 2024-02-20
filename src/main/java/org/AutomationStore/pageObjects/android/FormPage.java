package org.AutomationStore.pageObjects.android;

import org.AutomationStore.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class FormPage extends AndroidActions{

	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement clickCountryOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement fillName;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement chooseRadioFemale;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement chooseRadioMale;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement buttonNext;
	
	public void fillName(String name)
	{
		fillName.sendKeys(name);
	}
	
	public void chooseCountry(String country)
	{
		clickCountryOption.click();
		scrollUntil(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
	}
	
	public void chooseGender(String gender)
	{
		if (gender == "male")
		{
			chooseRadioMale.click();
		}
		else 
		{
			chooseRadioFemale.click();
		}
	}
	
	public void clickButtonNext() {
		buttonNext.click();
	}
	
}

