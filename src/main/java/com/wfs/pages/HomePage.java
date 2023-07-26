package com.wfs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")
	private WebElement menuButton;

	@AndroidFindBy(accessibility = "menu item log in")
	private WebElement loginLink;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
	private WebElement homePageHeading;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sort button\"]")
	private WebElement filterLink;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='store item text']")
	private List<WebElement> listOfProduts;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Backpack']")
	private WebElement productBackpack;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='blue circle']")
	private WebElement productBackpackColor;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='counter plus button']/android.widget.ImageView")
	private WebElement plusIcon;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='counter amount']/android.widget.TextView")
	private WebElement productCount;

	@AndroidFindBy(accessibility = "Add To Cart button")
	private WebElement addTocartButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Onesie']")
	private WebElement productOnesies;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='black circle']")
	private WebElement productOnesiesColor;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView")
	private WebElement openCart;

	public String getHomePageHeading() {

		return homePageHeading.getAttribute("text");
	}

	public String selectProductBackpack() {

		productBackpack.click();
		productBackpackColor.click();
		plusIcon.click();
		return productCount.getAttribute("text");

	}

	public void goToLoginPage() {
		menuButton.click();
		loginLink.click();

	}

	public String gerProductBackpackText() {
		return productBackpack.getAttribute("text");
	}

	public String gerProductOnesiesText() {
		return productOnesies.getAttribute("text");
	}

	public void clickOnAddToCart() {
		addTocartButton.click();
	}

	public void scrollBy(String productName) {

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
				+ ".scrollIntoView(new UiSelector().textMatches(\"" + productName + "\").instance(0))"));
	}

	public String selectProductOnesies() {

		productOnesies.click();
		productOnesiesColor.click();
		return productCount.getAttribute("text");

	}

	public void selectProduct(String productName) {

		//driver.findElement(By.xpath("//android.widget.TextView[@text='" + productName+ "']")).click();
		driver.findElement(By.xpath(productsXpathValue(productName))).click();

	}

	public String productsXpathValue(String productName) {
		return "//android.widget.TextView[@text='" + productName + "']";
	}

	public void clickOnCartIcon() {
		openCart.click();
	}

	public void clickOnFilterLink() {
		filterLink.click();
	}

	public void filter(String filterText) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + filterText + "']")).click();
	}

	public String getFirstProduct() {
		return listOfProduts.get(0).getText();
	}

}
