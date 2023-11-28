package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C07_DosyaYukleme extends TestBase {

    @Test
    public void dosyaYuklemeTesti(){
        /*
            Selenium'da webdriver ile islemlerimizi yapariz
            webdriver bizim bilgisayarimizdaki dosyalara ulasamaz ve kullanamaz
            Dosya exists islemlerinde Java'dan yararlanip
            dosya yolunu kullanarak islemler yapabiliriz

            dosya yuklemede ise dosya sec butonuna bastigimizda
            bilgisayarimizdaki dosya yapisi acilir
            Biz webdriver ile bilgisayarimizdaki dosya yapisinda islem yapamayacagimiz icin
            chooseFile butonuna sendKeys() ile dosya yolunu yollariz

         */

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.

        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));


        // testlerimizin butun takim uyelerinde calisabilmesi icin
        // dosya yolunu dinamik yapmaliyiz
        // biz bir onceki test'de downloads'a indirdigimiz
        // logo.png'yi yukleyelim

        String dinamikDosyaYolu = System.getProperty("user.home") +   // herkeste farkli olan kisim
                                  "/Downloads/logo.png";              // herkeste ortak olan kisim

        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        //Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement uplodedYaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "File Uploaded!";
        String actualYazi = uplodedYaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(10);
    }

}
