package tests;



import data_providers.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AppiumTutorialPage;
import pages.MainPage;
import pages.WindowsPracticePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created on 30/11/2016 at 16:48.
 */

@Listeners({utility.UtilityListener.class})
public class WindowsTest extends BaseTest {

    WindowsPracticePage objWindowsPracticePage;
    MainPage objMainPage;
    AppiumTutorialPage objAppiumTutorialPage;

    private final String windowsPracticeLink = "http://toolsqa.com/automation-practice-switch-windows/";

    @Test(dataProvider = "link_title", dataProviderClass = DataProviders.class)
    public void testWindows(String linkTitle)
    {
        openWindowsPracticeLink();
        String startWindow = getWindowHandle();
        clickOpenNewBrowserTab();
        switchToNewWindow(startWindow);
        clickAppiumTutorial();
        assertIntroLink(linkTitle);

        String window = getWindowHandle();
        switchToNewWindow(window);

        clickOpenNewBrowserWindow();
        switchToNewWindow(startWindow);
        clickAppiumTutorial();
        assertIntroLink(linkTitle);

        switchToWindow(startWindow);
        clickOpenNewMessageWindow();
        closeCurrentWindow();
        assertWindowHandlesCount();
       }
    @Step("Open Windows Practice Page")
    private void openWindowsPracticeLink()
    {
        driver.get(windowsPracticeLink);
        objWindowsPracticePage = new WindowsPracticePage(driver);
    }
    @Step("Click New Browser window")
    private void clickOpenNewBrowserWindow()
    {
        objWindowsPracticePage.clickNewBrowserWindow();
        objWindowsPracticePage = new WindowsPracticePage(driver);
        driver.manage().window().maximize();
    }
    @Step("Click New Message window")
    private void clickOpenNewMessageWindow()
    {
        objWindowsPracticePage.clickNewMessageWindow();
    }
    @Step("Click New Browser tab")
    private void clickOpenNewBrowserTab()
    {
        objWindowsPracticePage.clickNewBrowserTab();
    }
    private String getWindowHandle()
    {
        return driver.getWindowHandle();
    }
    @Step("Switch to New Tab Window")
    private void switchToNewWindow(String currWindow)
    {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(currWindow))
                driver.switchTo().window(handle);
        }
        objMainPage = new MainPage(driver);
    }
    @Step("Click Appium tutorials link")
    private void clickAppiumTutorial()
    {
        objMainPage.clickTutorialMenu();
        objMainPage.clickTutorialMenuAppiumLink();
        objAppiumTutorialPage = new AppiumTutorialPage(driver);
    }
    @Step("Assert Introduction link")
    private void assertIntroLink(String expectedTitle )
    {
        Assert.assertEquals(objAppiumTutorialPage.getIntroductionLinkTitle(),expectedTitle);
    }
    @Step("Close current Window")
    private void closeCurrentWindow()
    {
        driver.close();
    }
    @Step("Switch to window")
    private void switchToWindow(String windowHandle)
    {
        objWindowsPracticePage.switchToWindow(windowHandle);
    }
    @Step("Assert ")
    private void assertWindowHandlesCount()
    {
        Set handles = driver.getWindowHandles();
        Assert.assertEquals(handles.size(),3);
    }
}
