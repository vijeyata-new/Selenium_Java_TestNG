package org.example.Pages;

import base.BaseClass;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class LoginPage extends BaseClass {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath= "//input[@name='username']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement userPasswordField;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement loginButton;
    
    @FindBy(xpath = "//*[text()='Welcome']")
    WebElement msg_welcome;

    @FindBy(css = "#rightPanel h1.title")
    WebElement msg_error;

    @FindBy(css = "#rightPanel p.error")
    WebElement error_msg;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public void login(String username, String password) {
        userNameField.sendKeys(username);
        userPasswordField.sendKeys(password);
        loginButton.click();

     //   return new LoginPage();
    }

    public void verifyLoginMsg() throws NoSuchElementException {
        try {
          //  wait.until(ExpectedConditions.visibilityOf(msg_welcome));
            if(msg_welcome.isDisplayed()) {
                if(Objects.equals(msg_welcome.getText(), "Welcome")) {
                    System.out.println("User logged in successfully");
                    Assert.isTrue(true,"User logged in now");
                }
            } else {
                if (msg_error.isDisplayed()) {
                    System.out.println("User is not logged in");
                    System.out.println("Error is - " + error_msg.getText());
                    Assert.isTrue(false, "user not logged in");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
