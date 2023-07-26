package com.wfs.stepdefinition;

import org.testng.Assert;
import com.wfs.base.BaseTest;
import com.wfs.base.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep {
	BaseTest base;
	DriverManager manager;

	public LoginPageStep(BaseTest base) {
		this.base = base;
		this.manager = base.manager;
	}

	@Given("User is on login page")
	public void user_is_on_login_page() {
		manager.getHomePage().goToLoginPage();

	}

	@When("user enter valid username as {string} and password as {string}")
	public void user_enter_valid_username_as_and_password_as(String username, String password) {

		manager.getLoginPage().login(username, password);
	}

	@Then("user should be able to login and navigate to home page")
	public void user_should_be_able_to_login_and_navigate_to_home_page() {

		Assert.assertEquals(manager.getHomePage().getHomePageHeading(), "Products");

	}

	@When("user click on the link present in login page")
	public void user_click_on_the_link_present_in_login_page() {
		manager.getLoginPage().EnterLoginDetailsWithLink();
	}

	@Then("the login field get filled automatically and user is logged in")
	public void the_login_field_get_filled_automatically_and_user_is_logged_in() {

		Assert.assertEquals(manager.getHomePage().getHomePageHeading(), "Products");

	}

	@When("user enter invalid username as {string} and password as {string}")
	public void user_enter_invalid_username_as_and_password_as(String username, String password) {

		manager.getLoginPage().login(username, password);
	}

	@Then("user should not be able to login and error message {string} to be displayed")
	public void user_should_not_be_able_to_login_and_error_message_to_be_displayed(String errorMessage) {

		Assert.assertEquals(manager.getLoginPage().getInvalidLoginErrorMeassge(), errorMessage);

	}

}
