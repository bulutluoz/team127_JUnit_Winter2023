package tests.day05_JUnitFramework;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C05_TestNotasyonu {

    // bir class'in icinde birden fazla bagimsiz calisabilen test olur mu ?
    // JUnit ile calisirken class'da birden fazla test oldugunda
    // toplu calistirdigimiz zaman hangi sira ile calisacagini BILEMEYIZ ve KONTROL EDEMEYIZ

    @Test
    public void testOtomasyonuTest(){ // test method'lari static olmamalidir
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");
        // title'in "Test Otomasyon" icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        }else System.out.println("Test otomasyonu testi FAILED");
        ReusableMethods.bekle(1);
        driver.quit();
    }

    @Test
    public void wisequarterTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // wisequarter.com adresine gidin
        driver.get("https://www.wisequarter.com");
        // title'in "Wise" icerdigini test edin
        String expectedTitleIcerik = "Wise";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else System.out.println("Wisequarter testi FAILED");
        ReusableMethods.bekle(1);
        driver.quit();

    }

    @Test
    public void googleTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // google.com adresine gidin
        driver.get("https://www.google.com");
        // url'in "google" icerdigini test edin
        String expectedUrlIcerik = "google";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Google testi PASSED");
        }else System.out.println("Google testi FAILED");
        ReusableMethods.bekle(1);
        driver.quit();

    }
}
