
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookieModal {
    WebDriver driver;
    By cookieModal = By.id("__tealiumGDPRecModal");
    By cookieModalSubmit = By.id("consent_prompt_submit");


    public CookieModal(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookie() {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(cookieModal));
        wait.until(ExpectedConditions.elementToBeClickable(cookieModalSubmit));
        driver.findElement(cookieModalSubmit).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieModal));

    }
}
