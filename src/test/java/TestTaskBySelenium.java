import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestTaskBySelenium {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        String os = System.getProperty("os.name").toLowerCase().split(" ")[0];

        //String pathDriver = Paths.get(".").toAbsolutePath().normalize().toString()+"\\LIB\\chromedriver-"+os;
        String pathDriver = Paths.get(".").toAbsolutePath().normalize().toString()+"/LIB/chromedriver-"+os;
        System.out.println(pathDriver);

        System.setProperty("webdriver.chrome.driver", pathDriver);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testerTaskNavigChrome() {

        /* OLD version :
        System.setProperty("webdriver.chrome.driver",".\\LIB\\chromedriver-windows");
        driver = new ChromeDriver(); */

        String baseUrl = "http://localhost:8080/ToDoList";
        //String baseUrl = "http://46.101.223.195/ToDoList";
        driver.get(baseUrl);

        // Remplissage du formulaire :
        String refTaskName = "manger";
        WebElement varTaskName  = driver.findElement(By.id("taskName"));
        varTaskName.sendKeys(refTaskName);

        /*
        String refTaskDate = "11/09/2017";
        WebElement varTaskDate  = driver.findElement(By.id("taskDate"));
        varTaskName.sendKeys(refTaskDate);
        */

        // Appui du bouton pour valider le formulaire :
        WebElement varButton  = driver.findElement(By.id("submitButton"));
        varButton.click();

        // Nouvelle page, on cherche dedans :
        varTaskName  = driver.findElement(By.id("task-0"));

        assertEquals("Nom de task attendu", refTaskName, varTaskName.getText());

        /*
        assertEquals("Date de task attendue", refTaskDate, varTaskDate.getText());
        */

        //close browser
        driver.close();
        driver.quit();
    }
}
