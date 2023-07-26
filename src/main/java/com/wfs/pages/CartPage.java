package com.wfs.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {
	AndroidDriver driver;
	WebDriverWait wait;

	public CartPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Cart']")
	private WebElement cartPageHeading;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='product label'])[1]")
	private WebElement productBackpack;

	@AndroidFindBy(xpath = "/(//android.widget.TextView[@content-desc='product label'])[2]")
	private WebElement productOnesies;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.TextView")
	private WebElement cartCount;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='remove item'])[2]/android.widget.TextView")
	private WebElement removeProdctOnesies;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='total price']")
	private WebElement totalPrice;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Proceed To Checkout button']/android.widget.TextView")
	private WebElement proceedToCheckoutButton;

	public String getCartPageHeading() {
		return cartPageHeading.getAttribute("text");
	}

	public Boolean checkProductBackpackIsDisplayed() {
		return productBackpack.isDisplayed();
	}

	public String gerProductBackpackText() {
		return productBackpack.getAttribute("text");
	}

	public String gerProductOnesiesText() {
		return productOnesies.getAttribute("text");
	}

	public Boolean checkProductOnesiesIsDisplayed() {
		return productOnesies.isDisplayed();
	}

	public String getCartCount() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.TextView")));
		return cartCount.getAttribute("text");
	}

	public String getTotalPrice() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc='total price']")));
		return totalPrice.getAttribute("text");

	}

	public void scrollUp() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
				+ ".scrollIntoView(new UiSelector().textMatches(\"" + "Sauce Labs Onesie" + "\").instance(0))"));

	}

	public void removeProductFromCart() {
		removeProdctOnesies.click();
	}

	public void clickOnProceedToCheckoutButton() {
		proceedToCheckoutButton.click();
	}

}
