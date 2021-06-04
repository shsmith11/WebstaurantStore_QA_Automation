package com.WebstaurantStore.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;


public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    protected HomePage homePage;


    public void startUp(){
        homePage = new HomePage(driver);

    }
    //public void openPage(String url){driver.get(url);}

    @BeforeMethod(groups = {"AllBrowsers"}, alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional ("chrome") String browser, Method method) throws InterruptedException {
        if (browser.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions()
                    .addPreference("dom.webnotifications.enabled", false)
                    .addPreference("geo.enabled", true)
                    .addPreference("geo.provider.use_corelocation", true)
                    .addPreference("geo.prompt.testing", true)
                    .addPreference("geo.prompt.testing.allow", true);

            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver(options);
            driver.manage().deleteAllCookies();
        }
        else if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless");
            options.addArguments("--disable-geolocation");
            driver = new ChromeDriver(options);
            driver.get("chrome://settings/clearBrowserData");
            //Thread.sleep(3000);
            //driver.switchTo().activeElement();
            //driver.findElement(By.cssSelector("* /deep/ #clearBrowsingDataConfirm")).click();
        }
        else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
            driver = new EdgeDriver();
            driver.manage().deleteAllCookies();
        }
        else if (browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().deleteAllCookies();
        }
        else if (browser.equalsIgnoreCase("opera")){
            System.setProperty("webdriver.opera.driver", "operadriver.exe");
            OperaOptions options = new OperaOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-notifications");
            driver = new OperaDriver(options);
            driver.manage().deleteAllCookies();
        }

        startUp();
        driver.manage().window().maximize();
       }



    @AfterMethod
    public void tearDown() throws InterruptedException {
      // Thread.sleep(1000);
       driver.quit();
    }


}
