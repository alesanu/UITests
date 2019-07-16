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
}
