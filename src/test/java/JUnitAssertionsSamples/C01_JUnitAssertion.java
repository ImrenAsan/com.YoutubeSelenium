package JUnitAssertionsSamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JUnitAssertion {

    @Test
    public void test01(){
        //1.Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2.Navigate to url `https://automationexercise.com/'
        driver.get("https://automationexercise.com/");

        //3.Verify that home page is visible succesfully.
        WebElement verificationValue = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(verificationValue.isDisplayed()); //metodun görünüp görünmedigini kontrol ediyor.

        //4. Click on 'Signup / Login' button
        WebElement signUpLink= driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signUpLink.click();

        //5. Verify 'Login to your account' is visible
        WebElement loginText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginText.isDisplayed());

        //6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("ahmet@nehaber.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("12345");

        //7.Click 'login' button
        WebElement loginButton= driver.findElement(By.xpath("//button[@data-qa='login-button']"));
       loginButton.click();

        //8.Verify that user is navigated to login page
        WebElement loggedIn = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        System.out.println(loggedIn.getText());
        Assert.assertTrue(loggedIn.isDisplayed());

        //9.Click 'Logout' button
        WebElement logOut= driver.findElement(By.xpath("//a[text()=' Logout']"));
        logOut.click();

        //10.Verify that user is navigated to login page
       String expectedUrl = "https://automationexercise.com/login";
       String actualUrl = driver.getCurrentUrl();
       Assert.assertEquals(expectedUrl,actualUrl);

        //11.Close driver

        driver.close();


    }
}
