package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import pages.*;

@FixMethodOrder(MethodSorters.JVM)
public class CheckSearchResults {
    WebDriver browser;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/home/alesanu/Projects/Work/interview/UITesting/libs/chromedriver");
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
    public void search_for_item_should_work() {
        SearchForm searchForm = new SearchForm(browser);
        SearchPage searchPage = new SearchPage(browser);
        String searchItemName;

        searchForm.waitForSearchInput();
        searchForm.setSearchTerm("mobile ");
        searchForm.waitForSearchInputAutocompleteItem("3");
        searchItemName = searchForm.getAutocompleteItemText("3");
        searchForm.clickOnAutocompleteItem("3");
        searchForm.checkSearchInputField(searchItemName);
        searchForm.clickOnSearch();

        searchPage.waitForSearchTerm();
        searchPage.checkSearchTerm(searchItemName);
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
