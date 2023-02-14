package com.DSAlgo.qa.pages;

import com.DSAlgo.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends TestBase {


//elements

    @FindBy(xpath = "//input[@id='id_username']")
    WebElement Username;

    @FindBy(xpath = "//input[@id='id_password']")
    WebElement password;


    @FindBy(xpath = "//input[@type='submit']")
    WebElement login;

    @FindBy(xpath = "//div[@class='alert alert-primary']")
    WebElement loggedInAlert;


    //ul/a[2]
    //*[@id="navbarCollapse"]/div[2]/ul/a[2]
    @FindBy(xpath = " //*[@id=\"navbarCollapse\"]/div[2]/ul/a[2]")
    WebElement userNmDisplayed;


    public SignInPage() {

        PageFactory.initElements(driver, this);

    }

    public String getValidationMessage(String fieldNm) {

        // This element is not visible by default when page loads. So PageFactory can't initialize it. (Line #28).
        // That's why we need to find when we know it should be available for driver.
        String UserNameEmptyMsg = driver.findElement(By.name(fieldNm)).getAttribute("validationMessage");
        return UserNameEmptyMsg;

    }

    public void clickOnLoginBtn() {

        login.click();

    }

    public void enterUserName(String Nm) {

        Username.sendKeys(Nm);

    }

    public void enterPwd(String pwd) {

        password.sendKeys(pwd);
    }

    public String checkAlertMsg() {

        loggedInAlert.isDisplayed();
        String msg = loggedInAlert.getText();
        return msg;

    }

    public String isLoginNmDisplayed() {

        String loggedInUserName;

        if (userNmDisplayed.isDisplayed()) {

            loggedInUserName = userNmDisplayed.getText();

        } else {

            return "Control is not displayed.";

        }

        return loggedInUserName;


    }

}
