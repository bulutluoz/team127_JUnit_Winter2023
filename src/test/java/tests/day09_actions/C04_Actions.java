package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_Actions extends TestBase {

    @Test
    public void sagClickTesti(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        ReusableMethods.bekle(1);
        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement cizgiliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();
        ReusableMethods.bekle(2);
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlerytYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlerytYazisi,actualAlertYazisi);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(1);
        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();
        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        ReusableMethods.bekle(1);
        driver = ReusableMethods.titleIleSayfaDegistir(driver,"Elemental Selenium | Elemental Selenium");

        ReusableMethods.bekle(2);
        WebElement h1TagYaziElementi = driver.findElement(By.tagName("h1"));

        String expectedYazi = "Make sure your code lands";
        String actualH1Yazi = h1TagYaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualH1Yazi);

    }
}
