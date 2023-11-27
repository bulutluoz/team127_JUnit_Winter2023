package tests.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_DragAndDrop extends TestBase {

    @Test
    public void dragAndDropTesti(){

        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");
        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement acceptableElementi = driver.findElement(By.id("draggable2"));
        WebElement tasinacakHedefAlan = driver.findElement(By.id("droppable2"));

        Actions actions = new Actions(driver);

        ReusableMethods.bekle(1);
        actions.dragAndDrop(acceptableElementi,tasinacakHedefAlan).perform();
        ReusableMethods.bekle(1);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedAlanYazisi = "Dropped!";
        String actualAlanYazisi = tasinacakHedefAlan.getText();
        Assert.assertEquals(expectedAlanYazisi,actualAlanYazisi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusableMethods.bekle(1);
        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement notAcceptableElementi = driver.findElement(By.id("draggable-nonvalid2"));
        tasinacakHedefAlan = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableElementi,tasinacakHedefAlan).perform();
        //6- “Drop here” yazisinin degismedigini test edin

        expectedAlanYazisi = "Drop Here";
        actualAlanYazisi = tasinacakHedefAlan.getText();
        Assert.assertEquals(expectedAlanYazisi,actualAlanYazisi);

        ReusableMethods.bekle(5);
    }
}
