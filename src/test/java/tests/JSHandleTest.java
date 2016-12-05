package tests;

import data_providers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.JSAlertsTutorialPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created on 01/12/2016 at 10:17.
 */

@Listeners({utility.UtilityListener.class})
public class JSHandleTest extends BaseTest {

    JSAlertsTutorialPage objJsAlertsTutorialPage;

    private final String tutorialLink="http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/";

    @Test(dataProvider = "popup_key", dataProviderClass = DataProviders.class)
    public void testJSAlertsHandle(String popupKey)
    {
        openJSAlertsTutorialPage();
        clickPopupAlert();
        sendKeysToPopupAlert(popupKey);
        assertConfirmButtonIsDisplayed();

        clickSimpleAlert();
        confirmSimpleAlert();
        assertConfirmButtonIsDisplayed();

        clickConfirmAlert();
        clickCancelConfirmAlert();
        assertConfirmButtonIsDisplayed();
    }

    @Step("Open JS Alerts Tutorial Page")
    private void openJSAlertsTutorialPage()
    {
        driver.get(tutorialLink);
        objJsAlertsTutorialPage = new JSAlertsTutorialPage(driver);
    }
    @Step("click Popup Alert")
    private void clickPopupAlert()
    {
        objJsAlertsTutorialPage.clickPromtPopupButton();
    }
    @Step("Send Key to popup alert")
    private void sendKeysToPopupAlert(String keys)
    {
        objJsAlertsTutorialPage.sendKeysToPopupAlert(keys);
    }
    @Step("Assert Confirm Alert button is visible")
    private void assertConfirmButtonIsDisplayed()
    {
        Assert.assertTrue(objJsAlertsTutorialPage.getConfirmPopupButton().isDisplayed());
    }
    @Step("click Simple Alert Button")
    private void clickSimpleAlert()
    {
        objJsAlertsTutorialPage.clickSimpleAlertButton();
    }
    @Step("Confirm Simple Alert")
    private void confirmSimpleAlert()
    {
        objJsAlertsTutorialPage.clickConfirmSimpleAlert();
    }
    @Step("click Confirm Alert")
    private void clickConfirmAlert()
    {
        objJsAlertsTutorialPage.clickSimpleAlertButton();
    }
    @Step("click \"Cancel\" Confirm Alert")
    private void clickCancelConfirmAlert()
    {
        objJsAlertsTutorialPage.clickConfirmSimpleAlert();
    }
}
