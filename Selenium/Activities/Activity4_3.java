import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");

        String titleOfPage=driver.getTitle();
        System.out.println("Title of the page is: "+titleOfPage);

        String thirdHeaderOnPage = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("Third header text is: " + thirdHeaderOnPage);

        String fifthHeaderOnPageColour = driver.findElement(By.xpath("//h5")).getCssValue("color");
        System.out.println("Fifth header colour is: " + fifthHeaderOnPageColour);

        String violetButtonClassAttributes = driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class");
        System.out.println("Violet button's classes are: " + violetButtonClassAttributes);

        String greyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
        System.out.println("The grey button's text is: " + greyButton);

        driver.quit();

    }
}
