import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");

        String titleOfPage=driver.getTitle();
        System.out.println("Title of the page is: "+titleOfPage);

        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));

        firstName.sendKeys("Ravikumar");
        lastName.sendKeys("Mallisetti");

        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("ravikumar08424@gmail.com");
        driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys("9741867088");
        driver.findElement(By.xpath("//textarea")).sendKeys("Sample Message");
        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();

        driver.quit();

    }
}
