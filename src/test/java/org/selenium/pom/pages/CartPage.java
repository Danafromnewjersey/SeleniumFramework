package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
 //   Crt+Shift +/ - comment block
    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutButton = By.xpath("//a[contains(text(),'Proceed to checkout')]");
    public final By cartHeader = By.xpath("//h1[contains(text(),'Cart')]");
    //Page Factory
//    @FindBy(xpath = "(//a[@href='https://askomdch.com/product/blue-shoes/'])[2]") private WebElement productName;
  //  @FindBy(xpath = "//h1[contains(text(),'Cart')]") private WebElement cartHeader;
    //
//    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Proceed to checkout')]") @CacheLookup private WebElement checkoutButton;//how option
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); //if you wanna use PF for entaire project move it to BasePage
    }
    public Boolean isLoaded() {
        return wait.until(ExpectedConditions.textToBe(cartHeader,"Cart"));
    }
    @Step
    public String getProductName() {
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();//driver FE option
//        productName.getText(); //using pageFactory
//        or see another PF method below
//        return  wait.until(ExpectedConditions.visibilityOf(productName)).getText(); //we using page factory
    }
    public CheckoutPage checkout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        return new CheckoutPage(driver);
    }
}
