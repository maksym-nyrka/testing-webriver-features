package actions;

import org.openqa.selenium.interactions.Actions;
import pages.CanvasDemoPage;
import pages.DragNDropDemoPage;
import pages.IFramePracticePage;
import utility.UtilityListener;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created on 30/11/2016 at 15:39.
 */
public class ToolsQAActions {

    //IFrame Practice
    public static void switchToFirstIFrame(IFramePracticePage iFramePracticePage)
    {
         iFramePracticePage.switchToIFrame(iFramePracticePage.getIFrame1());
    }
    public static void setUserName(String firstname, String lastname, IFramePracticePage iFramePracticePage)
    {
        iFramePracticePage.setFirstname(firstname);
        iFramePracticePage.setLastname(lastname);
    }
    public static void clickSubmit(IFramePracticePage iFramePracticePage)
    {
        iFramePracticePage.clickSubmitButton();
    }

    //Drag'n'Drop
    public static void dragToDroppableElem(DragNDropDemoPage dragNDropDemoPage)
    {
        dragNDropDemoPage.dragToDroppableElem();
    }
    public static void dragToCoordinats(int x,int y, DragNDropDemoPage dragNDropDemoPage)
    {
        dragNDropDemoPage.dragToCoordinats(x, y);
    }

    //Canvas
    public static void paintBySequence(int[] xSequence, int[] ySequence,CanvasDemoPage canvasDemoPage)
    {
        canvasDemoPage.paintSequence(xSequence, ySequence);
    }
    public static void savePicture(CanvasDemoPage canvasDemoPage){
        File file = new File("");
        System.out.println(file.getAbsoluteFile());
        canvasDemoPage.clickSavePic();
    }
}
