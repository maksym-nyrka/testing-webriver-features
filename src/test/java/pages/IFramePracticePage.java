package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created on 30/11/2016 at 15:34.
 */
public class IFramePracticePage extends BasePage {

    @FindBy(xpath = "//iframe[@name='iframe1']")
    WebElement IFrame1;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstnameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastnameInput;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitButton;

    public IFramePracticePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getIFrame1() {
        return IFrame1;
    }

    public String getFirstname() {
        return firstnameInput.getAttribute("value");
    }

    public void setFirstname(String firstname)
    {
        type(firstname,firstnameInput);
    }
    public void setLastname(String lastname)
    {
        type(lastname,lastnameInput);
    }
    public void clickSubmitButton()
    {
        click(submitButton);
    }
}
