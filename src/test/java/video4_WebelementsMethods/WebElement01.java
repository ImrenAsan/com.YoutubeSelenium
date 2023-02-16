package video4_WebelementsMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElement01 {


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // 1. https://www.amazon.com/ sayfasina gidin.
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        //2. arama cubuguna nutella yazdirin.
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella");
        //3. Nutella yazdiktan sonra enetere basin
        searchBox.submit();
        //4. Bulunan sonuc sayisini yazridin.
        WebElement resultText= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resultText.getText());

        driver.close();
    }


}
