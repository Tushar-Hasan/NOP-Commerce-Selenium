import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class Test_RegistrationPage extends BaseTest {

    RegistrationPage registrationPage;

    @BeforeMethod
    public void navigateToRegistrationPage() throws InterruptedException {
        HomePage homePage = new HomePage();
        registrationPage = homePage.goToRegistrationPage();
    }

    @Test
    public void checkingRegistrationWithBlankInput() throws InterruptedException {
        String expectedTitle = "nopCommerce demo store. Register";
        String actualTitle = getPageTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
