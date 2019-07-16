package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class CheckShoppingFlow {
    WebDriver browser;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");
        browser = new ChromeDriver();
        browser.get("https://www.rakuten.de/");

        CookieModal cookieModal = new CookieModal(browser);
        cookieModal.acceptCookie();
    }

    @After
    public void after() {
        browser.close();
    }

    @Test
    public void check_select_payment_methods() {
        ProductItemsList productItemsList = new ProductItemsList(browser);
        ProductPage productPage = new ProductPage(browser);
        AddToCartModal addToCartModal = new AddToCartModal(browser);
        ShoppingCart shoppingCart = new ShoppingCart(browser);

        productItemsList.clickOnProduct(2);
        productPage.waitProductToBeDisplayed();
        productPage.clickOnAddToCart();
        addToCartModal.waitAddToCartModalToBeDisplayed();
        addToCartModal.clickOnAddToCart();
        browser.findElement(By.cssSelector(".icon-button.-cart > div.icon > svg")).click();
        shoppingCart.waitProceedToCheckoutToBePresent();
        shoppingCart.clickProceedToCheckout();
        shoppingCart.addUsername("alexlesanu95@gmail.com");
        shoppingCart.addPassword("Alex123456");
        shoppingCart.clickProceedToNextStep();
        shoppingCart.clickProceedToNextStep();
    }
}