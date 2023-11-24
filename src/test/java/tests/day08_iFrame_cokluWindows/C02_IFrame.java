package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_IFrame extends TestBase {

    @Test
    public void test01(){
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement anIframeYaziElementi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(anIframeYaziElementi.isEnabled());
        System.out.println(anIframeYaziElementi.getText());
        //	- Text Box’a “Merhaba Dunya!” yazin.

        /*
            Text box bir iframe'in icinde
            iframe'in icinde olan elementlere ulasabilmek icin
            once iframe'e gecis yapmalisiniz

            iframe'e gecis yapabilmek icin
            - once iframe'i bir webelement olarak locate edin
            - switchTo() ile iframe'e gecin

            iframe'e gecis yaparsaniz
            driver orada kalir
            yeniden anasayfa ile ilgili bir islem yapmak isterseniz
            driver'i yeniden anasayfaya gecirmelisiniz

            driver.switchTo().parentFrame(); eger ic ice birden fazla iframe varsa
                                             bir ustteki iframe'e gecis yapar
            driver.switchTo().defaultContent(); direk anasayfaya gecer

         */

        WebElement iFrameElementi = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBoxKutusu = driver.findElement(By.tagName("p"));
        textBoxKutusu.clear();
        textBoxKutusu.sendKeys("Merhaba Dunya");
        //	- TextBox’in altinda bulunan “Elemental Selenium”
        //    linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        // driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

        WebElement elementalSeleniumElementi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());

        System.out.println(elementalSeleniumElementi.getText());

        ReusableMethods.bekle(3);
    }
}
