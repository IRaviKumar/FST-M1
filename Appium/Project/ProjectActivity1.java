package Activities;

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

public class ProjectActivity1 {
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void Before() throws MalformedURLException {

        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("noReset","true");
        caps.setCapability("appPackage","com.google.android.apps.tasks");
        caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");

        URL appServer=new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver<MobileElement>(appServer,caps);
    }

    @Test
    public void ActivityGoogleTask() throws InterruptedException {


        AddGoogleTask("Complete Activity with Google Tasks");
        AddGoogleTask("Complete Activity with Google Keep");
        AddGoogleTask("Complete the second Activity Google Keep");

        long countOfAddedTasks=driver.findElementsByXPath("//android.view.ViewGroup[@resource-id='com.google.android.apps.tasks:id/task_data']").stream().count();
        Assert.assertEquals(countOfAddedTasks,3,"All the tasks were not added to task list");
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
