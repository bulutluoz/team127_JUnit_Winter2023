package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_ActionsAsagiyaInme extends TestBase {

    @Test
    public void iFrameTesti(){
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //4- videoyu izlemek icin Play tusuna basin
        // play butonu iframe icinde oldugundan, once iframe'e gecis yapalim

        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeElementi);
        ReusableMethods.bekle(1);

        driver.findElement(By.xpath("//button[@title='Play']")).click();
        //5- videoyu calistirdiginizi test edin
        WebElement kontrolElementi = driver.findElement(By.xpath("//*[@*='ytp-play-button ytp-button']"));
        ReusableMethods.bekle(1);
        Assert.assertTrue(kontrolElementi.isDisplayed());

        ReusableMethods.bekle(5);
    }
}
