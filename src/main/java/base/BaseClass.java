package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;


    public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

}
