package video2_driverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManageMetodlari {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        System.out.println(driver.manage().window().getSize());

        System.out.println(driver.manage().window().getPosition());

        driver.manage().window().setPosition(new Point(15,15));

        driver.manage().window().setSize(new Dimension(900, 600));

        System.out.println("yeni pencere olculeri: " + driver.manage().window().getSize());
        System.out.println("yeni pencere konumu: " + driver.manage().window().getPosition());

        driver.manage().window().maximize();
        System.out.println(driver.manage().window().getPosition() + " maximize konum ");
        System.out.println("maximize boyut: " + driver.manage().window().getSize());

        driver.manage().window().fullscreen();
        System.out.println("fullscreen konum: " + driver.manage().window().getPosition());
        System.out.println("fullscreen boyut: " + driver.manage().window().getSize());

        driver.manage().window().minimize();

        //2. driver.manage().timeouts() metodlari

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //manage().window().maximize(); ile implicitlyWait(Duration.ofSeconds()); bütün sayfalarin basinda kullaniliyor.







    }
}
