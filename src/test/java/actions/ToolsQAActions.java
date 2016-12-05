package actions;

import pages.IFramePracticePage;

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

    //Windows Practice

}
