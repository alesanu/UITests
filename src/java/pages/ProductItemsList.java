package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductItemsList {
    WebDriver driver;
    By searchTerm = By.className("term");

    public ProductItemsList(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProduct(int itemNumber) {
        driver.findElements(By.cssSelector("li.vw-productCard > a")).get(itemNumber).click();
    }
}
