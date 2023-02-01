package com.DSAlgo.qa.pages;

import com.DSAlgo.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetStartedPage extends TestBase {

    @FindBy(xpath = "//a[@href='/home']")
    WebElement getStartedBtn;

    public GetStartedPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage clickOnGetStarted() {
        getStartedBtn.click();
        return new HomePage();
    }

}
