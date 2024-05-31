package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.utils.ConfigLoader;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
//    protected WebDriverWait waitLong;
//    protected WebDriverWait waitShort;
    public BasePage (WebDriver driver){
        this.driver = driver;
        //example of long and short waits
//        waitLong = new WebDriverWait(driver, Duration.ofSeconds(15));
//        waitShort = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        PageFactory.initElements(driver, this); add here if you wanna use it for entire project or add to specific page
    }

    public void load (String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseURL()+ endPoint);
    }
    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE: " + overlays.size());
        if (overlays.size() > 0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAY ARE INVISIBLE: ");
        } else{
            System.out.println("OVERLAY NOT FOUND");
        }
    }
    public WebElement waitElementToBeClickable(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
