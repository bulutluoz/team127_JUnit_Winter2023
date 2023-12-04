package tests.day13_excelOtomasyon_getScreenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_AramaTestiWebelementScreenshot extends TestBase {

    @Test
    public void urunDogrulamaTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // shoes icin arama yaptirin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("shoes" + Keys.ENTER);

        // arama sonuclarindan ilk urunu tiklayin

        driver.findElement(By.xpath("(//div[@class='product-box my-2  py-1'])[1]"))
                .click();
        // acilan urun sayfasinda, urun isminde case sensitive olmadan shoe gectigini test edin

        WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "shoe";
        String actualIsimKucukHarf = urunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualIsimKucukHarf.contains(expectedIsimIcerik));
        ReusableMethods.bekle(3);
        // urun isim elementinin fotografini cekip kaydedin
        ReusableMethods.istenenWebelementScreenshot(urunIsimElementi);


    }
}
