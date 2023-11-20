package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1- testotomasyonu.com anasayfasina gidelim
        driver.get("https://www.testotomasyonu.com");
        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='global-search']"));
        //3- “phone” ile arama yapalim
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));
        System.out.println(sonucYaziElementi.getText());
        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//div[@class='product-box my-2  py-1'])[1]"))
                .click();
        //6- Urunun stokta var oldugunu test edin

        WebElement urunStokElementi = driver.findElement(By.xpath("(//span[@class='heading-xs '])[1] "));

        String expectedStokDurumu = "Availibility: In Stock" ;
        String actualStokDurumu = urunStokElementi.getText();

        if (expectedStokDurumu.equals(actualStokDurumu)){
            System.out.println("Urun stok testi PASSED");
        }else {
            System.out.println("Urun stok testi FAILED");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
