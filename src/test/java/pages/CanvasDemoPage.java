package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 05/12/2016 at 11:09.
 */
public class CanvasDemoPage extends BasePage {

    @FindBy(xpath = "//canvas[@id='tutorial']")
    WebElement canvasElement;

    public CanvasDemoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void paintSequence(int[] xSequence, int[] ySequence)
    {
        Actions actions = new Actions(driver);
        Actions paint = actions.clickAndHold(canvasElement);
        for (int i =0;i<xSequence.length;i++)
        {
            paint.moveByOffset(xSequence[i],ySequence[i]);
        }
        paint.release(canvasElement).perform();
    }
    public void clickSavePic()  {
        Actions actions = new Actions(driver);
        actions.contextClick(canvasElement).build().perform();
        Actions actions2 = new Actions(driver);
        actions2.sendKeys("v").build().perform();
        //actions.sendKeys("v").build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = null;
        try {
            fullImg = ImageIO.read(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Point point = canvasElement.getLocation();
        int eleWidth = canvasElement.getSize().getWidth();
        int eleHeight = canvasElement.getSize().getHeight();
        BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        try {
            ImageIO.write(eleScreenshot, "png", screenshot);
            File screenshotLocation = new File("C:\\Users\\evilplane\\IdeaProjects\\test-webriver-features\\"+new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date())+" screenshot.png");
            FileUtils.copyFile(screenshot, screenshotLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
