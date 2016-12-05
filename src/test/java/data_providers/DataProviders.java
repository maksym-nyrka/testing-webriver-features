package data_providers;

import org.testng.annotations.DataProvider;

/**
 * Created on 21/11/2016 at 17:02.
 */
public class DataProviders {
    @DataProvider(name = "user_info")
    public static Object[][] createData()
    {
        return new Object[][]
                {
                        {"Valentin","Strastniy"}
                };
    }
    @DataProvider(name = "link_title")
    public static Object[][] createData2()
    {
        return new Object[][]
                {
                        {"Appium A Cross-browser Mobile Automation Tool"}
                };
    }
    @DataProvider(name = "popup_key")
    public static Object[][] createData3()
    {
        return new Object[][]
                {
                        {"Yes"}
                };
    }
    @DataProvider(name = "droppable-text")
    public static Object[][] createData4()
    {
        return new Object[][]
                {
                        {"Dropped!"}
                };
    }
    @DataProvider(name = "canvas-sequence")
    public static Object[][] createData5()
    {
        return new Object[][]
                {
                        {new int[]{250,0,-250,125,125,-250,0,250},new int[]{-150,150,-150,-75,75,0,150,0}}
                };
    }
}
