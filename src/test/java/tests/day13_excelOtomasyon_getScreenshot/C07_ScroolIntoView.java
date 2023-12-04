package tests.day13_excelOtomasyon_getScreenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C07_ScroolIntoView extends TestBase {

    @Test
    public void newProductTesti(){

        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        // Best Sport Shoes bolumu gorununceye kadar asagi inin

        /*
        Bu yontem ile asagiya inebildik
        AMMA bilgisayardan bilgisayara cozunurluk degisecegi icin
        bu method her bilgisayar icin ozel ayarlanmali


        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

         */


        WebElement bestSportShoesElementi = driver.findElement(By.xpath("(//p[@class='blog-heading'])[2]"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",bestSportShoesElementi);
        // linki tiklayin

        ReusableMethods.bekle(2);

        bestSportShoesElementi.click();
        //javascriptExecutor.executeScript("arguments[0].click();",bestSportShoesElementi);

        // h1 taginda "Best Sport Shoes For Multi Gender" yazdigini test edin

        String expectedYazi = "Best Sport Shoes For Multi Gender";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        javascriptExecutor.executeScript("alert('yasasinnnn');");

        ReusableMethods.bekle(5);
    }

}
