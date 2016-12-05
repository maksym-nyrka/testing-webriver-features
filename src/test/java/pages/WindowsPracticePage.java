package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created on 30/11/2016 at 16:47.
 */
public class WindowsPracticePage extends BasePage {

    @FindBy(xpath = "//button[@onclick='newBrwWin()']")
    WebElement newBrowserWindow;

    @FindBy(xpath = "//button[@onclick='newMsgWin()']")
    WebElement newMessageWindow;

    @FindBy(xpath = "//button[@onclick='newBrwTab()']")
    WebElement newBrowserTab;

    public WindowsPracticePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickNewBrowserWindow()
    {
        click(newBrowserWindow);
    }
    public void clickNewMessageWindow()
    {
        click(newMessageWindow);
    }
    public void clickNewBrowserTab()
    {
        click(newBrowserTab);
    }
}
