package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AlertPage {

    private WebDriver driver;

    @FindBy(css = ".internal_navi [href='#example-1-tab-2']")
    private WebElement inputAlertLink;

    @FindBy(css = "iframe[src='alert/input-alert.html']")
    private WebElement inputAlertIframe;

    @FindBy(xpath = "//html //body //p[@id='demo']/preceding-sibling::button")
    private WebElement inputAlertIframeButton;

    @FindBy(css = "p#demo")
    private WebElement IframeMessage;


    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnInputAlert() {
        inputAlertLink.click();
    }

    public void clickOnButtonInsideIframeAndSubmitValueInPopup(String nameValue)  {
        driver.switchTo().frame(inputAlertIframe);
        inputAlertIframeButton.click();

        Alert alertPopup = driver.switchTo().alert();
        alertPopup.sendKeys(nameValue);
        alertPopup.accept();
    }

    public void verifyValueIsDisplayedInInputAlertIFrame(String value) {
        Assert.assertEquals(IframeMessage.getText(), value);
    }

    private void switchOutOfIFrame() {
        driver.switchTo().defaultContent();
    }
}
