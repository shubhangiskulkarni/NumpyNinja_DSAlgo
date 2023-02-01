package com.DSAlgo.qa.testcase;

import com.DSAlgo.qa.base.TestBase;
import com.DSAlgo.qa.pages.GetStartedPage;
import com.DSAlgo.qa.pages.HomePage;
import com.DSAlgo.qa.util.Loggerload;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetStartedTest extends TestBase {

    GetStartedPage getStartedPage;
    HomePage homePage;


    public GetStartedTest() {
        super();

    }

    @BeforeClass
    public void setup() {

        initialization();
        getStartedPage = new GetStartedPage();
    }

    @Test(priority = 1)
    public void getStartedButtonClickTest() {

        Loggerload.info("Executing test to validate Get Started Button click.");
        homePage = getStartedPage.clickOnGetStarted();

    }

    @Test(priority = 2)
    public void validateUserLandingHomePageTest() {
        Loggerload.info("Executing test to validate Home Page...");
        String HomePageTitle = driver.getTitle();

        Loggerload.info("Title of the home page is: " + HomePageTitle);
        Assert.assertEquals(HomePageTitle, "NumpyNinja");

    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
