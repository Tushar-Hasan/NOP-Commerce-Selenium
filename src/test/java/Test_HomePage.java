import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_HomePage extends BaseTest {

    //               Locators
    By registrationPageLink = By.xpath("//a[contains(text(),'Register')]");

    @Test
    public void test() throws InterruptedException {
        String actual_title = getPageTitle();
        String expected_title = "Your store. Home page title";
        Assert.assertEquals(expected_title, actual_title);
    }

}
