package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.components.ProductThumbnail;

public class StorePage extends BasePage {
    private final By searchField = By.cssSelector("#woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private ProductThumbnail productThumbnail;

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }
    //  private final By addToCartBtn = By.xpath("//h1[@class='woocommerce-products-header__title page-title']");
    //instead of create element statically, need create element dynamically;
    public StorePage(WebDriver driver) {
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
    }
    private StorePage enterTextInSearchField (String txt) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(txt);
        return this;
    }

    public StorePage load(){
        load("/store");
        return this;
    }

    public Boolean isLoaded() {
       return wait.until(ExpectedConditions.urlMatches("/store"));
    }
    public StorePage search (String text) {
        //you can change these 2 methods see below
//        driver.findElement(searchField).sendKeys();
//        driver.findElement(searchBtn).click();
        enterTextInSearchField(text).
        clickSearchBtn();
        return this;
    }
    //change statement to private if you dont want to expoce this method
    private StorePage clickSearchBtn () {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();
        return this;
    }
    public  String getTitle () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }
//    public void clickAddToCartBtn (){
//        driver.findElement(addToCartBtn).click();
//    }
//    private  By getAddToCartBtnElement (String productName){
//        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
//    }
}
