package com.DSAlgo.qa.testcase;

import com.DSAlgo.qa.base.TestBase;
import com.DSAlgo.qa.pages.GetStartedPage;
import com.DSAlgo.qa.pages.HomePage;
import com.DSAlgo.qa.pages.RegisterPage;
import com.DSAlgo.qa.pages.SignInPage;
import com.DSAlgo.qa.util.Loggerload;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    GetStartedPage getStartedPage;
    HomePage homePage;
    SignInPage signInPage;
    RegisterPage registerPage;


    public HomePageTest() {
        super();

    }

    @BeforeMethod
    public void setup() {
        initialization();

        homePage = new HomePage();
        getStartedPage = new GetStartedPage();

        homePage = getStartedPage.clickOnGetStarted();

    }

    @Test(priority = 1)
    public void VerifyUserLandedHomePageTest() {


        Loggerload.info("Executing test to validate if user landed on Home Page.");

        String homeURL = homePage.LandedHomePage();
        Assert.assertEquals(homeURL, prop.getProperty("home_url"), "User has landed on home page.");

    }

    @Test(priority = 2)
    public void RegisterLnkClickTest() {
        Loggerload.info("Executing test to validate Register Link click.");
        registerPage = homePage.ClickRegisterUserLnk();

        //How do you know register page is displayed?

    }

    @Test(priority = 3)
    public void LoginLnkClickTest() {
        Loggerload.info("Executing test to validate Login Link click.");
        signInPage = homePage.clickLoginUserLnk();

        //How do you know sign in page is displayed?

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
