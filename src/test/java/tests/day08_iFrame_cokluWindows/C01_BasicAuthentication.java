package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {

    @Test
    public void basicAuthenticationTesti(){

        //1- Bir class olusturun : BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin
        // driver.get("https://testotomasyonu.com/basicauth");
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower
        //

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
        //4- Basarili sekilde sayfaya girildigini dogrulayin

        WebElement basariliGirisyaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "Congratulations! You are logged in as: membername";
        String actualYazi = basariliGirisyaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

    }

}
