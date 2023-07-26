package com.wfs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	AndroidDriver driver;
	WebDriverWait wait;

	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
	private WebElement homePageHeading;

	@AndroidFindBy(accessibility = "Username input field")
	private WebElement usernameField;

	@AndroidFindBy(accessibility = "Password input field")
	private WebElement passwordField;

	@AndroidFindBy(accessibility = "Login button")
	private WebElement loginButton;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"bob@example.com-autofill\"]/android.widget.TextView")
	private WebElement loginDetailslink;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView")
	private WebElement invalidLoginErrorMeassge;

	public String getHomePageHeading() {

		return homePageHeading.getAttribute("text");
	}
	
	private void setUsername(String username) {
		usernameField.sendKeys(username);
	}
	
	private void setPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		loginButton.click();

	}

	public void EnterLoginDetailsWithLink() {
		loginDetailslink.click();
		loginButton.click();

	}

	public String getInvalidLoginErrorMeassge() {
		return invalidLoginErrorMeassge.getAttribute("text");
	}

}
