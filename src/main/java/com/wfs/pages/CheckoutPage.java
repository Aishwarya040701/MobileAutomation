package com.wfs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.wfs.base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage extends BaseTest {
	AndroidDriver driver;

	public CheckoutPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='checkout payment screen']/android.view.ViewGroup/android.widget.TextView[1]")
	private WebElement ckeckoutPageHeading;

	@AndroidFindBy(accessibility = "Full Name* input field")
	private WebElement fullNameField;

	@AndroidFindBy(accessibility = "Address Line 1* input field")
	private WebElement addressLine1Field;

	@AndroidFindBy(accessibility = "Address Line 2 input field")
	private WebElement addressLine2Field;

	@AndroidFindBy(accessibility = "City* input field")
	private WebElement cityField;

	@AndroidFindBy(accessibility = "State/Region input field")
	private WebElement stateField;

	@AndroidFindBy(accessibility = "Zip Code* input field")
	private WebElement zipCodeField;;

	@AndroidFindBy(accessibility = "Country* input field")
	private WebElement countryField;

	@AndroidFindBy(accessibility = "To Payment button")
	private WebElement toPaymentButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Full Name* input field']")
	private WebElement fullName;

	@AndroidFindBy(accessibility = "Card Number* input field")
	private WebElement cardNumberField;

	@AndroidFindBy(accessibility = "Expiration Date* input field")
	private WebElement expirationDateField;

	@AndroidFindBy(accessibility = "Security Code* input field")
	private WebElement securityCodeField;

	@AndroidFindBy(accessibility = "Review Order button")
	private WebElement reviewOrderButton;

	@AndroidFindBy(accessibility = "Place Order button")
	private WebElement placeOrderButton;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='checkout complete screen']/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")
	private WebElement checkoutCompleteMessage;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")
	private WebElement menuButton;

	@AndroidFindBy(accessibility = "menu item about")
	private WebElement aboutLink;

	@AndroidFindBy(accessibility = "menu item log out")
	private WebElement logoutLink;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement logoutOption;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Go to the Sauce Labs website.']")
	WebElement websiteLink;

	public String getCkeckoutPageHeading() {
		return ckeckoutPageHeading.getAttribute("text");
	}

	public void registration() {
		loadproperties();
		fullNameField.sendKeys(BaseTest.properties.getProperty("fullname"));
		addressLine1Field.sendKeys(BaseTest.properties.getProperty("addressLine1"));
		addressLine2Field.sendKeys(BaseTest.properties.getProperty("addressLine2"));
		cityField.sendKeys(BaseTest.properties.getProperty("city"));
		stateField.sendKeys(BaseTest.properties.getProperty("state"));
		zipCodeField.sendKeys(BaseTest.properties.getProperty("zipcode"));
		countryField.sendKeys(BaseTest.properties.getProperty("country"));

	}

	public void enterPaymentDetails() {
		loadproperties();
		fullName.sendKeys(BaseTest.properties.getProperty("name"));
		cardNumberField.sendKeys(BaseTest.properties.getProperty("cardNumber"));
		expirationDateField.sendKeys(BaseTest.properties.getProperty("expirationDate"));
		securityCodeField.sendKeys(BaseTest.properties.getProperty("securityCode"));

	}

	public void clickOnToPaymentButton() {
		toPaymentButton.click();

	}

	public void clickOnReviewOrderButton() {
		reviewOrderButton.click();

	}

	public void clickOnPlaceOrderButton() {
		placeOrderButton.click();

	}

	public String getCheckoutCompleteMessage() {
		return checkoutCompleteMessage.getAttribute("text");
	}

	public void aboutlink() {
		menuButton.click();
		aboutLink.click();
		websiteLink.click();
	}

	public void Logoutlink() {
		menuButton.click();
		logoutLink.click();
		logoutOption.click();

	}

}
