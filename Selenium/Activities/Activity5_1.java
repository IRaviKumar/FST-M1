import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");

        String titleOfPage = driver.getTitle();
        System.out.println("Title of the page is: " + titleOfPage);

        WebElement checkbox= driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("checkbox Input is displayed or not: " + checkbox.isDisplayed());

        driver.findElement(By.id("toggleCheckbox")).click();
        System.out.println("checkbox Input is displayed or not: " + checkbox.isDisplayed());

        driver.quit();

    }
}