package com.DSAlgo.qa.pages;

import com.DSAlgo.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends TestBase {

    //elements
    @FindBy(xpath = "//input[@id='id_username']")
    WebElement UserName;


    @FindBy(xpath = "//input[@id='id_password1']")
    WebElement password;

    @FindBy(xpath = "//input[@id='id_password2']")
    WebElement Confpassword;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement Register;


    public RegisterPage() {

        PageFactory.initElements(driver, this);
    }


    //Actions
    public String getValidationMessage(String fieldNm) {

        // This element is not visible by default when page loads. So PageFactory can't initialize it. (Line #28). That's why we need to find when we know it should be available for driver.
        String UserNameEmptyMsg = driver.findElement(By.name(fieldNm)).getAttribute("validationMessage");
        return UserNameEmptyMsg;

    }


    public void clickOnRegisterBtn() {

        Register.click();
    }

    public void enterUserName(String nm) {

        UserName.sendKeys(nm);

    }

    public void enterPwd(String pw) {

        password.sendKeys(pw);

    }

    public void enterConfPwd(String cpw) {

        Confpassword.sendKeys(cpw);

    }

    public String getPwdMismatchMsg(){

        WebElement PwdMismatch = driver.findElement(By.xpath("//div[3]"));
        return PwdMismatch.getText();

    }


}


