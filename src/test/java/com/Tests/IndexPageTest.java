package com.Tests;


import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.List;


public class IndexPageTest extends BaseClass {


    static WebDriverWait wait;

    public IndexPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {

        try {
            initialization();

        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void a_verifyLeftMenuLinks() {

        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
        System.out.println("Title of the page is: "+driver.getTitle());
        driver.navigate().refresh();

        String[] arr_menu = {"Solutions", "About Us", "Services", "Products", "Locations", "Admin Page"};

        List<WebElement> leftMenu = driver.findElements(By.cssSelector("ul.leftmenu li"));

        for (int i = 0; i < arr_menu.length; i++) {
            String expected_text = arr_menu[i];
            String actual_text;

            WebElement menu1 = leftMenu.get(i);
            actual_text = menu1.getText();

            if(expected_text.equals(actual_text)) {
                System.out.println(expected_text + " is available on left menu list");
            }
            else {
                System.out.println(expected_text + " is not available on left menu list");
            }
        }

    }

    @Test(priority = 2)
    public void b_verifyHeaderButtons() {
        driver.navigate().refresh();

        List<WebElement> menuButtons = driver.findElements(By.cssSelector("ul.button li"));

        String[] arr_Buttons = {"home", "about", "contact"};

        for (int i = 0; i < arr_Buttons.length; i++) {
            String expected_button = arr_Buttons[i];
            String actual_Button;

            WebElement menu = menuButtons.get(i);

            if (menu.findElements(By.tagName("a")).size() > 0) {
                actual_Button = menu.findElement(By.tagName("a")).getText();
            }
            else {
                actual_Button = menu.getText();
            }

            if (actual_Button.equals(expected_button)) {
                System.out.println(expected_button + " button is available on the panel");
            }
            else {
                System.out.println(expected_button + " button is not available on the panel");
            }

        }

    }

    @Test(priority = 3)
    public void c_verifyFooterPanelLinks() {

        driver.navigate().refresh();

        String[] arr_footerLinks = {"Home", "About Us", "Services", "Products", "Locations", "Forum", "Site Map", "Contact Us"};

        List<WebElement> listFooterLinks = driver.findElements(By.cssSelector("#footerPanel li"));

        for ( int i = 0 ; i < arr_footerLinks.length ; i++) {
            String expected_Footer = arr_footerLinks[i];
            String actual_Footer;

            WebElement footerOpt = listFooterLinks.get(i);
            actual_Footer = footerOpt.getText();

            if (expected_Footer.equals(actual_Footer)) {
                System.out.println(expected_Footer + " is available on Footer menu");
            }
            else {
                System.out.println(expected_Footer + " is not available on Footer menu");
            }
        }
    }

    @AfterMethod
    public void quitAll(){

        driver.quit();
    }


}
