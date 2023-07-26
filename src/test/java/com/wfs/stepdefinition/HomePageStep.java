package com.wfs.stepdefinition;

import org.testng.Assert;

import com.wfs.base.BaseTest;
import com.wfs.base.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStep {
	BaseTest base;
	DriverManager manager;;

	public HomePageStep(BaseTest base) {
		this.base = base;
		this.manager = base.manager;
	}

	@Given("user is on home page")
	public void user_is_on_home_page() {

		Assert.assertEquals(manager.getHomePage().getHomePageHeading(), "Products");
	}

	@When("user select filter options {string}")
	public void user_select_filter_options(String filterOption) {
		manager.getHomePage().clickOnFilterLink();
		manager.getHomePage().filter(filterOption);

	}

	@Then("products on home page should be sorted {string}")
	public void products_on_home_page_should_be_sorted(String productName) {
		Assert.assertEquals(manager.getHomePage().getFirstProduct(), productName);
		System.out.println(productName);

	}

	@When("user select products {string}")
	public void user_select_products(String productName) {
		manager.getHomePage().selectProduct(productName);
	}

	@When("click on add to cart")
	public void click_on_add_to_cart() {
		manager.getHomePage().clickOnAddToCart();
	}

	@Then("product should be added to cart")
	public void product_should_be_added_to_cart() {
		manager.getHomePage().clickOnCartIcon();
		Assert.assertEquals(manager.getCartPage().getCartPageHeading(), "My Cart");
		Assert.assertEquals(manager.getCartPage().getCartCount(), "1");
	}

}
