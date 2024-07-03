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
    String UserName = "malvika111" ;
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
     public void loginTest() throws InterruptedException {
      //   basepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
         loginpage.login(UserName, Password);
         Thread.sleep(5000);
         loginpage.verifyLoginMsg();
     }

    @AfterMethod
    public void quitAll(){

         driver.quit();
    }

}
