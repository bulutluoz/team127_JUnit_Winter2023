package tests.day11_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void cookitestleri(){
        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSeti = driver.manage().getCookies();

        int siraNo = 1 ;

        for (Cookie each : cookiesSeti
             ) {
            System.out.println(siraNo + "=====> " + each);
            siraNo++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        int expectedMinCookieSayisi = 5;
        int actualCookiesayisi = cookiesSeti.size();
        Assert.assertTrue(actualCookiesayisi > expectedMinCookieSayisi);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookieValue = "USD";
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedCookieValue,actualCookieValue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin

        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        cookiesSeti = driver.manage().getCookies();

        siraNo = 1 ;

        for (Cookie each : cookiesSeti
        ) {
            System.out.println(siraNo + "=====> " + each);
            siraNo++;
        }

        expectedCookieValue = "cikolatali";
        actualCookieValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        // olmayan bir cookie'nin degerini yazdirsak
        System.out.println(driver.manage().getCookieNamed("Boyle bir cookie yok")); // null

        driver.manage().deleteCookieNamed("skin");

        Assert.assertTrue(driver.manage().getCookieNamed("skin") == null);


        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();

        cookiesSeti = driver.manage().getCookies();

        Assert.assertTrue(cookiesSeti.size() == 0);

        ReusableMethods.bekle(2);
    }
}
