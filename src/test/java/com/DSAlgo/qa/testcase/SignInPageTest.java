package com.DSAlgo.qa.testcase;

import com.DSAlgo.qa.base.TestBase;
import com.DSAlgo.qa.pages.GetStartedPage;
import com.DSAlgo.qa.pages.HomePage;
import com.DSAlgo.qa.pages.SignInPage;
import com.DSAlgo.qa.util.ExcelUtils;
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
    public void validateUserLoggedInMsg() throws Exception {

        Loggerload.info("Executing test case to validate login message.");

        Object[][] testObjArray = ExcelUtils.getTableArray(prop.getProperty("TestDataSheet"), "SignIn");

        signInPage.enterUserName(testObjArray[0][1].toString());
        signInPage.enterPwd(testObjArray[0][2].toString());

        signInPage.clickOnLoginBtn();
        String alertMsg = signInPage.checkAlertMsg();
        Assert.assertEquals(alertMsg, "You are logged in", "Checking for valid alert message.");

    }

    @Test(priority = 3)
    public void validateUserNmDisplayed() throws Exception  {

        Loggerload.info("Executing test case to validate user name display.");

        Object[][] testObjArray = ExcelUtils.getTableArray(prop.getProperty("TestDataSheet"), "SignIn");
        signInPage.enterUserName(testObjArray[0][1].toString());
        signInPage.enterPwd(testObjArray[0][2].toString());

        signInPage.clickOnLoginBtn();
        String userNmDisplay = signInPage.isLoginNmDisplayed();
        Assert.assertEquals(userNmDisplay, "Shubhangi");


    }


    @Test
    public void validateGitHub() {
    	
    	//Comment from new test case...
    	
    	
    }
    
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}