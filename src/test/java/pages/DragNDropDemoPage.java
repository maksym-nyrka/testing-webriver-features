package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created on 05/12/2016 at 10:30.
 */
public class DragNDropDemoPage extends BasePage {

    @FindBy(xpath = "//div[@id='draggable']")
    WebElement draggableElement;

    @FindBy(xpath = "//div[@id='droppable']")
    WebElement droppableElement;

    public DragNDropDemoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getDraggableElement() {
        return draggableElement;
    }

    public WebElement getDroppableElement() {
        return droppableElement;
    }

    public void dragToDroppableElem()
    {
        Actions actions = new Actions(driver);
        Action dragNdrop = actions.dragAndDrop(draggableElement,droppableElement).build();
        dragNdrop.perform();
    }
    public String getDroppableElemText()
    {
        return droppableElement.findElement(By.xpath(".//p")).getText();
    }
    public void dragToCoordinats(int x, int y)
    {
        Actions actions = new Actions(driver);
        Action drag = actions.dragAndDropBy(draggableElement,x,y).build();
        drag.perform();
    }
}
