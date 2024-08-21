package locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loc_homePage {

    @FindBy(xpath = "//a[@class='ico-register']")
    public WebElement registrationPageLink ;

}
