package tests;

import actions.ToolsQAActions;
import data_providers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragNDropDemoPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created on 05/12/2016 at 10:27.
 */
public class DragNDropTest extends BaseTest {

    DragNDropDemoPage objDragNDropDemoPage;

    private final String demoPageLink = "http://jqueryui.com/resources/demos/droppable/default.html";

    @Test(dataProvider = "droppable-text", dataProviderClass = DataProviders.class)
    public void testDragNDrop(String droppableText)
    {
        openDemoPage();
        dragToCoord(10,20);
        assertElemTextNotEquals(droppableText);
        dragToCoord(2000,500);
        assertElemTextNotEquals(droppableText);
        dragToDroppable();
        assertElemTextEquals(droppableText);
    }
    @Step("Go to Drag'N'Drop Demo Page")
    private void openDemoPage()
    {
        driver.get(demoPageLink);
        objDragNDropDemoPage = new DragNDropDemoPage(driver);
    }
    @Step("Drag elem to droppable elem")
    private void dragToDroppable()
    {
        ToolsQAActions.dragToDroppableElem(objDragNDropDemoPage);
    }
    @Step("Assert Droppable Elem text equals expected")
    private void assertElemTextEquals(String expected)
    {
        Assert.assertEquals(objDragNDropDemoPage.getDroppableElemText(),expected);
    }
    @Step("Assert Droppable Elem text not equals expected")
    private void assertElemTextNotEquals(String expected)
    {
        Assert.assertNotEquals(objDragNDropDemoPage.getDroppableElemText(),expected);
    }
    @Step("Drag to coordinats (x,y)")
    private void dragToCoord(int x, int y)
    {
        ToolsQAActions.dragToCoordinats(x,y,objDragNDropDemoPage);
    }
}
