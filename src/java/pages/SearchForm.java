package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchForm {
    WebDriver driver;
    By searchInput = By.id("search-input");
    By searchButton = By.className("button-search");

    public SearchForm(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSearchInput() {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
    }

    public void checkSearchInputField(String word) {
        driver.findElement(searchInput).getCssValue("value").equals(word);
    }

    public void waitForSearchInputAutocompleteItem(String itemNumber) {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#eac-container-search-input > ul > li:nth-child(" + itemNumber + ") > div")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#eac-container-search-input > ul > li:nth-child(" + itemNumber + ") > div")));
    }

    public void clickOnAutocompleteItem(String itemNumber) {
        driver.findElement(By.cssSelector("#eac-container-search-input > ul > li:nth-child(" + itemNumber + ") > div")).click();
    }

    public String getAutocompleteItemText(String itemNumber) {
        return driver.findElement(By.cssSelector("#eac-container-search-input > ul > li:nth-child(" + itemNumber + ") > div")).getText();
    }

    public void setSearchTerm(String word) {
        driver.findElement(searchInput).sendKeys(word);
    }

    public void clickOnSearch() {
        driver.findElement(searchButton).click();
    }
}
