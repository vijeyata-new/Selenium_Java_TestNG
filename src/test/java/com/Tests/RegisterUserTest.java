package com.Tests;

import Utils.webDriverManager;
import base.BaseClass;

import org.bouncycastle.crypto.prng.RandomGenerator;
import org.example.Pages.RegisterPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


public class RegisterUserTest extends BaseClass {

    RegisterPage register;
  //  WebDriver driver;

    String pass1 = "Password@123";
    String pass2 = "Password@123";
    String FirstNAME = "Richard";
    String LastNAME = "Gray";
    String Address = "Main Street";
    String CityName = "London";
    String StateName = "London";
    String ZipCode = "LK 4GG";
    String SSNNum = "112233";
    String username = "newuser55666";


    public RegisterUserTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        register = new RegisterPage();
    }


    @Test(priority = 1)
    public void userRegisterForm() {

        register.gotoRegisterLink();
        register.enterFirstname(FirstNAME);
        register.enterLastname(LastNAME);
        register.enterAddress(Address,CityName,StateName,ZipCode);
        register.enterSSNNum(SSNNum);
        register.enterUserLoginDetails(username,pass1,pass2);
        register.submitRegistrationForm();
    }

    @Test(priority = 2)
    public void verifySuccessRegister() {
        register.validateSuccessMessage(username);
    }

    @AfterMethod
    public void quitAll(){
        driver.quit();
    }
}
