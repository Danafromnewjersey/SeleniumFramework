package org.selenium.pom.tests;

import io.qameta.allure.*;
import org.selenium.pom.api.actions.CartApi;
import org.selenium.pom.api.actions.SignUpApi;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Frontend")
@Feature("Login Page")

public class LoginTest extends BaseTest {
    @Story("Login Page")
    @Link(name = "Website", url = "https://askomdch.com/")
    @Issue("JiraIssue-111")
    @TmsLink("TestSuite-123")
    @Description("this is a description for Login Page")
    @Test (description = "should be able to log in to account")
    public void loginDuringCheckout() throws Exception {
        String username = "testdana" + new FakerUtils().generateRandomName();
        User user = new User().
                setUsername(username).
                setPassword("newpswrd123").
                setEmail(username + "@gmail.com");

        SignUpApi signUpApi = new SignUpApi();
        signUpApi. register(user);
        CartApi cartApi = new CartApi();
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver())
                .load();
        Thread.sleep(5000);
        injectCookiesToBrowser(cartApi.getCookies());
        checkoutPage.load();
        Thread.sleep(5000);
        checkoutPage.
                clickHereToLogin().
                login(user);
        Thread.sleep(5000);
        Assert.assertTrue(checkoutPage.getProductName().contains(product.getName()));
    }
}
