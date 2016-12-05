package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created on 30/11/2016 at 17:41.
 */
public class MainPage extends BasePage {

    @FindBy(xpath = "//ul[@id='primary-menu']//li[contains(@class,'menu-item-26284')]")
    WebElement tutorialMenu;

    @FindBy(xpath = "//ul[@id='primary-menu']//li[contains(@class,'menu-item-26284')]/a/span[1]")
    WebElement tutorialMenuButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickTutorialMenu()
    {
        click(tutorialMenuButton);
    }
    public  void clickTutorialMenuAppiumLink()
    {
        click(tutorialMenu.findElement(By.xpath(".//ul/li[contains(@class,'menu-item-23716')]")));
    }
}
