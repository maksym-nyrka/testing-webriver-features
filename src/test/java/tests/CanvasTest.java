package tests;

import actions.ToolsQAActions;
import data_providers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CanvasDemoPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created on 05/12/2016 at 11:07.
 */
public class CanvasTest extends BaseTest {

    CanvasDemoPage objCanvasDemoPage;

    private final String demoPageLink = "http://www.theautomatedtester.co.uk/demo1.html";

    @Test(dataProvider = "canvas-sequence", dataProviderClass = DataProviders.class)
    public void testCanvas(int[] xSequence, int[] ySequence)
    {
        openDemoPage();
        paintBySequence(xSequence, ySequence);
        savePicture();
        Assert.assertTrue(true);
    }
    @Step("Open Canvas Demo Page")
    private void openDemoPage()
    {
        driver.get(demoPageLink);
        objCanvasDemoPage = new CanvasDemoPage(driver);
    }
    @Step("Paint by sequence")
    private void paintBySequence(int[] xSequence, int[] ySequence)
    {
        ToolsQAActions.paintBySequence(xSequence,ySequence,objCanvasDemoPage);
    }
    @Step("Save picture to project folder")
    private void savePicture()
    {
        ToolsQAActions.savePicture(objCanvasDemoPage);
    }
}
