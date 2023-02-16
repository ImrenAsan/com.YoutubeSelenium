package video4_WebelementsMethods;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElement02 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement cookiesElement = driver.findElement(By.xpath("//button[@title='Temel ve isteğe bağlı çerezlere izin ver']"));
        cookiesElement.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("hcncskl");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
        password.sendKeys("657838");
        Thread.sleep(2000);

        WebElement login= driver.findElement(By.xpath("//button[@name='login']"));
        login.click();

        WebElement resultText = driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedText= "Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
        String actualText = resultText.getText();

        if (expectedText == actualText){
            System.out.println("System Works");
        } else{
            System.out.println("Test Fail!");
        }

        driver.close();


    }
}
