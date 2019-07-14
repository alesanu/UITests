package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartModal {

    WebDriver driver;
    By addToCartModal = By.className("vw-modalAddToShopCart");
    By addToCartButton = By.cssSelector(".vw-modalAddToShopCart > div > div.buttons > a.button.-add.-red.-close");


    public AddToCartModal(WebDriver driver) {
        this.driver = driver;
    }

    public void waitAddToCartModalToBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartModal));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartModal));
    }

    public void clickOnAddToCart() {
        driver.findElement(addToCartButton).click();
    }
}
