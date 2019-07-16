package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    By usernameInput = By.name("loginEmail");
    By passwordInput = By.name("loginPassword");
    By loginButton = By.id("recaptcha-submit");
    By errorMessage = By.cssSelector(".message-error");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void addUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameInput));
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void addPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void waitForErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
    }

    public void checkErrorMessage(String message) {
        driver.findElement(passwordInput).getText().equals(message);
    }
}