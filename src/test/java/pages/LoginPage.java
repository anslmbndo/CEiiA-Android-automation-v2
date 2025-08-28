package pages;

import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private AndroidDriver driver;

    private By tagline = By.id("com.ceiia.ayr:id/splash_title_tv");
    private By country = By.id("com.ceiia.ayr:id/selected_country_tv");
    private By phoneField = By.id("com.ceiia.ayr:id/login_phone_til");
    private By passwordField = By.id("com.ceiia.ayr:id/login_password_til");
    private By loginBtn = By.id("com.ceiia.ayr:id/login_btn");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getTagline() {
        return driver.findElement(tagline).getText().replace("\n", " ").replaceAll("\\s+", " ").trim();
    }

    public void selectCountry(String countryName) {
        driver.findElement(country).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();
    }

    public void enterPhoneNumber(String phone) {
        WebElement field = driver.findElement(phoneField).findElement(By.className("android.widget.EditText"));
        field.sendKeys(phone);
        driver.hideKeyboard();
    }

    public void enterPassword(String password) {
        WebElement field = driver.findElement(passwordField).findElement(By.className("android.widget.EditText"));
        field.sendKeys(password);
        driver.hideKeyboard();
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
    
    
    public void login(String countryName, String phoneNumber, String password) {
    	waitForElementVisible(tagline,10);
        selectCountry(countryName);
        enterPhoneNumber(phoneNumber);
        enterPassword(password);
        clickLogin();
    }
    
    public void waitForElementVisible(By locator, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public By getLoginBtn() {
        return loginBtn;
    }
    
    public By getPasswordField() {
        return passwordField;
    }
    
    public By getPhoneField() {
        return phoneField;
    }
    
    public By getCountry() {
        return country;
    }
    
    public By getPubicTagline() {
        return tagline;
    }
 
}
