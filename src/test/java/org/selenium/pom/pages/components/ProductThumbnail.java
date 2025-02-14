package org.selenium.pom.pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.CartPage;

public class ProductThumbnail extends BasePage {
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public ProductThumbnail(WebDriver driver) {
        super(driver);
    }
    private By getAddToCartBtnElement (String productName){
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    @Step
    public ProductThumbnail clickAddToCardBtn (String productName){
        By addToCartBtn = getAddToCartBtnElement(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn)).click();
        return this;
    }
    @Step
    public CartPage clickViewCart () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink)).click();
        return new CartPage (driver);
    }
}
