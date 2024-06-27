package org.example.Pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {


    @FindBy(xpath= "//input[@name='username']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement userPasswordField;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public void login(String username, String password) {
        userNameField.sendKeys(username);
        userPasswordField.sendKeys(password);
        loginButton.click();

     //   return new LoginPage();
    }

}
