package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;
    By productMain = By.className("vw-productMain");
    By addToCartButton = By.className("add-cart");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitProductToBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(productMain));
    }

    public void clickOnAddToCart() {
        driver.findElement(addToCartButton).click();
    }
}
