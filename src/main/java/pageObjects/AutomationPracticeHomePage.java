package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class AutomationPracticeHomePage {

    private WebDriver driver;

    @FindBy(css = "[href='alert.php'] figure")
    private WebElement alertBoxButton;

    public AutomationPracticeHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAlertBox() {
        alertBoxButton.click();
    }

    public void switchTabs() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    private void closeAndSwitchToInitialTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

}
