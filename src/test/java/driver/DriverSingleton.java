package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
//            String browser = System.getProperty("browser");
//            if ("firefox".equals(browser)) {
//                driver = new FirefoxDriver();
//            } else if ("opera".equals(browser)) {
//                driver = new OperaDriver();
//            } else {
                driver = new ChromeDriver();
           // }

            driver.manage().window().maximize();
        }
        return driver;
    }



    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}