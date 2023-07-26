package com.wfs.hooks;

import com.wfs.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	BaseTest base;

	public Hooks(BaseTest base) {
		this.base = base;
	}

	@Before
	public void setUpHook() {
		base.setUp();
	}

	@After
	public void tearDownHook() {

		base.tearDown();
	}

}
