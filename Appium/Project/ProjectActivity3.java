package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ProjectActivity3 {
    private AndroidDriver<MobileElement> driver;


    @BeforeClass
    public void Before() throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("noReset","true");
        caps.setCapability("appPackage","com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver<>(appServer,caps);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get("https://www.training-support.net/selenium");
        wait(40);
    }

    @Test
    public void ActivityGoogleChrome() throws InterruptedException {

        MobileElement todoElement = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text('+To-Do List+'))");
        todoElement.click();
        Thread.sleep(3000);
        AddGoogleTask("Complete Activity with Google Tasks");
        AddGoogleTask("Complete Activity with Google Keep");
        AddGoogleTask("Complete the second Activity Google Keep");
    }

    @Test
    public void BonusActivityGoogleChrome1CorrectCredentials() throws InterruptedException {


        MobileElement loginFormElement = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text('+Login Form+'))");
        loginFormElement.click();
        Thread.sleep(3000);
        MobileElement userNameTextBox=driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='username']"));
        MobileElement passwordTextBox=driver.findElement(MobileBy.xpath("android.widget.EditText[@resource-id='password']"));
        userNameTextBox.setValue("admin");
        passwordTextBox.setValue("password");
        driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Log in']")).click();
        Thread.sleep(3000);
        boolean iswelcomeBackAdminmessageDisplayed=driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText().equals("Welcome Back, admin");
        Assert.assertEquals(iswelcomeBackAdminmessageDisplayed,true,"correct credentials screen is not shown");
    }

    @Test
    public void BonusActivityGoogleChrome1InCorrectCredentials() throws InterruptedException {
        MobileElement loginFormElement = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text('+Login Form+'))");
        loginFormElement.click();
        Thread.sleep(3000);
        MobileElement userNameTextBox=driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='username']"));
        MobileElement passwordTextBox=driver.findElement(MobileBy.xpath("android.widget.EditText[@resource-id='password']"));
        userNameTextBox.setValue("Ravi");
        passwordTextBox.setValue("ravi424");
        driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Log in']")).click();
        Thread.sleep(3000);
        boolean isInvalidScreenDisplayed=driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText().equals("Invalid Credentials");
        Assert.assertEquals(isInvalidScreenDisplayed,true,"Invalid credentials screen is not shown");
    }
    @Test
    public void BonusActivityGoogleChrome2CorrectCredentials() throws InterruptedException {

        MobileElement popupcardElement = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text('+Popups+'))");
        popupcardElement.click();
        MobileElement signInButton=driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Sign In']"));
        signInButton.click();
        Thread.sleep(3000);
        MobileElement userNameTextBox=driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='Username']"));
        MobileElement passwordTextBox=driver.findElement(MobileBy.xpath("android.widget.EditText[@resource-id='password']"));
        userNameTextBox.setValue("admin");
        passwordTextBox.setValue("password");
        driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Log in']")).click();
        Thread.sleep(3000);
        boolean iswelcomeBackAdminmessageDisplayed=driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText().equals("Welcome Back, admin");
        Assert.assertEquals(iswelcomeBackAdminmessageDisplayed,true,"correct credentials screen is not shown");
    }

    @Test
    public void BonusActivityGoogleChrome2WrongCredentials() throws InterruptedException {

        MobileElement popupcardElement = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text('+Popups+'))");
        popupcardElement.click();
        MobileElement signInButton=driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Sign In']"));
        signInButton.click();
        Thread.sleep(3000);
        MobileElement userNameTextBox=driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='Username']"));
        MobileElement passwordTextBox=driver.findElement(MobileBy.xpath("android.widget.EditText[@resource-id='password']"));
        userNameTextBox.setValue("Ravi");
        passwordTextBox.setValue("ravi424");
        driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Log in']")).click();
        Thread.sleep(3000);
        boolean isInvalidScreenDisplayed=driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText().equals("Invalid Credentials");
        Assert.assertEquals(isInvalidScreenDisplayed,true,"Invalid credentials screen is not shown");
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

        MobileElement taskNameTextBox=driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']");
        taskNameTextBox.setValue(taskName);

        WaitUntilElementDisplayed(By.xpath("//android.widget.Button[@text='Add Task']"));

        MobileElement addTaskButton=driver.findElementByXPath("//android.widget.Button[@text='Add Task']");
        addTaskButton.click();

        MobileElement clearListButton=driver.findElementByXPath("//android.view.View[@text='Clear List']");
        clearListButton.click();
        Thread.sleep(1000);
    }

}
