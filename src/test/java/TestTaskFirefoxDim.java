import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestTaskFirefoxDim {

    /*

    @Before
    public beforeTest(){

        
    }

    @Test
    public void testBase() {

        System.setProperty("webdriver.gecko.driver", "D:\\git\\humanbooster\\LIBDriverBrowser\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:8080/ToDoList");



        String refTaskName = "manger";
        WebElement varTaskName  = driver.findElement(By.id("taskName"));
        varTaskName.sendKeys(refTaskName);


        String refTaskDate = "11/09/2017";
        WebElement varTaskDate  = driver.findElement(By.id("taskDate"));
        varTaskName.sendKeys(refTaskDate);


        // Appui du bouton pour valider le formulaire :
        //WebElement varButton  = driver.findElement(By.id("submitButton"));
        //varButton.click();

        // Nouvelle page, on cherche dedans :
        //varTaskName  = driver.findElement(By.id("task-0"));

        //assertEquals("Nom de task attendu", refTaskName, varTaskName.getText());


        //assertEquals("Date de task attendue", refTaskDate, varTaskDate.getText());


        //close browser
        driver.close();
    }
    */
}