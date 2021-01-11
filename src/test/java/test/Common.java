package test;

import driver.DriverSingleton;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class Common {
    protected WebDriver driver;


    @Before
    public void init(){
        driver = DriverSingleton.getDriver();
    }

    @After
    public void quitDriver()
    {
        DriverSingleton.closeDriver();
    }
}
