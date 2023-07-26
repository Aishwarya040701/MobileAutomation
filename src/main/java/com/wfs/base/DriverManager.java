package com.wfs.base;

import com.wfs.pages.CartPage;
import com.wfs.pages.CheckoutPage;
import com.wfs.pages.HomePage;
import com.wfs.pages.LoginPage;

import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

	AndroidDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	CartPage cartpage;
	CheckoutPage checkoutpage;

	public DriverManager(AndroidDriver driver) {
		this.driver = driver;
	}

	// login page object
	public LoginPage getLoginPage() {
		return (loginpage == null) ? loginpage = new LoginPage(this.driver) : loginpage;
	}

	// product page object
	public HomePage getHomePage() {
		return (homepage == null) ? homepage = new HomePage(this.driver) : homepage;
	}

	// YourCart page object
	public CartPage getCartPage() {
		return (cartpage == null) ? cartpage = new CartPage(this.driver) : cartpage;
	}

	// your information page object
	public CheckoutPage getCheckoutPage() {
		return (checkoutpage == null) ? checkoutpage = new CheckoutPage(this.driver) : checkoutpage;
	}

}
