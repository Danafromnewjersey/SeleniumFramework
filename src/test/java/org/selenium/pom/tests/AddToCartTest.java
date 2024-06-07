package org.selenium.pom.tests;

import io.qameta.allure.*;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataproviders.MyDataProvider;
import org.selenium.pom.objects.Product;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Frontend")
@Feature("Cart Page")

public class AddToCartTest extends BaseTest {

    @Story("Add a product to Cart")
    @Link(name = "Website", url = "https://askomdch.com/")
    @Issue("JiraIssue-123")
    @TmsLink("TestSuite-456")
    @Description("this is a description")

    @Test (description = "should be able to add product to cart")
    public void addToCartFromStorePage() throws IOException, InterruptedException {
        Product product = new Product(1215);
        CartPage cartPage = new StorePage(getDriver()).load().
                getProductThumbnail().clickAddToCardBtn(product.getName()).
                clickViewCart();
        cartPage.isLoaded();
        Thread.sleep(5000);
        Assert.assertEquals(cartPage.getProductName(), product.getName());
    }

    @Story("Add a product to Cart using DataProvider")
    @Test(dataProvider = "getFeaturedProducts", dataProviderClass = MyDataProvider.class)
    public void addToCartFeaturedProducts(Product product){
        CartPage cartPage = new HomePage(getDriver()).load().
                getProductThumbnail().clickAddToCardBtn(product.getName()).
                clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
    }
}
