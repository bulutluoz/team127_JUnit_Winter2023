package tests.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C08_KullaniciOlusturma extends TestBase {

    @Test
    public void kullaniciOlusturmaTesti(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[text()='Account'])[1]")).click();
        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        WebElement fistNameKutusu = driver.findElement(By.xpath("//*[@id='firstName']"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.click(fistNameKutusu)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("Bulut")
                .sendKeys(Keys.TAB)
                .sendKeys("bulut@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();

        driver.findElement(By.id("btn-submit-form")).click();

        //5- Kaydin olusturuldugunu test edin
        //   Kayit olusturulunca bizi signIn sayfasina yonlendiriyor
        //   Kaydin olusturuldugunu test etmek icin
        //   girdigimiz bilgilerle login olabildigimizi test edelim

        WebElement emailKutusu= driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        WebElement signInButonu = driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys("bulut@gmail.com");
        passwordKutusu.sendKeys("12345");
        signInButonu.click();

        WebElement logoutLinki = driver.findElement(By.xpath("//span[text()='Logout']"));

        Assert.assertTrue(logoutLinki.isDisplayed());

        ReusableMethods.bekle(2);
        logoutLinki.click();

        ReusableMethods.bekle(5);
    }
}
