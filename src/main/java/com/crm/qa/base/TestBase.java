package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utils.TestUtils;
import com.crm.qa.utils.WebEventListeners;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListeners eventListener;

    public TestBase() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Mallukinnis\\eclipse-workspace\\RestAssuredAPIDemo\\SeleniumCompleteAutomationFrameWorkDesign\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        // Browser is read from the property file
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mallukinnis\\eclipse-workspace\\RestAssuredAPIDemo\\SeleniumCompleteAutomationFrameWorkDesign\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mallukinnis\\eclipse-workspace\\RestAssuredAPIDemo\\SeleniumCompleteAutomationFrameWorkDesign\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Mallukinnis\\eclipse-workspace\\RestAssuredAPIDemo\\SeleniumCompleteAutomationFrameWorkDesign\\drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create an object of WebEventListeners to register it with EventFiringWebDriver
        eventListener = new WebEventListeners();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url")); // Read this from the property file
    }
}