import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.findElement;

public class TestTaskBySelenium {

    @Test
    public void testerTaskNavigChrome() {

        //System.setProperty("webdriver.chrome.driver",".\\LIBDriverBrowser\\chromedriverWin.exe");
        System.setProperty("webdriver.chrome.driver",".\\LIB\\chromedriver-windows");

        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://46.101.223.195/ToDoList";
        driver.get(baseUrl);

        // Remplissage du formulaire :
        String refTaskName = "manger";
        WebElement varTaskName  = driver.findElement(By.id("taskName"));
        varTaskName.sendKeys(refTaskName);

        String refTaskDate = "11/09/2017";
        WebElement varTaskDate  = driver.findElement(By.id("taskDate"));
        varTaskName.sendKeys(refTaskDate);

        assertEquals("Nom de task attendu", refTaskName, varTaskName.getText());
        assertEquals("Date de task attendue", refTaskDate, varTaskDate.getText());

        //close browser
        driver.close();
    }
}
