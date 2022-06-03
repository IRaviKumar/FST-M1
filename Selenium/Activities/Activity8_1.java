import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tables");

        int columns=driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td")).size();
        int rows=driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr")).size();

        System.out.println("Number of Rows" + rows);
        System.out.println("Number of Columns" + columns);

        List<WebElement> thirdRowColumns=driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
        for(WebElement ele:thirdRowColumns)
        {
             System.out.println("Column Value: "+ele.getText());
        }

        WebElement secondrowsecondcolumn=driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value:" +secondrowsecondcolumn.getText());

        driver.quit();
    }
}
