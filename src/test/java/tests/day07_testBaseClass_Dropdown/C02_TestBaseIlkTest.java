package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_TestBaseIlkTest extends TestBase {

    @Test
    public void aramaTesti(){

        // testotomasyonu.com anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi= driver.findElement(By.className("product-count-text"));

        String aramaSonucSayisiStr = aramaSonucElementi.getText().replaceAll("\\D","");

        int aramaSonucSayisi = Integer.parseInt(aramaSonucSayisiStr);

        Assert.assertTrue(aramaSonucSayisi > 0);
        ReusableMethods.bekle(2);

    }
}
