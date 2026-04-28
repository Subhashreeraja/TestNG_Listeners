package com.tests;

import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@Listeners(demolistener.class)
public class demotest {

    public WebDriver driver;
    public WebDriverWait wait;
    private static final Logger log = LogManager.getLogger(demotest.class);

    @BeforeMethod
    public void beforeTest() {
        log.info("Launching browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://tutorialsninja.com/demo/index.php");
    }

    @Test
    public void loginTest() {
        log.info("Clicking My Account");
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[normalize-space()='My Account']"))).click();

        log.info("Clicking Login");
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[normalize-space()='Login']"))).click();

        log.info("Entering credentials");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("input-email"))).sendKeys("subhashreerajait@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("input-password"))).sendKeys("Subha123");

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@value='Login']"))).click();

        wait.until(ExpectedConditions.titleContains("Account"));
        String title = driver.getTitle();
        log.info("Page title is: " + title);

        Assert.assertTrue(title.contains("Account"));
    }

    @AfterMethod
    public void afterTest() {
        log.info("Closing browser");
        if (driver != null) {
            driver.quit();
        }
    }
}