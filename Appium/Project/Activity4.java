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

public class Activity4 {
    WebDriverWait wait;
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void Before() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<Your device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");;
        caps.setCapability("noReset", true);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addContact() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new contact")));
        driver.findElementByAccessibilityId("Create new contact").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='First name']")));

        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
        MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
        firstName.sendKeys("Ravi");
        lastName.sendKeys("kumar");

        driver.hideKeyboard();

        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
        phoneNumber.sendKeys("9741867088");

        driver.findElementById("editor_menu_save_button").click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));

        MobileElement mobileCard = driver.findElementById("toolbar_parent");
        Assert.assertTrue(mobileCard.isDisplayed());

        String contactName = driver.findElementById("large_title").getText();
        Assert.assertEquals(contactName, "Ravi kumar");
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

}
