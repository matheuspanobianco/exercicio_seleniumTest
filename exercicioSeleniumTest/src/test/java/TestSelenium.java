import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TestSelenium {
    private ChromeDriver webDriver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://chercher.tech/practice/dynamic-table");
    }

    @AfterEach
    void afterAll() {
        webDriver.close();
    }


    @Test
    void deveTestarSections() {

        WebElement elementFound1 = webDriver.findElement(By.id("blue"));
        elementFound1.click();
        WebElement outputelement1 = webDriver.findElement(By.id("output"));
        assertEquals("Blueberry", outputelement1.getText());

        WebElement elementFound2 = webDriver.findElement(By.xpath("//button[contains(text(), 'Strawberry')]"));
        elementFound2.click();
        WebElement outputelement2 = webDriver.findElement(By.id("output"));
        assertEquals("Strawberry", outputelement2.getText());

        WebElement elementFound3 = webDriver.findElement(By.xpath("//button[contains(text(), 'Apple')]"));
        elementFound3.click();
        WebElement outputelement3 = webDriver.findElement(By.id("output"));
        assertEquals("Apple", outputelement3.getText());

        WebElement elementFound4 = webDriver.findElement(By.xpath("//button[contains(text(), 'Grape')]"));
        elementFound4.click();
        WebElement outputelement4 = webDriver.findElement(By.id("output"));
        assertEquals("Grape", outputelement4.getText());

        WebElement elementFound5 = webDriver.findElement(By.xpath("//button[contains(text(), 'Burger')]"));
        elementFound5.click();
        WebElement outputelement5 = webDriver.findElement(By.id("output"));
        assertEquals("Burger", outputelement5.getText());

        WebElement elementFound6 = webDriver.findElement(By.xpath("//button[contains(text(), 'Juice')]"));
        elementFound6.click();
        WebElement outputelement6 = webDriver.findElement(By.id("output"));
        assertEquals("Juice", outputelement6.getText());

        WebElement elementFound7 = webDriver.findElement(By.xpath("//input[@value='Zack    Snyder']"));
        elementFound7.click();
        WebElement outputelement7 = webDriver.findElement(By.id("output"));
        assertEquals("Zack Snyder", outputelement7.getText());

    }

    @Test
    void deveTestarChercherCheckBox() {

        WebElement checkboxChercher = webDriver.findElement(By.xpath("//td[contains(text(), 'Chercher.tech')]/preceding-sibling::td/input[@type='checkbox']"));
        String locationChercher = checkboxChercher.getLocation().toString();

        checkboxChercher.click();

        webDriver.navigate().refresh();
        checkboxChercher = webDriver.findElement(By.xpath("//td[contains(text(), 'Chercher.tech')]/preceding-sibling::td/input[@type='checkbox']"));
        assertNotEquals(locationChercher, checkboxChercher.getLocation().toString());

    }

}
