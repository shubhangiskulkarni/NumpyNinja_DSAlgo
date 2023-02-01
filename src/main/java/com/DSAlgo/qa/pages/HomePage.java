package com.DSAlgo.qa.pages;

import com.DSAlgo.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//a[@href='/login']")
    WebElement loginLnk;

    @FindBy(xpath = "//a[@href='/register']")
    WebElement registerLnk;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logoutBtn;

    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
    WebElement HomePageDropdwn;

    @FindBy(xpath = "//div[contains(text(),'You are logged in')]")
    WebElement loginMsg;

    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    public String LandedHomePage() {

        return driver.getCurrentUrl();

    }

    public boolean LogoutUserBtn() {

        return logoutBtn.isDisplayed();

    }

    public RegisterPage ClickRegisterUserLnk() {

        registerLnk.click();
        return new RegisterPage();

    }

    public SignInPage clickLoginUserLnk() {

        loginLnk.click();
        return new SignInPage();

    }

    public boolean LoginSuccessMessage() {

        return loginMsg.isDisplayed();
    }

    public void ClickOnDropdown() {

        HomePageDropdwn.click();
    }
}
