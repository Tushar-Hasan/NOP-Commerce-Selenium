package utils;

import browserFactory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Utils extends DriverFactory {


    private WebDriver driver = DriverFactory.getDriver();


    //        **** Functions take WebElements
    public void clearField(WebElement ele) {
        ele.clear();
    }

    public void clickElement(WebElement ele) {
        ele.click();
    }

    public void type(WebElement ele, String text) {
        ele.clear();
        ele.sendKeys(text);
    }

    public void waitForElementToVisible(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }


    //                                  **** Functions take Locators ****

    public WebElement findEle(By loc) {
        waitForElementToVisible(loc);
        return driver.findElement(loc);
    }

    public List<WebElement> findAllElements(By loc) {
        return driver.findElements(loc);
    }

    public void clickOn(By loc) {
        findEle(loc).click();
    }

    public void clickOnWithScrollFirst(By loc) {
        scrollToElement(loc);
        findEle(loc).click();
    }

    public Select getSelect(By loc) {
        return new Select(findEle(loc));
    }

    public void clearField(By loc) {
        findEle(loc).clear();
    }

    public boolean isElementVisible(By loc) {
        return findEle(loc).isDisplayed();
    }

    public String getEleText(By loc) {
        return findEle(loc).getText();
    }

    public String getAttributeValue(By loc, String attr) {
        return findEle(loc).getAttribute(attr);
    }

    public void waitForElementToVisible(By loc) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    public void waitForElementToClikable(By loc) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(loc));
    }

    public boolean doesElementExist(By loc) {
        boolean flag = true;
        try {
            if (driver.findElements(loc).isEmpty())
                flag = false;
        } catch (NoSuchElementException e) {
            System.out.println("Element " + loc + " is not found in the DOM");
        }
        return flag;
    }

    public void scrollToElement(By loc) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findEle(loc));
    }

    public boolean isEnable(By loc) {
        return findEle(loc).isEnabled();
    }

    public void typeEle(By loc, String input) {
        clearField(loc);
        findEle(loc).sendKeys(input);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void threadSleep(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }


    public Actions getAction() {
        return new Actions(driver);
    }


    public void scrollToBottom() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        threadSleep(1);
    }


    public void refresh() {
        driver.navigate().refresh();
    }

}

