package org.selenium.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;

public class CheckoutPage extends BasePage {

    private final By firstNameFld = By.xpath("//input[@id='billing_first_name']");
    private final By lastNameFld = By.xpath("//input[@id='billing_last_name']");
    private final By billingCompanyNameFld = By.xpath("//input[@id='billing_company']");
    private final By billingAddress1Fld = By.xpath("//input[@id='billing_address_1']");
    private final By billingAddress2Fld = By.xpath("//input[@id='billing_address_2']");
    private final By billingCityFld = By.xpath("//input[@id='billing_city']");
    private final By billingPostCodeFld = By.xpath("//input[@id='billing_postcode']");
    private final By billingPhoneFld = By.xpath("//input[@id='billing_phone']");
    private final By billingEmailFld = By.xpath("//input[@id='billing_email']");
    private final By placeOrderBtn = By.xpath("//button[@id='place_order']");
    private final By successText = By.xpath("//p[text()='Thank you. Your order has been received.']");
    private final By clickHereToLogin = By.xpath("//a[contains(text(),'Click here to login')]");
    private final By userNameField = By.xpath("//input[@id='username']");
    private final By userPasswordField = By.xpath("//input[@id='password']");
    private final By loginBtn = By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");
    private final By countryDropDown = By.xpath("//select[@id='billing_country']");
    private final By stateDropDown = By.xpath("//select[@id='billing_state']");
    private final By alternateCountryDropdown = By.xpath("//span[@id='select2-billing_country-container']");
    private final By alternateStateDropdown = By.xpath("//span[@id='select2-billing_state-container']");
    private final By directBankTransferRadioBtn = By.id("payment_method_bacs");
    private final By productName = By.xpath("//td[@class='product-name']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public CheckoutPage load(){
        load("/checkout");
        return this;
    }
    public CheckoutPage enterFirstName (String firstName) {
    WebElement e = waitElementToBeClickable(firstNameFld);
    e.clear();
    e.sendKeys(firstName);
    return  this;
    }
    public CheckoutPage enterLastName (String lastName) {
        //add explicit wait to this method
//    driver.findElement(lastNameFld).sendKeys(lastName);
//    return  this;
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFld)).sendKeys(lastName);
        return  this;
    }
    public CheckoutPage selectCountry (String countryName){
//        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(countryDropDown)));
//        select.selectByVisibleText(countryName);
        wait.until(ExpectedConditions.elementToBeClickable(alternateCountryDropdown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + countryName + "']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
    }
    public CheckoutPage enterCompanyName (String companyName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingCompanyNameFld)).sendKeys(companyName);
        return  this;
    }
    public CheckoutPage enterAddress1 (String address1) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddress1Fld)).sendKeys(address1);
        return  this;
    }
    public CheckoutPage enterAddress2 (String address2) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddress2Fld)).sendKeys(address2);
        return  this;
    }
    public CheckoutPage enterCity (String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityFld)).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityFld)).sendKeys(city);
        return  this;
//        wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityFld)).sendKeys(city);
//        return  this;
    }
    public CheckoutPage selectState (String stateName){
//        Select select = new Select(driver.findElement(stateDropDown));
//        select.selectByVisibleText(stateName);
        wait.until(ExpectedConditions.elementToBeClickable(alternateStateDropdown)).click();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + stateName + "']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
    }
    public CheckoutPage enterPostCode (String postCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingPostCodeFld)).sendKeys(postCode);
        return  this;
    }
    public CheckoutPage enterPhone (String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingPhoneFld)).sendKeys(phone);
        return  this;
    }
    public CheckoutPage clearEmail () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld)).clear();
        return  this;
    }
    public CheckoutPage enterEmail (String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld)).sendKeys(email);
        return  this;
    }
    public CheckoutPage setBillingAddress (BillingAddress billingAddress){
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterCompanyName(billingAddress.getCompanyName()).
                selectCountry(billingAddress.getCountry()).
                enterAddress1(billingAddress.getAddressLineOne()).
                enterCity(billingAddress.getCity()).
                selectState(billingAddress.getState()).
                enterPostCode(billingAddress.getPostCode()).
                enterPhone(billingAddress.getPhone()).
                clearEmail().
                enterEmail(billingAddress.getEmail());
    }
    public CheckoutPage clickPlaceOrderBtn() {
        //do not use explicit wait inside this method
        waitForOverlaysToDisappear(overlay);
        driver.findElement(placeOrderBtn).click();
        return  this;
    }
    public String getNotice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successText)).getText();
    }
    //login
    public CheckoutPage clickHereToLogin () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickHereToLogin)).click();
        return this;
    }
    public CheckoutPage enterUserName (String userName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField)).sendKeys(userName);
        return this;
    }
    public CheckoutPage enterUserPassword (String userPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userPasswordField)).sendKeys(userPassword);
        return this;
    }
    public CheckoutPage clickLoginBtn () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickHereToLogin)).click();
        return this;
    }
    public CheckoutPage waitForLoginBtnToDisappear(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginBtn));
        return this;
    }
    public CheckoutPage login(User user) {
        return enterUserName(user.getUsername()).
                enterUserPassword(user.getPassword()).
                clickLoginBtn().
                waitForLoginBtnToDisappear();
    }
    public CheckoutPage selectDirectBankTransfer() {
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
        if (!e.isSelected()){
            e.click();
        }
        return this;
    }
    public String getProductName() throws Exception {
        int i = 5;
        while(i > 0){
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
            }catch (StaleElementReferenceException e){
                System.out.println("NOT FOUND. TRYING AGAIN" + e);
            }
            Thread.sleep(5000);
            i--;
        }
        throw new Exception("Element not found");
    }
}

