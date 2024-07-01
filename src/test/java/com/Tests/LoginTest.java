package com.Tests;

import base.BaseClass;
import org.example.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
     LoginPage loginpage;
     BaseClass basepage;
   //  WebDriver driver;
    String UserName = "newuser55666";
    String Password = "Password@123";

     public LoginTest(){
         super();
     }

     @BeforeMethod
     public void setup() throws InterruptedException{

         initialization();
         loginpage = new LoginPage();

     }

     @Test(priority = 1)
     public void loginTest() {
      //   basepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
         loginpage.login(UserName, Password);

     }

    @AfterMethod
    public void quitAll(){

         driver.quit();
    }

}
