import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tables");

        List<WebElement> columns=driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));

        System.out.println("Number of Rows" + rows.size());
        System.out.println("Number of Columns" + columns.size());

        WebElement cellValueSecondRowSecondColumn = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value Before:" + cellValueSecondRowSecondColumn.getText());

        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[2]")).click();

        WebElement cellValueSecondRowSecondColumnAfterEdit = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value After: " + cellValueSecondRowSecondColumnAfterEdit.getText());

        WebElement tableFooter = driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        System.out.println("Table footer values: " + tableFooter.getText());

        driver.quit();
    }
}
