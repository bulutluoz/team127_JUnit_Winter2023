package tests.day10_actions_faker_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_FacebookKullaniciOlusturma extends TestBase {

    @Test
    public void facebookTesti(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Cookies kabul edin
        driver.findElement(By.xpath("//*[@data-cookiebanner='accept_button']")).click();
        ReusableMethods.bekle(2);
        //3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@*='open-registration-form-button']")).click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        WebElement firstnameKutusu = driver.findElement(By.xpath("//*[@name='firstname']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String email =faker.internet().emailAddress();

        actions.click(firstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("20")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();


        //5- Kaydol tusuna basalim
        driver.findElement(By.name("websubmit")).click();

        ReusableMethods.bekle(15);
    }

}
