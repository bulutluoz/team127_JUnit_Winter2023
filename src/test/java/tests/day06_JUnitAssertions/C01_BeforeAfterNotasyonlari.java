package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_BeforeAfterNotasyonlari {

    // 3 farkli test method'u olusturarak
    // asagidaki testleri yapin
    // 1- test otomasyonu.com sitesine gidin
    // 2- phone, shoes ve dress icin arama yapin
    // 3- arama sonucunda urun bulunabildigini test edin
    // 4- sayfayi kapatin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void phoneTesti(){
        // 1- test otomasyonu.com sitesine gidin
        driver.get("https://www.testotomasyonu.com");
        // 2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // 3- arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String aramaSonucSayisiStr= aramaSonucElementi.getText().replaceAll("\\D","");
        int aramaSonucSayisi = Integer.parseInt(aramaSonucSayisiStr);

        if (aramaSonucSayisi>90){
            System.out.println("phone testi PASSED");
        }else{
            System.out.println("phone testi FAILED");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);
    }

    @Test @Ignore
    public void shoesTesti(){
        // 1- test otomasyonu.com sitesine gidin
        driver.get("https://www.testotomasyonu.com");
        // 2- shoes icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("shoes" + Keys.ENTER);
        // 3- arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String aramaSonucSayisiStr= aramaSonucElementi.getText().replaceAll("\\D","");
        int aramaSonucSayisi = Integer.parseInt(aramaSonucSayisiStr);

        if (aramaSonucSayisi>0){
            System.out.println("shoes testi PASSED");
        }else{
            System.out.println("shoes testi FAILED");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);
    }

    @Test
    public void dressTesti(){
        // 1- test otomasyonu.com sitesine gidin
        driver.get("https://www.testotomasyonu.com");
        // 2- dress icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress" + Keys.ENTER);
        // 3- arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String aramaSonucSayisiStr= aramaSonucElementi.getText().replaceAll("\\D","");
        int aramaSonucSayisi = Integer.parseInt(aramaSonucSayisiStr);

        if (aramaSonucSayisi>0){
            System.out.println("dress testi PASSED");
        }else{
            System.out.println("dress testi FAILED");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);
    }
}
