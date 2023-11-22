package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_DropdownMenu extends TestBase {

    @Test
    public void dropdownTesti(){
        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");
        //	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
            // - ilk adim : kullanacagimiz ddm locate edip kaydedelim
        WebElement dogumGunuDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
            // - ikinci adim : bir select objesi olusturalim
            //                 parametre olarak locate etttigimiz ddm'yu yazalim
        Select selectGun = new Select(dogumGunuDdm);
            // -ucuncu adim : olusturdugumuz select objesi ile istenen islemleri yapin

        selectGun.selectByIndex(5);

        //	2. Dogum tarihi ay seçeneğinden visibleText kullanarak Nisan’i secin

        WebElement ayDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDdm);
        selectAy.selectByVisibleText("Nisan");

        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDdm);
        selectYil.selectByVisibleText("1990");

        //  4. Secilen degerleri konsolda yazdirin
        //     Dropdown menude secim yaptiktan sonra
        //     yapilan secimi yazdirmak isterseniz .getFirstSelectedOption().getText() kullaniriz

        System.out.println("Secilen tarih : "+selectGun.getFirstSelectedOption().getText()+
                           " " + selectAy.getFirstSelectedOption().getText()+
                           " " + selectYil.getFirstSelectedOption().getText());

        //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayOpsiyonElementleriList = selectAy.getOptions();

        System.out.println(ReusableMethods.stringListeDonustur(ayOpsiyonElementleriList));
        // [Ay, Ocak, Şubat, Mart, Nisan, Mayıs, Haziran, Temmuz, Ağustos, Eylül, Ekim, Kasım, Aralık]

        //	6. Ay Dropdown menusunun boyutunun 30 olduğunu test edin

        Assert.assertEquals(30, ayOpsiyonElementleriList.size());

        ReusableMethods.bekle(2);
    }
}
