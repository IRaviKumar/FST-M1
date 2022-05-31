package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    WebDriverWait wait;
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void Before() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<Your device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void Activity() throws InterruptedException {


        driver.get("https://www.training-support.net/");
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("About Us")));
        String pageTitle = driver
                .findElementByXPath("//android.widget.TextView[@text='Training Support']")
                .getText();
        System.out.println("Title on Homepage: " + pageTitle);

        MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@content-desc='About Us']");
        aboutButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.xpath("//android.widget.TextView[@text='About Us']")
        ));

        String newPageTitle = driver
                .findElementByXPath("//android.widget.TextView[@text='About Us']")
                .getText();
        System.out.println("Title on new page: " + newPageTitle);

        Assert.assertEquals(pageTitle, "Training Support");
        Assert.assertEquals(newPageTitle, "About Us");
    }

    @AfterClass
    public void After()
    {
        driver.quit();
    }

    private void WaitUntilElementDisplayed(By element)
    {
        try
        {
            if(driver.findElement(element).isDisplayed())
            {
                return;
            }
        }
        catch(Exception e)
        {
            WebDriverWait wait=new WebDriverWait(driver,180);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));

        }

    }

    private  void AddGoogleTask(String taskName) throws InterruptedException {
        WaitUntilElementDisplayed(By.xpath("//android.widget.ImageButton[@content-desc='Create new task']"));
        MobileElement newTaskButton=driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Create new task']");
        newTaskButton.click();
        WaitUntilElementDisplayed(By.xpath("//android.widget.EditText[@text='New task']"));
        MobileElement taskNameTextBox=driver.findElementByXPath("//android.widget.EditText[@text='New task']");
        taskNameTextBox.setValue(taskName);
        MobileElement savebutton=driver.findElementByXPath("//android.widget.Button[@text='Save']");
        savebutton.click();
        Thread.sleep(1000);
    }

}
