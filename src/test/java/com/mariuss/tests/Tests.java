package com.mariuss.tests;

import pageObjects.AlertPage;
import pageObjects.AutomationPracticeHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Constants;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Tests {

    public static WebDriver driver;

    AutomationPracticeHomePage automationPracticeHomePage;
    AlertPage alertPage;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(Constants.url);
    }

    @AfterMethod
    public void afterMethodMethod() {
        driver.quit();
    }

    @Test
    public void way2automationTest()  {
        automationPracticeHomePage = new AutomationPracticeHomePage(driver);
        automationPracticeHomePage.clickOnAlertBox();
        automationPracticeHomePage.switchTabs();

        alertPage = new AlertPage(driver);
        alertPage.clickOnInputAlert();
        alertPage.clickOnButtonInsideIframeAndSubmitValueInPopup("Sturza Marius");
        alertPage.verifyValueIsDisplayedInInputAlertIFrame("Hello Sturza Marius! How are you today?");
    }

}
