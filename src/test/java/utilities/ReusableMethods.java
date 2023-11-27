package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> stringListeDonustur(List<WebElement> elementlerListesi){

        List<String> stringlerListesi = new ArrayList<>();

        for (WebElement each : elementlerListesi
             ) {

            stringlerListesi.add(each.getText());
        }

        return stringlerListesi;
    }

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver titleIleSayfaDegistir(WebDriver driver , String hedefSayfaTitle){

        Set<String> tumWhdSeti = driver.getWindowHandles();

        for (String each : tumWhdSeti
             ) {

            String eachTitle = driver.switchTo().window(each).getTitle();
            if (eachTitle.equals(hedefSayfaTitle)){
                return driver;
            }
        }

        return driver;
    }

    public static String ilkSayfaWhdIleIkinciSayfaWhdBul(WebDriver driver, String ilkSayfaWhd) {

        Set<String > tumWhdSeti = driver.getWindowHandles();

        tumWhdSeti.remove(ilkSayfaWhd);

        for (String each:tumWhdSeti
             ) {
            return each;
        }

        return null;
    }
}
