package com.wfs.base;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AppiumDriverLocalService service;
	public UiAutomator2Options options;
	public AndroidDriver driver;
	public DriverManager manager;

	public static Properties properties = new Properties();

	public void setUp() {
		loadproperties();
		service = new AppiumServiceBuilder().withAppiumJS(new File(properties.getProperty("mainjsFilePath")))
				.withIPAddress(properties.getProperty("IPAddress"))
				.usingPort(Integer.parseInt(properties.getProperty("port"))).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		options.setDeviceName(properties.getProperty("deviceName"));
		options.setPlatformName(properties.getProperty("platformName"));
		options.setPlatformVersion(properties.getProperty("platformVersion"));
		options.setAppPackage(properties.getProperty("appPackage"));
		options.setAppActivity(properties.getProperty("appActivity"));
		try {
			driver = new AndroidDriver(new URL(properties.getProperty("url")), options);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		initialize();

	}

	public void loadproperties() {
		try {
			FileInputStream file = new FileInputStream("src/test/resources/utils/MyDemoApp.properties");

			properties.load(file);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void initialize() {
		manager = new DriverManager(driver);

	}

	public void tearDown() {
		driver.quit();
		service.stop();

	}

}
