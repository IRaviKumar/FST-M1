import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        String titleOfPage=driver.getTitle();
        System.out.println("Title of the page is: "+titleOfPage);
        WebElement elementUsingId=driver.findElement(By.id("about-link"));
        WebElement elementUsingClassName=driver.findElement(By.cssSelector(".ui.inverted.huge.green.button"));
        WebElement elementUsingCssSelector=driver.findElement(By.cssSelector("#about-link"));
        WebElement elementUsingLinkText=driver.findElement(By.linkText("About Us"));

        String textOfWebElementUsingId=elementUsingId.getText();
        String textOfWebElementUsingCss=elementUsingCssSelector.getText();
        String textOfWebElementUsingClass=elementUsingClassName.getText();
        String textOfWebElementUsingLinkText=elementUsingLinkText.getText();

        System.out.println("Text of Web Element using Id"+textOfWebElementUsingId);
        System.out.println("Text of Web Element using CSS"+textOfWebElementUsingCss);
        System.out.println("Text of Web Element using Class Name"+textOfWebElementUsingClass);
        System.out.println("Text of Web Element using Link Text"+textOfWebElementUsingLinkText);

        driver.quit();
    }
}
