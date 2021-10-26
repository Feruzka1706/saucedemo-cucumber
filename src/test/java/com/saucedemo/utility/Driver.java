package com.saucedemo.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * We wanted to have a class with that only return Single object
 * no matter how many time you asked for object
 * so we are creating this class with technic we learned from Singleton pattern
 */
public class Driver {

    private static WebDriver driver ;

    static String browser;

    private Driver(){ }

    /**
     * Return obj with only one WebDriver instance
     * @return same WebDriver if exists , new one if null
     */
    public static WebDriver getDriver() {
        // read the browser type you want to launch from properties file
        // String browserName = ConfigReader.read("browser") ;
        if (driver == null) {
            if (System.getProperty("BROWSER") == null) {
                browser = ConfigReader.read("browser");
            } else {
                browser = System.getProperty("BROWSER");
            }
            System.out.println("Browser: " + browser);

            if (driver == null) {

                // according to browser type set up driver correctly
                switch (browser) {
                    case "remote-chrome":
                        try {
                            // assign your grid server address
                            //91.0.4472.77
                            String gridAddress = "54.89.232.72";
                            //54.235.53.73
                            URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("chrome");
                            driver = new RemoteWebDriver(url, desiredCapabilities);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    // other browsers omitted
                    default:
                        driver = null;
                        System.out.println("UNKNOWN BROWSER TYPE!!! " + browser);
                }
                return driver;


            } else {
//            System.out.println("You have it just use existing one");


            }

        }
        return driver;
    }

    /**
     * Quitting the browser and setting the value of
     * WebDriver instance to null because you can re-use already quitted driver
     */
        public static void closeDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }




    }

