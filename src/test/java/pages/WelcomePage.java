package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import utils.SwipeActions;

public class WelcomePage {
    private AndroidDriver driver;

    private By header = By.id("com.ceiia.ayr:id/textView");
    private By skipButton = By.id("com.ceiia.ayr:id/button");

    public WelcomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public void swipeToNextScreen() {
        SwipeActions.swipeLeft(driver);
    }

    public void clickSkip() {
        driver.findElement(skipButton).click();
    }
}
