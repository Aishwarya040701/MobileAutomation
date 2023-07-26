package com.wfs.stepdefinition;

import org.testng.Assert;

import com.wfs.base.BaseTest;
import com.wfs.base.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductCheckProcessStep {
	String productCount;
	BaseTest base;
	DriverManager manager;

	public ProductCheckProcessStep(BaseTest base) {
		this.base = base;
		this.manager = base.manager;
	}

	@Given("user is on Homepage of MyDemoApp")
	public void user_is_on_homepage_of_my_demo_app() {

		Assert.assertEquals(manager.getHomePage().getHomePageHeading(), "Products");
	}

	@When("user select product Sauce Labs Backpack")
	public void user_select_product_sauce_labs_backpack() {
		productCount = manager.getHomePage().selectProductBackpack();
		Assert.assertEquals(productCount, "2");
		manager.getHomePage().clickOnAddToCart();

	}

	@When("user navigate back to home page")
	public void user_navigate_back_to_home_page() {
		base.driver.navigate().back();
	}

	@When("user will scroll down")
	public void user_will_scroll_down() {
		manager.getHomePage().scrollBy("Sauce Labs Onesie");

	}

	@When("select another product Sauce Labs Onesie")
	public void select_another_product_sauce_labs_onesie() {
		productCount = manager.getHomePage().selectProductOnesies();
		Assert.assertEquals(productCount, "1");
		manager.getHomePage().clickOnAddToCart();
		base.driver.navigate().back();
		manager.getHomePage().scrollBy("Sauce Labs Backpack");
	}

	@When("will click on cartIcon")
	public void will_click_on_cart_icon() {
		manager.getHomePage().clickOnCartIcon();
		Assert.assertEquals(manager.getCartPage().getCartPageHeading(), "My Cart");
		Assert.assertEquals(manager.getCartPage().getCartCount(), "3");
	}

	@When("remove Sauce Labs Onesie product from cart")
	public void remove_sauce_labs_onesie_product_from_cart() {
		manager.getCartPage().removeProductFromCart();
	}

	@When("check the total price")
	public void check_the_total_price() {
		Assert.assertEquals(manager.getCartPage().getTotalPrice(), "$59.98");
	}

	@When("click on Proceed To Checkout")
	public void click_on_proceed_to_checkout() {
		manager.getCartPage().clickOnProceedToCheckoutButton();
	}

	@When("login with valid details")
	public void login_with_valid_details() {
		manager.getLoginPage().EnterLoginDetailsWithLink();

	}

	@When("will compelete the registration with valid details")
	public void will_compelete_the_registration_with_valid_details() {
		manager.getCheckoutPage().registration();
	}

	@When("will click on payment button")
	public void will_click_on_payment_button() {
		manager.getCheckoutPage().clickOnToPaymentButton();
	}

	@When("add payment details")
	public void add_payment_details() {
		manager.getCheckoutPage().getCkeckoutPageHeading();
		manager.getCheckoutPage().enterPaymentDetails();
	}

	@When("click on Review order button")
	public void click_on_review_order_button() {
		manager.getCheckoutPage().clickOnReviewOrderButton();
	}

	@When("click on Place order button")
	public void click_on_place_order_button() {
		manager.getCheckoutPage().clickOnPlaceOrderButton();
	}

	@Then("order should be placed")
	public void order_should_be_placed() {

		Assert.assertEquals(manager.getCheckoutPage().getCheckoutCompleteMessage(), "Checkout Complete");

	}

	@Then("logout from the website")
	public void click_on_menu_button() {
		manager.getCheckoutPage().Logoutlink();
		base.driver.switchTo().alert().accept();

	}

}
