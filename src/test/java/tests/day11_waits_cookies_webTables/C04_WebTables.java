package tests.day11_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void webTabletesti(){
        /*
            Klasik HTML kodlari kullanilarak olusturulan web tablolarinda
            istedigimiz cell(hucre) deki data'ya ulasmak icin
            sadece taglari kullanarak tablo/body/satir/data siralamasi kullaniriz

            1- Eger 1 of 1 bilgisine ulasabiliyorsak tum yolu yazmamiza gerek yok
            2- Eger sadece child HTML taglara bakmak isteniyorsa /
               child HTML taglarla birlikte grindChild taglara da bakmak istersek // kullaniriz
            3-
         */

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");
        //2.Web table tum body’sini yazdirin
        WebElement bodyElementi = driver.findElement(By.xpath("//table/tbody"));
        System.out.println(bodyElementi.getText());
        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedIcerik = "Comfortable Gaming Chair";
        String actualBody = bodyElementi.getText();
        Assert.assertTrue(actualBody.contains(expectedIcerik));
        //4.Web table’daki satir sayisinin 5 oldugunu test edin

        List<WebElement> satirElementleriListesi = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriListesi.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5.Tum satirlari yazdirin
        System.out.println("====Tum satirlar===");

        // tum listeyi String'lerden olusan listeye cevirip yazdirabiliriz
        List<String> satirListesiStr = ReusableMethods.stringListeDonustur(satirElementleriListesi);
        System.out.println(satirListesiStr);

        // veya satir webelementlerini bir for loop ile yazdirip, basina aciklama da ekleyebiliriz

        for (int i = 0; i <satirElementleriListesi.size() ; i++) {

            System.out.println(i+1 + ". satir  : " + satirElementleriListesi.get(i).getText());
        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        /*
            Web table'da sutun yapisi yoktur
            satirlar ve o ssatirlardaki datalar vardir

            sutun sayisini elde etmek icin
            herhangi bir satirdaki data sayisina bakabiliriz
         */
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//thead/tr/th"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = baslikElementleriList.size();

        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        //7. 3.sutunu yazdirin
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println("======3.Sutun elementleri=====");

        // for loop ile yazdiralim

        for (int i = 0; i < ucuncuSutunElementleriList.size(); i++) {

            System.out.println(i+1 + ". satirdaki 3. sutun : " + ucuncuSutunElementleriList.get(i).getText());
        }

        //8. Tablodaki basliklari yazdirin
        //   list olarak yazdiralim

        List<String> baslikListesiStr = ReusableMethods.stringListeDonustur(baslikElementleriList);

        System.out.println("Basliklar  : " + baslikListesiStr);

        //9.Satir ve sutun sayisini parametre olarak alip,
        //  hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(getCellData(1, 3)); // $399.00

        System.out.println(getCellData(2, 1)); // Samsung White Smart Watch

        System.out.println(getCellData(4, 2)); // Furniture

        //10.  4.satirdaki category degerinin "Furniture" oldugunu test edin

        String expectedCategory = "Furniture";
        String actualCategory = getCellData(4,2);

        Assert.assertEquals(expectedCategory,actualCategory);
    }

    public String getCellData(int satirNo, int sutunNo){
        //      //tbody/tr[4]/td[3]

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenCellDataElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenCellDataElementi.getText();

    }
}
