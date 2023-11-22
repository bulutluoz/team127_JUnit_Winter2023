package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_GoogleAramaTesti {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        ReusableMethods.bekle(10);
        driver.findElement(By.xpath("//*[text()='Accept all']")).click();
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitleIcerik = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElementi = driver.findElement(By.id("result-stats"));
        String sonucYazisiStr = sonucYaziElementi.getText();
        System.out.println("Bulunan sonuc yazisi : " + sonucYazisiStr);
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //About 163.000.000 results (0,39 seconds)
        String[] sonucYazisiArr = sonucYazisiStr.split(" ");

        String sonucSayisiStr = sonucYazisiArr[1]; // 163.000.000

        // sonucSayisiStr = sonucSayisiStr.replace(".","");
        sonucSayisiStr = sonucSayisiStr.replaceAll("\\D",""); // "163000000"

        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr);

        if (sonucSayisiInt > 10000000){
            System.out.println("Arama sonuc sayisi testi PASSED");
        }else System.out.println("Arama sonuc sayisi testi FAILED");

        //8- Sayfayi kapatin

        ReusableMethods.bekle(2);
        driver.quit();

    }
}
