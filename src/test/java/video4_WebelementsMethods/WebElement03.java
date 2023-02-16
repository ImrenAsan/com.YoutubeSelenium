package video4_WebelementsMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebElement03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        //   1. https://www.bestbuy.com adresine gidin.
        driver.get("https://www.bestbuy.com");

        // 2. Cookies cikarsa kabul edin.

        //3. sayfada kac adet button tagi bulundugunu yazdirin.
        List<WebElement> buttonList= driver.findElements(By.tagName("button"));
        System.out.println(buttonList.size());

        //4. sayfadaki her bir button uzerindeki yazilari yazdirin.

        for (WebElement each:buttonList
             ) {
            System.out.println(each.getText());
        }
    }
}
