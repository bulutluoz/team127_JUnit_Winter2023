package tests.day08_iFrame_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_CokluWindowKullanimi extends TestBase {

    @Test
    public void test01(){

        // biz driver ile yaptigimiz tum islemlerde
        // ayni window'da calistik
        // driver bu sebeple yaptigimiz her islemi
        // ayni window icerisinde arastirir
        // isterseniz siz yeni bir tab veya window olusturabilirsiniz

        driver.get("https://www.testotomasyonu.com");
        System.out.println(driver.getWindowHandle());

        ReusableMethods.bekle(2);

        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle());
        ReusableMethods.bekle(2);

        driver.navigate().back();
        System.out.println(driver.getWindowHandle());
        ReusableMethods.bekle(2);

        // yeniden test otomasyonu sayfasindayiz
        // electronics linkini tiklayalim

        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        System.out.println(driver.getWindowHandle());
        ReusableMethods.bekle(2);





    }
}
