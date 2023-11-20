package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class C01_BonigarciaWebdriver {

    public static void main(String[] args) throws InterruptedException {

        // Bir class'ta test islemlerine baslamadan once
        // ilk olarak Webdriver objemizi olusturmali
        // ve gerekli ayarlamalari yapmaliyiz

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(2000);
        driver.quit();
    }
}
