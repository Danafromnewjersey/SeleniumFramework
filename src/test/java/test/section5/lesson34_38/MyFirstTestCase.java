package test.section5.lesson34_38;



public class MyFirstTestCase {
//
//    @Test
//    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://askomdch.com");
//        driver.manage().window().maximize();
//        driver.findElement(By.xpath("(//a[@href='https://askomdch.com/store/'])[1]")).click();
//        driver.findElement(By.cssSelector("#woocommerce-product-search-field-0")).sendKeys("Blue");
//        driver.findElement(By.xpath("//input[@type='search']//following-sibling::button")).click();
//        Assert.assertEquals(
//                driver.findElement(By.xpath("//h1[@class='woocommerce-products-header__title page-title']")).getText(),
//                "Search results: “Blue”"
//        );
//        driver.findElement(By.xpath("//h1[@class='woocommerce-products-header__title page-title']")).click();
//        //synchronization to add timeout to wait element popup
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//a[@href='?add-to-cart=1215']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//a[@href='?add-to-cart=1215']//following-sibling::a")).click();
//        Assert.assertEquals(
//                driver.findElement(By.xpath("//td[@class='product-name']//child::a")).getText(),
//                "Blue Shoes"
//        );
//        driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
//        driver.findElement(By.xpath("//input[@id='billing_first_name']")).sendKeys("Dana");
//        driver.findElement(By.xpath("//input[@id='billing_last_name']")).sendKeys("Anglaeva");
//        driver.findElement(By.xpath("//input[@id='billing_company']")).sendKeys("My Company");
//        driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("555 Main Street");
//        driver.findElement(By.xpath("//input[@id='billing_address_2']")).sendKeys("Apt5");
//        driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Howell");
//        driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("77888");
//        driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("9876543210");
//        driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("77888@gmail.com");
//        driver.findElement(By.xpath("//button[@id='place_order']")).click();
//        Thread.sleep(5000);
//        Assert.assertEquals(driver.findElement
//                (By.xpath("//p[text() ='Thank you. Your order has been received.']")).getText(),
//                "Thank you. Your order has been received."
//        );
//        driver.quit();
//    }
//    @Test
//    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://askomdch.com");
//        driver.manage().window().maximize();
//        driver.findElement(By.xpath("(//a[@href='https://askomdch.com/store/'])[1]")).click();
//        driver.findElement(By.cssSelector("#woocommerce-product-search-field-0")).sendKeys("Blue");
//        driver.findElement(By.xpath("//input[@type='search']//following-sibling::button")).click();
//        Assert.assertEquals(
//                driver.findElement(By.xpath("//h1[@class='woocommerce-products-header__title page-title']")).getText(),
//                "Search results: “Blue”"
//        );
//        driver.findElement(By.xpath("//h1[@class='woocommerce-products-header__title page-title']")).click();
//        //synchronization to add timeout to wait element popup
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//a[@href='?add-to-cart=1215']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//a[@href='?add-to-cart=1215']//following-sibling::a")).click();
//        Assert.assertEquals(
//                driver.findElement(By.xpath("//td[@class='product-name']//child::a")).getText(),
//                "Blue Shoes"
//        );
//        driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
//        //login to account
//        driver.findElement(By.xpath("//a[contains(text(),'Click here to login')]")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Dana");
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dana@gmail.com");
//        driver.findElement(By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']")).click();
//
//        driver.findElement(By.xpath("//input[@id='billing_first_name']")).sendKeys("Dana");
//        driver.findElement(By.xpath("//input[@id='billing_last_name']")).sendKeys("Anglaeva");
//        driver.findElement(By.xpath("//input[@id='billing_company']")).sendKeys("My Company");
//        driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("555 Main Street");
//        driver.findElement(By.xpath("//input[@id='billing_address_2']")).sendKeys("Apt5");
//        driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Howell");
//        driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("77888");
//        driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("9876543210");
//        driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("77888@gmail.com");
//        driver.findElement(By.xpath("//button[@id='place_order']")).click();
//        Thread.sleep(5000);
//        Assert.assertEquals(driver.findElement
//                (By.xpath("//p[text() ='Thank you. Your order has been received.']")).getText(),
//                "Thank you. Your order has been received."
//        );
//        driver.quit();
//    }
}
