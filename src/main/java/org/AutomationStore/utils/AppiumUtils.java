package org.AutomationStore.utils;

import java.nio.charset.StandardCharsets;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.AppiumDriver;

public abstract class AppiumUtils {
	
	public AppiumDriverLocalService service;

	/*Supaya gak bentrok sama Driver yang ada di BaseTest, jadi driver di class ini diapus, atau solusinya bisa dimasukin ke parameter method yang membutuhkan, tinggal masukin "AndroidDriver driver" atau "AppiumDriver driver" serah deh pokoknya */
	
//	public AndroidDriver driver;
//
//	public AppiumUtils(AndroidDriver driver)
//	{
//		this.driver = driver;
//	}
	
	public static List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException{

		String jsonContent=FileUtils.readFileToString(new File(jsonFilePath),"UTF-8");

		ObjectMapper mapper=new ObjectMapper();

		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){

		});

		return data;

		}
	
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress,int port)
	{
//		Start Appium Server Automatically
		service = new AppiumServiceBuilder()
		.withAppiumJS(new File("C:\\Users\\GPAY-User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		.withIPAddress(ipAddress).usingPort(port).build();
		
		service.start();
		return service;
	}

	
	public double stringToDouble(String price)
	{
		double variables = Double.parseDouble(price.substring(1));
		return variables;
	}
}
	
