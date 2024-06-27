package org.example.Pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AboutUsPage extends BaseClass {

    @FindBy(xpath = "//h1[contains(text(),'ParaSoft Demo Website')]")
    WebElement DemoText;

    @FindBy(xpath = "//a[text()='About Us']")
    WebElement linkAbout;


    public void locateAboutUslink(){

        linkAbout.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean analyzeText(){

        String actual_Text = DemoText.getText();
        String expected_Text = "ParaSoft Demo Website";

        return actual_Text.equals(expected_Text);
    }

}
