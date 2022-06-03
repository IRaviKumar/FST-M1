import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get(" https://training-support.net/selenium/dynamic-attributes");

        String titleOfPage = driver.getTitle();
        System.out.println("Title of the page is: " + titleOfPage);

        WebElement userNameTextBox = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        WebElement confirmPasswordTextBox = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input"));
        WebElement emailTextBox = driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));

        userNameTextBox.sendKeys("Mallisetti");
        passwordTextBox.sendKeys("ravikumar08424");
        confirmPasswordTextBox.sendKeys("ravikumar08424");
        emailTextBox.sendKeys("ravikumar08424@gmail.com");

        WebElement signUpButton=driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]"));;
        signUpButton.click();

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        driver.quit();

    }
}
