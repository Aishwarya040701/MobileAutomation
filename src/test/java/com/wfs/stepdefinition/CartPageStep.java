package com.wfs.stepdefinition;

import org.testng.Assert;
import com.wfs.base.BaseTest;
import com.wfs.base.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageStep {

	String cartCount, totalPrice;
	BaseTest base;
	DriverManager manager;

	public CartPageStep(BaseTest base) {
		this.base = base;
		this.manager = base.manager;
	}

	@Given("user is on Homepage of DemoApp")
	public void user_is_on_homepage_of_my_demo_app() {

		Assert.assertEquals(manager.getHomePage().getHomePageHeading(), "Products");
	}

	@Given("add products to cart and move to cart page")
	public void And_add_products_to_cart_and_move_to_cart_page() {
		manager.getHomePage().selectProductBackpack();

		manager.getHomePage().clickOnAddToCart();
		base.driver.navigate().back();
		manager.getHomePage().scrollBy("Sauce Labs Onesie");
		manager.getHomePage().selectProductOnesies();
		manager.getHomePage().clickOnAddToCart();
		manager.getHomePage().clickOnCartIcon();

	}

	@Given("user is on cart page")
	public void Given_user_is_on_cart_page() {

		Assert.assertEquals(manager.getCartPage().getCartPageHeading(), "My Cart");

	}

	@When("check cart value with actual and expected cart value as three products must be equal")
	public void check_cart_value_with_actual_and_expected_cart_value_as_three_products_must_be_equal() {
		Assert.assertEquals(manager.getCartPage().getCartCount(), "3");

	}

	@When("remove Onesie product from cart")
	public void remove_Sauce_Labs_Onesie_product_from_cart() {
		manager.getCartPage().removeProductFromCart();

	}

	@When("check cart value with actual and expected cart value as two products must be equal")
	public void check_cart_value_with_actual_and_expected_cart_value_as_two_products_must_be_equal() {
		Assert.assertEquals(manager.getCartPage().getCartCount(), "2");

	}

	@When("check products added are displayed in cart")
	public void check_products_added_are_displayed_in_cart() {
		Assert.assertTrue(manager.getCartPage().checkProductBackpackIsDisplayed());
		Assert.assertTrue(manager.getCartPage().checkProductOnesiesIsDisplayed());
	}

	@When("check product added and product in cart are same")
	public void check_product_added_and_product_in_cart_are_same() {
		Assert.assertEquals(manager.getHomePage().gerProductBackpackText(),
				manager.getCartPage().gerProductBackpackText());
		Assert.assertEquals(manager.getHomePage().gerProductOnesiesText(),
				manager.getCartPage().gerProductOnesiesText());
	}

	@Then("product are verifed")
	public void product_are_verifed() {
		System.out.println("product verified");
	}

	@When("check total price value")
	public void check_total_price_value() {

		totalPrice = manager.getCartPage().getTotalPrice();
	}

	@When("actual and expected total price of three must be equal")
	public void actual_and_expected_total_price_of_three_must_be_equal() {
		Assert.assertEquals(totalPrice, "$67.97");

	}

	@When("scroll up to remove button")
	public void scroll_up_to_remove_button() {
		manager.getCartPage().scrollUp();
	}

	@Then("actual and expected total price of two must be equal")
	public void actual_and_expected_total_price_of_two_must_be_equal() {
		Assert.assertEquals(totalPrice, "$59.98");

	}

}
