package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    WebDriver driver;
    By searchTerm = By.className("term");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSearchTerm() {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchTerm));
    }

    public void checkSearchTerm(String word) {
        driver.findElement(searchTerm).getText().equals(word);
    }

}
