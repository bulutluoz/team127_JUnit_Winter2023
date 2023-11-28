package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_Actions extends TestBase {

    @Test
    public void sagClicktesti(){
        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
        ReusableMethods.bekle(1);
        //2- “DGI Drones” uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement dgiDronesElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(dgiDronesElementi).perform();
        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //4- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

    }

}
