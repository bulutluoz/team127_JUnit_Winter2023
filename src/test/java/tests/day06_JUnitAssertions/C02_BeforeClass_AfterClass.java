package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClass_AfterClass {

    // 3 farkli test methodu olusturarak
    // asagida verilen gorevi tamamlayin
    // 1- testotomasyonu.com sayfasina gidin,
    //    url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yaptirin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urune tiklayin
    //    ve urun aciklamasinda case sensitive olmadan phone gectigini test edin

    /*
        Bu gorevlerin saglikli olarak yapilabilmesi icin
        - test method'larinin dogru sirada calismasi gerekir
        - driver objesi tum method'lardan once olusturulmali
          ve tum method'lar calistiktan sonra kapatilmalidir

          Bunu saglayabilmek icin @BeforeClass ve @AfterClass notasyonlari kullaniriz
          ANCAK dikkat etmemiz gereken konu
          bu notosyonlari kullanan method'lar static OLMAK ZORUNDADIR

     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("before calisti");
    }

    @AfterClass
    public static void teardown(){
        System.out.println("after calisti");
        driver.quit();
    }


    @Test
    public void test01(){
        // url testi
        // 1- testotomasyonu.com sayfasina gidin,
        //    url'in testotomasyonu icerdigini test edin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url testi PASSED");
        }else{
            System.out.println("Url testi FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void test02(){
        // arama testi
        // 2- phone icin arama yaptirin
        //    ve arama sonucunda urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        WebElement aramaSonucuElementi = driver.findElement(By.className("product-count-text"));

        String aramaSonucSayisiStr = aramaSonucuElementi.getText().replaceAll("\\D","");
        int aramaSonucSayisi = Integer.parseInt(aramaSonucSayisiStr);

        if (aramaSonucSayisi>0){
            System.out.println("Arama testi PASSED");
        }else{
            System.out.println("Arama testi FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void test03(){
        // ilk urun detay testi
        // 3- ilk urune tiklayin
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();
        //    ve urun aciklamasinda case sensitive olmadan phone gectigini test edin
        WebElement urunAciklamaElementi = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));

        String expectedUrunIcerik = "phone";
        String urunAciklama = urunAciklamaElementi.getText().toLowerCase();

        if (urunAciklama.contains(expectedUrunIcerik)){
            System.out.println("Ilk urun testi PASSED");
        }else {
            System.out.println("Ilk urun testi FAILED");
            throw new AssertionFailedError();
        }

    }
}
