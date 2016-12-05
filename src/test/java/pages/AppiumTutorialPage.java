package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created on 01/12/2016 at 10:11.
 */
public class AppiumTutorialPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Introduction')]")
    WebElement introductionLink;

    public AppiumTutorialPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getIntroductionLinkTitle()
    {
        return introductionLink.getAttribute("title");
    }
}
