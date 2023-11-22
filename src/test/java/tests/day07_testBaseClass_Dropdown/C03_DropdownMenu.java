package tests.day07_testBaseClass_Dropdown;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

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

        //	2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        //	4. Ay dropdown menüdeki tum değerleri(value) yazdırın
        //	5. Ay Dropdown menusunun boyutunun 30 olduğunu test edin

        ReusableMethods.bekle(5);
    }
}
