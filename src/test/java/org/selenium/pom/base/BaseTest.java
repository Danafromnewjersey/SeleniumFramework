package org.selenium.pom.base;

import io.restassured.http.Cookies;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.constants.DriverType;
import org.selenium.pom.factory.DriverManagerFactory;
import org.selenium.pom.factory.DriverManagerOriginal;
import org.selenium.pom.utils.CookieUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.List;

//
//public class BaseTest {
//    protected WebDriver driver;
////    @Before
//    @BeforeEach
//    public void startDriver () {
//        String browser = System.getProperty("browser");
////        String browser = "FIREFOX";
//        driver = new DriverManager().initializeDriver(browser);
//        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
//                "DRIVER = " + driver);
//    }
//
////    @After
//    @AfterEach
//    public void quitDriver () throws InterruptedException {
//        Thread.sleep(100);
//        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
//                "DRIVER = " + driver);
//        driver.quit();
//    }
//}
// config with testng annotation
public class BaseTest {
    //keep this class clean don't add more and more method;
    private ThreadLocal<WebDriver>driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public synchronized void  startDriver(@Optional String browser) {
        browser = System.getProperty("browser", browser);
 //       if (browser==null)browser = "CHROME";
//        setDriver(new DriverManagerOriginal().initializeDriver(browser));
        setDriver(DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver());
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
    }

    @Parameters("browser")
    @AfterMethod
    public synchronized void quitDriver (@Optional String browser, ITestResult result) throws InterruptedException, IOException {
        Thread.sleep(300);
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
//        getDriver().quit();
        if (result.getStatus() == ITestResult.FAILURE) {
            File destFile = new File("scr" + File.separator + browser + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + ".png");
            takeScreenshot(destFile);

        }
    }
    public void injectCookiesToBrowser(Cookies cookies){
            List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
            for (Cookie cookie : seleniumCookies) {
                getDriver().manage().addCookie(cookie);
            }
        }
        private void takeScreenshot (File destFile) throws IOException {
            TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, destFile);
        }
}
