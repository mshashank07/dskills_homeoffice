package com.dskills.homeoffice.assigment;

import com.dskills.homeoffice.assigment.base.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {

    private BaseTest baseTest;
    private String url = System.getProperty("url") == null ? "https://cartaxcheck.co.uk" : System.getProperty("url");

    public Hooks(BaseTest baseTest) {
        this.baseTest = baseTest;
    }


    @Before
    public void setUp() {
        baseTest.browserInitialization();
        baseTest.maxBrowser();
        baseTest.navigateTo(url);
        baseTest.applyImplicit();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            baseTest.takeScreenShot(scenario);
        }
        baseTest.closeBrowser();
    }

}
