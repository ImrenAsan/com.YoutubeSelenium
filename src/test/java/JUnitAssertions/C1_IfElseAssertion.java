package JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C1_IfElseAssertion {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test

    public void test01() throws InterruptedException {
        // 1. https://www.amazon.com/ sayfasina gidin.
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        //2. arama cubuguna nutella yazdirin.
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella");

        //3. Nutella yazdiktan sonra enetere basin
        searchBox.submit();

        //4. Bulunan sonuc sayisini yazridin.
        WebElement actualText= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(actualText.getText());

        String actText = actualText.getText();
        String expectedText = "1-48 von 126 Ergebnissen oder Vorschlägen für \"nutella\"";

        if (actText == expectedText){
            System.out.println("Test Passed!");
        }else {
            System.out.println("Test Failed");
        }

        Assert.assertTrue(actText.contains(expectedText)); // Process finished with exit code -1!

        //If clause Assertion: Junit -> Test Passed "green tick", Test failed -> red tick
        // JUnit benefits: Assertion Class -> Verification! Contains static methods

        //Assert.assertTrue(boolean condition - true); //to test the codes, if they are correct
        //Assert.assertTrue(boolean condition - false); // to test the codes, if they are false
        //Assert.assertEquals(expected object, actual object);
    }

}
