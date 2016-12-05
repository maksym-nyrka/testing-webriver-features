package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created on 01/12/2016 at 10:22.
 */
public class JSAlertsTutorialPage extends BasePage {

    @FindBy(xpath = "//button[@onclick='pushAlert()']")
    WebElement simpleAlertButton;

    @FindBy(xpath = "//button[@onclick='promptConfirm()']")
    WebElement promtPopupButton;

    @FindBy(xpath = "//button[@onclick='pushConfirm()']")
    WebElement confirmPopupButton;

    public JSAlertsTutorialPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void clickPromtPopupButton()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", promtPopupButton);
    }
    public void sendKeysToPopupAlert(String keys)
    {
        Alert promptAlert  = driver.switchTo().alert();
        promptAlert.sendKeys(keys);
        promptAlert.accept();
    }

    public WebElement getConfirmPopupButton() {
        return confirmPopupButton;
    }
    public void clickSimpleAlertButton()
    {
        click(simpleAlertButton);
    }
    public void clickConfirmSimpleAlert()
    {
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }
    public void clickConfirmAlertButton()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", confirmPopupButton);
    }
    public void clickCancelComfirmAlert()
    {
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();
    }
}
