package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {

    WebDriver driver;
    By proceedToCheckout = By.name("go_to_checkout");
    By proceedToNextStep = By.name("go_to_next_step");
    By usernameInput = By.id("client_email");
    By passwordInput = By.id("password");

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    public void waitProceedToCheckoutToBePresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(proceedToCheckout));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(proceedToCheckout));
    }

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckout).click();
    }


    public void clickProceedToNextStep() {
        driver.findElement(proceedToNextStep).click();
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
}
