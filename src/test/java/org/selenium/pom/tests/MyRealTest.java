package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyRealTest extends BaseTest {

//testng annt    @Test
//    @org.junit.Test
    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws IOException  {
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json",BillingAddress.class);
        Product product = new Product(1215);
//testng antn
         StorePage storePage = new HomePage(getDriver()).
//        StorePage storePage = new HomePage(driver).
                load().
                 getMyHeader().navigateToStoreUsingMenu().
                search(searchFor);
        Assert.assertEquals(storePage.getTitle(),"Search results: “" + searchFor + "”");
//        Assertions.assertEquals("Search results: “" + searchFor + "”", storePage.getTitle());

        storePage.getProductThumbnail().clickAddToCardBtn(product.getName());
        CartPage cartPage = storePage.getProductThumbnail().clickViewCart();
 //       cartPage.isLoaded();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
//        Assertions.assertEquals(product.getName(), cartPage.getProductName());

        CheckoutPage checkoutPage = cartPage.
            checkout().
            setBillingAddress(billingAddress).
            selectDirectBankTransfer().
            clickPlaceOrderBtn();
        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
//        Assertions.assertEquals("Thank you. Your order has been received.",checkoutPage.getNotice());
    }

    @Test
//    @Test
//    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws IOException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json",BillingAddress.class);
        Product product = new Product(1215);
        User user = new User(ConfigLoader.getInstance().getUsername(),
                ConfigLoader.getInstance().getPassword());

//testng antn
 StorePage storePage = new HomePage(getDriver()).
//        StorePage storePage = new HomePage(driver).
            load().getMyHeader().
            navigateToStoreUsingMenu().
            search(searchFor);
        Assert.assertEquals(storePage.getTitle(),"Search results: “" + searchFor + "”");
//        Assertions.assertEquals(storePage.getTitle(),"Search results: “" + searchFor + "”");
        storePage.getProductThumbnail().clickAddToCardBtn(product.getName());

        CartPage cartPage = storePage.getProductThumbnail().clickViewCart();
        cartPage.isLoaded();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
//        Assertions.assertEquals(cartPage.getProductName(), product.getName());

        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.clickHereToLogin();

        checkoutPage.
                login(user).
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                clickPlaceOrderBtn();
        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
//        Assertions.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }
}
