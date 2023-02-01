package com.DSAlgo.qa.testcase;

import com.DSAlgo.qa.base.TestBase;
import com.DSAlgo.qa.pages.GetStartedPage;
import com.DSAlgo.qa.pages.HomePage;
import com.DSAlgo.qa.pages.RegisterPage;
import com.DSAlgo.qa.util.ExcelUtils;
import com.DSAlgo.qa.util.Loggerload;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {

    GetStartedPage getStartedPage;
    HomePage homePage;
    RegisterPage registerPage;

    public RegisterPageTest() {
        super();

    }

    @DataProvider
    public Object[][] UserNameAndPWDs() throws Exception {

        Object[][] testObjArray = ExcelUtils.getTableArray(prop.getProperty("TestDataSheet"), "RegisterUser");

        return (testObjArray);

    }

    @BeforeClass
    public void setup() {

        initialization();

        getStartedPage = new GetStartedPage();
        homePage = new HomePage();

        homePage = getStartedPage.clickOnGetStarted();
        registerPage = homePage.ClickRegisterUserLnk();

    }

    @Test(enabled = false, priority = 3, dataProvider = "UserNameAndPWDs")
    public void validateUserNameErrors(String UName, String Pwd, String ConfPwd) {

        Loggerload.info("Executing test to validate if error is displayed when username is wrong.");

        registerPage.enterUserName(UName);
        registerPage.enterPwd(Pwd);
        registerPage.enterConfPwd(ConfPwd);
        registerPage.clickOnRegisterBtn();

    }

    // Test case #12
    @Test(priority = 1)
    public void VerifyUserLandedRegisterPageTest() {
        Loggerload.info("Executing test to validate if user landed on Register Page.");

        String RegiTitle = registerPage.getTitleOfCurrentPage();
        Assert.assertEquals(RegiTitle, "Registration", "User has landed on Register page.");

    }


    // Test case #13
    @Test(priority = 2)
    public void verifyRegisterWithAllFieldEmpty() {
        Loggerload.info("Executing test case to validate error message on username field");
        registerPage.clickOnRegisterBtn();
        String errorMessage = registerPage.getValidationMessage("username");

        //to check what error message is displayed on the page.
        Loggerload.info("The error message from Register Page is: " + errorMessage);

        Assert.assertEquals(errorMessage, "Please fill out this field.");

    }


    // Test case #14
    @Test(priority = 3)
    public void verifyRegisterWithDataInOnlyUserNameField() {
        Loggerload.info("Executing test case to validate error message on username field");
        registerPage.enterUserName("TestCase14");
        registerPage.clickOnRegisterBtn();
        String errorMessage = registerPage.getValidationMessage("password1");

        //to check what error message is displayed on the page.
        Loggerload.info("The error message from Register Page is: " + errorMessage);

        Assert.assertEquals(errorMessage, "Please fill out this field.");

    }

    // Test case #15
    @Test(priority = 4)
    public void verifyRegisterWithDataInOnlyUserNamePWDField() {
        Loggerload.info("Executing test case to validate error message on username field");
        registerPage.enterUserName("TestCase15");
        registerPage.enterPwd("TestCase15");
        registerPage.clickOnRegisterBtn();
        String errorMessage = registerPage.getValidationMessage("password2");

        //to check what error message is displayed on the page.
        Loggerload.info("The error message from Register Page is: " + errorMessage);

        Assert.assertEquals(errorMessage, "Please fill out this field.");

    }

    // Test case #17
    @Test(priority = 5)
    public void verifyRegisterWithDffDataInPWDAndConfPWDField() {

        Loggerload.info("Executing test case to validate error message on username field");
        registerPage.enterUserName("TestCase17");
        registerPage.enterPwd("TestCase17");
        registerPage.enterConfPwd("TestCase15");
        registerPage.clickOnRegisterBtn();

        String errorMessage = registerPage.getPwdMismatchMsg();


        //to check what error message is displayed on the page.
        Loggerload.info("The error message from Register Page is: " + errorMessage);

        Assert.assertEquals(errorMessage, "password_mismatch:The two password fields didn’t match.");

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
