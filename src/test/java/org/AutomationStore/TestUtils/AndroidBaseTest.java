package org.AutomationStore.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.AutomationStore.utils.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest extends AppiumUtils{
	
	public AndroidDriver driver;
	
//	public AppiumDriverLocalService service;


	
	@BeforeClass
	public void ConfigureAppium() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\AutomationStore\\resources\\data.properties");
		
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");


		service = startAppiumServer(ipAddress, Integer.parseInt(port));
		
					/*Appium Server Autiomation dipindah ke AppiumUtils*/
//		Start Appium Server Automatically
//		service = new AppiumServiceBuilder()
//		.withAppiumJS(new File("C:\\Users\\GPAY-User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//		.withIPAddress("127.0.0.1").usingPort(4723).build();
//		
//		service.start();
		
		//Define Phone and Apps
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("androidDeviceName"));
//		options.setApp("C:\\Users\\GPAY-User\\eclipse-workspace\\Automation\\AplikasiYangDitest\\ApiDemos-debug.apk");
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\org\\AutomationStore\\resources\\General-Store.apk");
		
			/* Kalo jalanin Hybrid (webview), tapi error karena gak ada chromedriver, tulis code kek dibawah*/
//		options.setChromedriverExecutable("C:\\Users\\GPAY-User\\Documents\\chromedriver91.exe");
//		options.setCapability("browserName",prop.getProperty("browser"));
		
		//Define Driver Android and URL
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	//Close Apps
	public void Close()
	{	
		driver.quit();
//		service.stop();
	}
	
	
}

