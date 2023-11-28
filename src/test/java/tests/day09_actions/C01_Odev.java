package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_Odev extends TestBase {

    /*
        Kontrolsuz bir tab/window acildiginda
        eger yeni acilan tab/window'un title degeri biliniyorsa
        driver'i acilan sayfaya geciren bir method olusturun

        input : yeniTitle , Test Otomasyonu - Electronics

     */

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        String ilkSayfaWhd= driver.getWindowHandle();
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
        ReusableMethods.bekle(2);
        driver.findElement(By.linkText("Electronics Products")).click();
        //● Electronics sayfasinin acildigini test edin

        driver = ReusableMethods.titleIleSayfaDegistir(driver,"Test Otomasyonu - Electronics");

        //● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
        String sonucSayisiStr = sonucYaziElementi.getText().replaceAll("\\D","");// "16"
        int actualSonucSayisi = Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayisi = 16;

        Assert.assertEquals(expectedSonucSayisi,actualSonucSayisi);
        ReusableMethods.bekle(2);
        //● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilkSayfaWhd);
        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);
    }
}
