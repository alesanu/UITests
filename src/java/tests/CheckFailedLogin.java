package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CookieModal;
import pages.LoginPage;

public class CheckFailedLogin {
    WebDriver browser;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        browser = new ChromeDriver(options);
        browser.get("https://www.rakuten.de/");

        CookieModal cookieModal = new CookieModal(browser);
        cookieModal.acceptCookie();

        WebDriverWait wait = new WebDriverWait(browser, 10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".icon-button.-login")));
        browser.findElement(By.cssSelector(".icon-button.-login > a")).click();
    }

    @After
    public void after() {
        browser.close();
    }

    @Test
    public void login_with_valid_email_without_password_should_not_pass() {
        LoginPage loginPage = new LoginPage(browser);

        loginPage.addUsername("alexlesanu95@gmail.com");
        loginPage.clickOnLoginButton();
        loginPage.waitForErrorMessage();
        loginPage.checkErrorMessage("Diese E-Mail-Passwort-Kombination ist uns nicht bekannt. Bitte korrigieren Sie Ihre Eingabe.");
    }

    @Test
    public void login_with_invalid_email_without_password_should_not_pass() {
        LoginPage loginPage = new LoginPage(browser);

        loginPage.addUsername("alexlesanu95");
        loginPage.clickOnLoginButton();
        loginPage.waitForErrorMessage();
        loginPage.checkErrorMessage("Bitte überprüfen Sie Ihre Eingaben.");
    }

    @Test
    public void login_without_email_valid_password_should_not_pass() {
        LoginPage loginPage = new LoginPage(browser);

        loginPage.addPassword("Alex123456");
        loginPage.clickOnLoginButton();
        loginPage.waitForErrorMessage();
        loginPage.checkErrorMessage("Diese E-Mail-Passwort-Kombination ist uns nicht bekannt. Bitte korrigieren Sie Ihre Eingabe.");
    }
}
