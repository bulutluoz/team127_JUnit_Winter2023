package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C06_KontrolsuzCokluWindowKullanimi extends TestBase {

    @Test
    public void test01(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h2"));
        String expectedYazi = "Add/Remove Elements";
        String actualYazi = yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.linkText("Electronics Products")).click();

        /*
            Driver bir webelement'e click yapildiginda
            ayni sayfada acilacagini varsayar

            eger tiklanan element yeni bir tab veya window aciyorsa
            bu durumda driver'i yeni acilan tab/window'a bizim gondermemiz gerekir

            bizim driver'i baska bir tab/window'a yollamak icin 2 yolumuz var
            1- ya kontrollu yeni bir tab/window acarak
            2- kontrolsuz acilan tab/window'un Window handle degerini kullanarak

            Burada Java'dan yaralanarak mini bir bulmaca cozmeliyiz
         */

        String ilkSayfaWHD = driver.getWindowHandle();
        Set<String> wHDSeti = driver.getWindowHandles();
        String ikinciSayfaWhd="";
        for (String each : wHDSeti
             ) {

            if (!each.equals(ilkSayfaWHD)){
                ikinciSayfaWhd = each;
            }
        }

        driver.switchTo().window(ikinciSayfaWhd);

        //● Electronics sayfasinin acildigini test edin

        String expectedTitleIcerik = "Electronics";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        //● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));
        String sonucSayisiStr = sonucYaziElementi.getText().replaceAll("\\D",""); //"16"
        int actualSonucSayisi= Integer.parseInt(sonucSayisiStr);

        int expectedUrunSayisi = 16;

        Assert.assertEquals(expectedUrunSayisi,actualSonucSayisi);

        //● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilkSayfaWHD);

        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        System.out.println(wHDSeti);

        ReusableMethods.bekle(3);
    }
}
