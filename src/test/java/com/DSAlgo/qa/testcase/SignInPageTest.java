package com.DSAlgo.qa.testcase;

import com.DSAlgo.qa.base.TestBase;
import com.DSAlgo.qa.pages.GetStartedPage;
import com.DSAlgo.qa.pages.HomePage;
import com.DSAlgo.qa.pages.SignInPage;
import com.DSAlgo.qa.util.Loggerload;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInPageTest extends TestBase {

    GetStartedPage getStartedPage;
    HomePage homePage;
    SignInPage signInPage;

    public SignInPageTest() {
        super();


    }

    @BeforeMethod
    public void setup() {

        initialization();

        getStartedPage = new GetStartedPage();
        homePage = new HomePage();
        homePage = getStartedPage.clickOnGetStarted();
        signInPage = homePage.clickLoginUserLnk();

    }

    //Test Case # 23
    @Test(priority = 1)
    public void validateInvalidUserNameAndPassword() {

        Loggerload.info("Executing test case to validate error message when username and password is invalid");

        signInPage.enterUserName("TestCaseChkName");
        signInPage.enterPwd("TestCaseChkPwd");
        signInPage.clickOnLoginBtn();
        String alertMsg = signInPage.checkAlertMsg();
        Assert.assertEquals(alertMsg, "Invalid Username and Password", "Checking for alert for invalid user name and password.");
    }

    //Test Case #24
    @Test(priority = 2)
    public void validateUserLoggedInMsg() {

        Loggerload.info("Executing test case to validate login message.");

        signInPage.enterUserName("shubhangi");
        signInPage.enterPwd("DSAlgoA2S2");
        signInPage.clickOnLoginBtn();
        String alertMsg = signInPage.checkAlertMsg();
        Assert.assertEquals(alertMsg, "You are logged in", "Checking for valid alert message.");

    }

    @Test(priority = 3)
    public void validateUserNmDisplayed() {
        Loggerload.info("Executing test case to validate user name display.");
        signInPage.enterUserName("shubhangi");
        signInPage.enterPwd("DSAlgoA2S2");
        signInPage.clickOnLoginBtn();
        String userNmDisplay = signInPage.isLoginNmDisplayed();
        Assert.assertEquals(userNmDisplay, "Shubhangi");


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}