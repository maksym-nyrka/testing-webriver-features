package tests;

import actions.ToolsQAActions;
import data_providers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.IFramePracticePage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created on 30/11/2016 at 15:32.
 */

@Listeners({utility.UtilityListener.class})
public class IFrameTest extends BaseTest{

    IFramePracticePage objIFramePracticePage;

    private final String iframePracticePage = "http://toolsqa.wpengine.com/iframe-practice-page/";


    @Test(dataProvider = "user_info", dataProviderClass = DataProviders.class)
    public void testIFrame(String tFirstname, String tLastname)
    {
        openIFramePracticePage();
        switchToFirstIFrame();
        setUserName(tFirstname,tLastname);
        assertFirstname(tFirstname);
        clickSubmit();
        assertFirstname("");
    }

    @Step("Open IFrame Practice Page")
    private void openIFramePracticePage()
    {
        driver.get(iframePracticePage);
        objIFramePracticePage = new IFramePracticePage(driver);
    }
    @Step("Switch to first IFrame")
    private void switchToFirstIFrame()
    {
        ToolsQAActions.switchToFirstIFrame(objIFramePracticePage);
    }
    @Step("Send keys into firstname and lastname inputs")
    private void setUserName(String tFirstname, String tLastname)
    {
        ToolsQAActions.setUserName(tFirstname,tLastname,objIFramePracticePage);
    }
    @Step("Click submit button")
    private void clickSubmit()
    {
        ToolsQAActions.clickSubmit(objIFramePracticePage);
    }
    @Step("Assert text in firstname input")
    private void assertFirstname(String expected)
    {
        Assert.assertEquals(objIFramePracticePage.getFirstname(),expected);
    }
}
