

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;


public class TestTaskSelenium {
/*
    @Test
    public void testerCascadeTask() {
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
        //System.setProperty("webdriver.firefox.marionette", "false");
        WebDriver driver = new FirefoxDriver();

        //String baseUrl = "http://46.101.223.195/ToDoList";
        String baseUrl = "http://localhost:8080/ToDoList";
        driver.get(baseUrl);

        // Remplissage du formulaire :
        String refTaskName = "manger";
        WebElement varTaskName  = driver.findElement(By.id("taskName"));
        varTaskName.sendKeys(refTaskName);

        // Appui du bouton pour valider le formulaire :
        WebElement varButton  = driver.findElement(By.id("submitButton"));
        varButton.click();

        // Nouvelle page, on cherche dedans :
        varTaskName  = driver.findElement(By.id("task-0"));

        assertEquals("Nom de task attendu", refTaskName, varTaskName.getText());

        //close Fire fox
        driver.close();
    }
    */
}
