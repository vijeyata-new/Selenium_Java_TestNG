package com.Tests;

import base.BaseClass;
import org.example.Pages.AboutUsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AboutUsTest extends BaseClass {

    AboutUsPage aboutObj;
    public AboutUsTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        aboutObj = new AboutUsPage();

    }


    @Test(priority = 1)
    public void verifyAboutLinks(){

        aboutObj.locateAboutUslink();
    }

    @Test(priority = 2)
    public void verifyTitle(){
        String title = aboutObj.getPageTitle();
        System.out.println("Title of page is-"+title);
    }

    @Test(priority = 3)
    public void verifyPageContent() {
        Boolean verifyText = aboutObj.analyzeText();
        Assert.assertEquals(verifyText,true);
    }

    @AfterMethod
    public void quitAll(){

        driver.quit();
    }
}
