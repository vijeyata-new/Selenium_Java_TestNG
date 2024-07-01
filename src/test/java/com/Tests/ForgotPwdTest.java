package com.Tests;

import base.BaseClass;
import org.example.Pages.ForgotPwdPage;
import org.example.Pages.RegisterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPwdTest extends BaseClass {

    ForgotPwdPage fpp;
    String fpFirstName = "Richard";
    String fpLastName = "Gray";
    String fpAddress = "Main Street";
    String fpCity = "London";
    String fpState = "London";
    String fpZip = "LK 4GG";
    String fpSSN = "112233";

    public ForgotPwdTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        fpp = new ForgotPwdPage();
    }

    @Test(priority = 1)
    public void verifyUserDetails() throws InterruptedException {

        fpp.goToFpLink();
        fpp.fp_userDetails(fpFirstName, fpLastName, fpAddress, fpCity, fpState, fpZip, fpSSN);
        fpp.fp_customerLookup();

    }


    @AfterMethod
    public void quitAll(){

        driver.quit();
    }
}
