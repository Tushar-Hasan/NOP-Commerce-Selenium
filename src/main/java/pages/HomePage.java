package pages;

import locators.Loc_homePage;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class HomePage extends Utils {
    public Loc_homePage locs = new Loc_homePage();

    public RegistrationPage goToRegistrationPage() throws InterruptedException {
        //threadSleep(10);
        WebElement registrationPageLink = locs.registrationPageLink;
        System.out.println(registrationPageLink.getText());
        registrationPageLink.click();
        return new RegistrationPage();
    }
}
