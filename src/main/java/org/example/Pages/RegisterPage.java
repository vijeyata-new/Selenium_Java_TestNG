package org.example.Pages;

import base.BaseClass;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BaseClass {
  //  WebDriver driver;

    @FindBy(id = "customer.firstName")
    WebElement firstname;

    @FindBy(id = "customer.lastName")
    WebElement lastname;

    @FindBy(id = "customer.address.street")
    WebElement address;

    @FindBy(id = "customer.address.city")
    WebElement city;

    @FindBy(id = "customer.address.state")
    WebElement state;

    @FindBy(id = "customer.address.zipCode")
    WebElement zipcode;

    @FindBy(id = "customer.ssn")
    WebElement ssnnumber;

    @FindBy(id = "customer.username")
    WebElement registerUsername;

    @FindBy(id = "customer.password")
    WebElement registerPassword;

    @FindBy(id = "repeatedPassword")
    WebElement repeatPassword;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement registerbutton;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerLink;

    @FindBy(xpath = "//h1[contains(text(),'Welcome')]")
    WebElement welcomeUserText;

    @FindBy(xpath = "//p[contains(text(),'successfully')]")
    WebElement successMsg;


    public RegisterPage() {
        PageFactory.initElements(driver,this);
    }

    public void gotoRegisterLink() {
        registerLink.click();
    }

    public void enterFirstname(String firstNme) throws NullPointerException {
        try {
            firstname.sendKeys(firstNme);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
    public void enterLastname(String lastNme) {
        try {
            lastname.sendKeys(lastNme);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
    public void enterAddress(String addr, String cityname, String statename, String zip) {
        try {
            address.sendKeys(addr);
            city.sendKeys(cityname);
            state.sendKeys(statename);
            zipcode.sendKeys(zip);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
    public void enterSSNNum(String SSN ) {
        try {
            ssnnumber.sendKeys(SSN);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

    }


    public void enterUserLoginDetails(String Username, String pass1, String pass2) {
        registerUsername.sendKeys(Username);
        registerPassword.sendKeys(pass1);
        repeatPassword.sendKeys(pass2);
    }

    public void submitRegistrationForm(){
        registerbutton.click();
    }

    public void validateSuccessMessage(String Username) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(welcomeUserText));

            String actual_text = welcomeUserText.getText();
            String expected_text = "Welcome "+Username;

            if(actual_text.equals(expected_text)) {
                System.out.println("User registered successfully");
                System.out.println("Success message is shown as below-"+successMsg.getText());
            }
            else {
                System.out.println("User is not registered");
            }
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }

}
