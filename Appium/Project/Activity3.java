package Activities;

import io.appium.java_client.MobileElement;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
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
    public void Add() {
        driver.findElementById("digit_5").click();
        driver.findElementById("op_add").click();
        driver.findElementById("digit_9").click();
        driver.findElementById("eq").click();
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "14");
    }

    @Test
    public void Subtract() {
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("op_sub").click();
        driver.findElementById("digit_5").click();
        driver.findElementById("eq").click();
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "5");
    }

    @Test
    public void Multiply() {
        driver.findElementById("digit_5").click();
        driver.findElementById("op_mul").click();
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("eq").click();
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "500");
    }

    @Test
    public void Divide() {
        driver.findElementById("digit_5").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("op_div").click();
        driver.findElementById("digit_2").click();
        driver.findElementById("eq").click();
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "25");
    }

    @AfterClass
    public void After()
    {
        driver.quit();
    }

}
