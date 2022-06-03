import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get(" https://training-support.net/selenium/dynamic-attributes");

        String titleOfPage = driver.getTitle();
        System.out.println("Title of the page is: " + titleOfPage);

        WebElement userNameTextBox = driver.findElement(By.xpath("//input[starts-with(@class, 'username')]"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[contains(@class, 'password')]"));

        userNameTextBox.sendKeys("admin");
        passwordTextBox.sendKeys("password");

        WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
        loginButton.click();

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        driver.quit();

    }
}
