package org.example.Pages;

import base.BaseClass;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class ForgotPwdPage extends BaseClass {

    @FindBy(xpath = "//a[text()='Forgot login info?']")
    WebElement Fp_link;

    @FindBy(id = "firstName")
    WebElement Fp_first_name;

    @FindBy(id = "lastName")
    WebElement Fp_last_name;

    @FindBy(id = "address.street")
    WebElement Fp_address;

    @FindBy(id = "address.city")
    WebElement Fp_city;

    @FindBy(id ="address.state")
    WebElement Fp_state;

    @FindBy(id= "address.zipCode")
    WebElement Fp_zip;

    @FindBy(id = "ssn")
    WebElement Fp_ssn;

    @FindBy(xpath = "//input[contains(@value,'Find My Login Info')]")
    WebElement Fp_find_button;

    @FindBy(xpath = "//h1[text()='Customer Lookup']")
    WebElement Fp_lookup_text;

    @FindBy(xpath = "//b[text()='Username']/following-sibling::text()[1]")
    WebElement Fp_username;

    @FindBy(xpath = "//b[text()='Password']/following-sibling::text()[1]")
    WebElement Fp_password;

    @FindBy(xpath = "//a[text()='Log Out']")
    WebElement logout;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public ForgotPwdPage() {
        PageFactory.initElements(driver,this);
    }

    public void goToFpLink() throws InterruptedException {

        Thread.sleep(1000);
        Fp_link.click();
    }

    public void fp_userDetails(String fn, String ln, String add, String cty, String stt, String zp, String ss) {

        Fp_first_name.sendKeys(fn);
        Fp_last_name.sendKeys(ln);
        Fp_address.sendKeys(add);
        Fp_city.sendKeys(cty);
        Fp_state.sendKeys(stt);
        Fp_zip.sendKeys(zp);
        Fp_ssn.sendKeys(ss);
        Fp_find_button.click();
    }

    public void fp_customerLookup() {
        JFrame j;
        try{
            if(wait.until(ExpectedConditions.visibilityOf(Fp_lookup_text)).isDisplayed()) {
                System.out.println("Entered details are correct");
                Assert.isTrue(Fp_lookup_text.isDisplayed(),"false");

                String username = Fp_username.getText().trim();
                String password = Fp_username.getText().trim();
                System.out.println(username);
                System.out.println(password);
                Thread.sleep(5000);
                j = new JFrame();
                JOptionPane.showConfirmDialog(j, "Username is - "+username+"\nPassword is - "+password, "Alert", JOptionPane.OK_CANCEL_OPTION);
            }
            else {
                System.out.println("Entered details are not correct");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
