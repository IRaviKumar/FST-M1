package Activities;

import io.appium.java_client.MobileElement;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void Before() throws MalformedURLException {

        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("noReset","true");
        caps.setCapability("appPackage","com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL appServer=new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver<MobileElement>(appServer,caps);
    }

    @Test
    public void Activity() throws InterruptedException {
       MobileElement digit9=driver.findElementById("digit_9");
       MobileElement digit3=driver.findElementById("digit_3");
       MobileElement mulitiplybutton=driver.findElementById("op_mul");
       digit9.click();
       mulitiplybutton.click();
       digit3.click();
        MobileElement equalButton=driver.findElementById("eq");
        equalButton.click();
        Thread.sleep(4000);
        String result=driver.findElementById("result").getText();
        Assert.assertEquals(result,"27","result is not correct");
    }

    @AfterClass
    public void After()
    {
        driver.quit();
    }

}
