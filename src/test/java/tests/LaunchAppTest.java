package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WelcomePage;
import pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LaunchAppTest extends BaseTest {

    @Test
    public void verifyWelcomeAndLoginFlow() throws InterruptedException {
        WelcomePage welcome = new WelcomePage(driver);
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.ceiia.ayr:id/textView"), "Value your CO2 savings"));
        
        //Assert.assertEquals(welcome.getHeaderText(), "Value your CO2 savings");
        welcome.swipeToNextScreen();

        Assert.assertEquals(welcome.getHeaderText(), "Add your electrical vehicles");
        welcome.swipeToNextScreen();

        Assert.assertEquals(welcome.getHeaderText(), "Exchange your AYR credits");
        welcome.swipeToNextScreen();

        Assert.assertEquals(welcome.getHeaderText(), "Do you want to know more about AYR?");
        welcome.clickSkip();

        LoginPage login = new LoginPage(driver);
        //Assert.assertEquals(login.getTagline(), "Are you ready to build a carbon zero world?");
        WebElement taglineEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ceiia.ayr:id/splash_title_tv")));
        Assert.assertEquals(taglineEl.getText().replace("\n", " ").replaceAll("\\s+", " ").trim(),"Are you ready to build a carbon zero world?");
        
        login.waitForElementVisible(login.getLoginBtn(), 10);
        //login.selectCountry("Aruba (AW)");
        //login.enterPhoneNumber("55692829");
        //login.enterPassword("$Test123");
        //login.clickLogin();
        
        login.login("Aruba (AW)", "55692829", "$Test123");
        
        Thread.sleep(6000); // just to verify screen 
    }
}
