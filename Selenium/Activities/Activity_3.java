import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        String titleOfPage=driver.getTitle();
        System.out.println("Title of the page is: "+titleOfPage);

        WebElement firstNameTextBox=driver.findElement(By.id("firstName"));
        WebElement lastNameTextBox=driver.findElement(By.id("lastName"));

        WebElement emailTextBox=driver.findElement(By.id("email"));
        WebElement contactNumberTextBox=driver.findElement(By.id("number"));



        WebElement submitButton=driver.findElement(By.cssSelector(".ui.green.button"));

        firstNameTextBox.sendKeys("ravikumar");
        lastNameTextBox.sendKeys("mallisetti");
        emailTextBox.sendKeys("ravikumar08424@gmail.com");
        contactNumberTextBox.sendKeys("9741867088");

        Thread.sleep(3000);

        submitButton.click();

        driver.quit();
    }
}
