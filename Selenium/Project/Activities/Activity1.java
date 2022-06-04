package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity1 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void FirstActivity_VerifyWebSiteTitle() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("SuiteCRM", title);
    }

    @Test
    public void SecondActivity_VerifyURLOfHeaderImage()  {

        WebElement headerLogo=driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
        System.out.println("URL Of Logo is: " + headerLogo.getAttribute("src"));
    }

    @Test
    public void ThirdActivity_GetCopyRightText()  {

        WebElement firstCopyRight=driver.findElement(By.xpath("//div[@class='p_login_bottom']/a[@id='admin_options']"));
        System.out.println("Text Of first copyright is: " + firstCopyRight.getText());
    }

    @Test
    public void FourthActivity_LoggingIntoSite()  {

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")));

        boolean isHomePageLaunched=driver.findElement(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")).isDisplayed();
        Assert.assertTrue(isHomePageLaunched);
    }

    @Test()
    public void FifthActivity_GetColorOfNavigationMenu()  {


        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")));

        boolean isHomePageLaunched=driver.findElement(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")).isDisplayed();
        Assert.assertTrue(isHomePageLaunched);

        WebElement Navigationmenu=driver.findElement(By.xpath("//div[@id='toolbar']"));
        String BackGroundColor=Navigationmenu.getCssValue("color");
        String hex = Color.fromString(BackGroundColor).asHex();
        System.out.println(hex);
        System.out.println("Color of Navigation Header is: " + BackGroundColor);
    }

    @Test()
    public void SixthActivity_MenuChecking()  {


        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")));

        boolean isHomePageLaunched=driver.findElement(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")).isDisplayed();
        Assert.assertTrue(isHomePageLaunched);

        WebElement activitiesmenuitem=driver.findElement(By.linkText("ACTIVITIES"));
        boolean doesitemexists=activitiesmenuitem.isDisplayed();
        Assert.assertTrue(doesitemexists,"Activities menu item does not exists");
    }

    @Test()
    public void SeventhActivity_MenuChecking() throws InterruptedException {


        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")));

        boolean isHomePageLaunched=driver.findElement(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")).isDisplayed();
        Assert.assertTrue(isHomePageLaunched);

        Thread.sleep(4000);

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[text()='Sales']"))).moveToElement(driver.findElement(By.xpath("//a[text()='Leads']"))).click().build().perform();
        Thread.sleep(4000);
        WebElement contactIcon=driver.findElement(By.xpath("//table[@class='list view table-responsive']/descendant::tr[4]/descendant::td[10]"));
        contactIcon.click();

        Thread.sleep(4000);
        String PhoneNumber=driver.findElement(By.xpath("//div[@class='open ui-dialog-content ui-widget-content']/descendant::span[@class='phone']")).getText();
        System.out.println("Phone number of user is: "+PhoneNumber);
    }

    @Test()
    public void EighthActivity_TraversingTables() throws InterruptedException {


        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")));

        boolean isHomePageLaunched=driver.findElement(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")).isDisplayed();
        Assert.assertTrue(isHomePageLaunched);

        Thread.sleep(4000);

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[text()='Sales']"))).moveToElement(driver.findElement(By.xpath("//a[text()='Accounts']"))).click().build().perform();
        Thread.sleep(4000);
        List<WebElement> first5OddNumberRowNames=driver.findElements(By.xpath("//table[@class='list view table-responsive']/descendant::tr[@class='oddListRowS1']/descendant::td[3]"));
        for (int i=0; i<first5OddNumberRowNames.size(); i++)
        {
            System.out.println("Name of odd numbered row user is: "+first5OddNumberRowNames.get(i).getText());
        }

    }

    @Test()
    public void NinethActivity_TraversingTables2() throws InterruptedException {


        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")));

        boolean isHomePageLaunched=driver.findElement(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")).isDisplayed();
        Assert.assertTrue(isHomePageLaunched);

        Thread.sleep(4000);

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[text()='Sales']"))).moveToElement(driver.findElement(By.xpath("//a[text()='Leads']"))).click().build().perform();
        Thread.sleep(4000);

        List<WebElement> namecolumnvalues=driver.findElements(By.xpath("//table[@class='list view table-responsive']/descendant::tr/descendant::td[@field='name']"));
        List<WebElement> usercolumnValues=driver.findElements(By.xpath("//table[@class='list view table-responsive']/descendant::tr/descendant::td[@field='assigned_user_name']"));
        for (int i=0; i<10; i++)
        {
            System.out.println("First 10 values in Name column: "+namecolumnvalues.get(i).getText());
        }
        for (int i=0; i<10; i++)
        {
            System.out.println("First 10 values in User column: "+usercolumnValues.get(i).getText());
        }

    }




    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
