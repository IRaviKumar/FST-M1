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

public class ProjectActivity2 {
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void Before() throws MalformedURLException {

        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("noReset","true");
        caps.setCapability("appPackage","com.google.android.keep");
        caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");

        URL appServer=new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver<MobileElement>(appServer,caps);
    }

    @Test
    public void ActivityGoogleKeep() throws InterruptedException {


        AddGoogleKeepTask("My Google keep Assignment","This is an Appium tutorial assignment");

        long countOfAddedTasks=driver.findElementsByXPath("//android.widget.ImageView[@resource-id='com.google.android.keep:id/background_theme_image_view']").stream().count();
        Assert.assertEquals(countOfAddedTasks,1,"All the tasks were not added to task list");
    }

    @Test
    public void BonusActivityGoogleKeep() throws InterruptedException {


        AddGoogleKeepTaskWithRemainder("My Google keep Assignment with remainder","This is an Appium tutorial assignment");
        long countOfAddedTasks=driver.findElementsByXPath("//android.widget.ImageView[@resource-id='com.google.android.keep:id/background_theme_image_view']").stream().count();
        Assert.assertEquals(countOfAddedTasks,1,"All the tasks were not added to task list");

        boolean isRemainderAddedToNote=driver.findElement(MobileBy.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/reminder_chip_text']")).isDisplayed();
        Assert.assertTrue(isRemainderAddedToNote,"Task with remainder is not added");
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

    private  void AddGoogleKeepTask(String title,String description) throws InterruptedException {
        WaitUntilElementDisplayed(By.xpath("//android.widget.ImageButton[@content-desc='New text note']"));
        MobileElement newTaskButton=driver.findElementByXPath("//android.widget.ImageButton[@content-desc='New text note']");
        newTaskButton.click();
        WaitUntilElementDisplayed(By.xpath("//android.widget.EditText[@text='Title']"));
        MobileElement titleTextBox=driver.findElementByXPath("//android.widget.EditText[@text='Title']");
        titleTextBox.setValue(title);

        WaitUntilElementDisplayed(By.xpath("//android.widget.EditText[@text='Note']"));
        MobileElement descriptionTextBox=driver.findElementByXPath("//android.widget.EditText[@text='Note']");
        descriptionTextBox.setValue(description);

        MobileElement backbutton=driver.findElementByXPath("\t\n" +"//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
        backbutton.click();
        Thread.sleep(1000);
    }

    private  void AddGoogleKeepTaskWithRemainder(String title,String description) throws InterruptedException {
        WaitUntilElementDisplayed(By.xpath("//android.widget.ImageButton[@content-desc='New text note']"));
        MobileElement newTaskButton=driver.findElementByXPath("//android.widget.ImageButton[@content-desc='New text note']");
        newTaskButton.click();
        WaitUntilElementDisplayed(By.xpath("//android.widget.EditText[@text='Title']"));
        MobileElement titleTextBox=driver.findElementByXPath("//android.widget.EditText[@text='Title']");
        titleTextBox.setValue(title);

        WaitUntilElementDisplayed(By.xpath("//android.widget.EditText[@text='Note']"));
        MobileElement descriptionTextBox=driver.findElementByXPath("//android.widget.EditText[@text='Note']");
        descriptionTextBox.setValue(description);

        MobileElement remainderButton=driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Single-column view\"]");
        remainderButton.click();

        WaitUntilElementDisplayed(By.xpath("//android.widget.TextView[@text='Later today']"));
        driver.findElementByXPath("//android.widget.TextView[@text='Later today']").click();
        
        MobileElement backbutton=driver.findElementByXPath("\t\n" +"//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
        backbutton.click();
        Thread.sleep(1000);
    }

}
