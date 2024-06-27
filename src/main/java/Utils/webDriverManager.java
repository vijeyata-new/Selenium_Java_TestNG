package Utils;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webDriverManager {

  //  public static WebDriver driver;

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if(driver==null) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }

        return driver.get();
    }

    public static void quitDriver() {
        if(driver.get()!=null) {
            driver.get().quit();
            driver = null;
        }
    }


}
