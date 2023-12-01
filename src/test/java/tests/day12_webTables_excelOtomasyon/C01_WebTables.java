package tests.day12_webTables_excelOtomasyon;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01(){
        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");
        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//div[@role='hdata']"));
        // bu liste webelementlerden olustugu icin hemen yazdiramayiz
        List<String> baslikYazilariList = ReusableMethods.stringListeDonustur(baslikElementleriList);
        System.out.println("Basliklar : " + baslikYazilariList);
        //  3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " + baslikYazilariList.get(2));
        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tabloDataElementleriList = driver.findElements(By.xpath("//*[@role='tdata']"));
        List<String> tabloDataYazilarList = ReusableMethods.stringListeDonustur(tabloDataElementleriList);
        System.out.println("Tum tabloda bulunan datalar : " + tabloDataYazilarList);
        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki data sayisi : " + tabloDataElementleriList.size());
        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("Tablodaki urun satirlari sayisi : " + satirElementleriList.size());
        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi : " + baslikElementleriList.size());
        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));
        List<String > ucuncuSutunYaziListesi = ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList);

        System.out.println("3. Sutun : " + ucuncuSutunYaziListesi);
        //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin

        // bir loop ile her bir satiri tek tek inceleyelim
        // kategori degeri (yani 2.data) Furniture olan satirdaki
        // fiyat degerini(yani 3.data) yazdiralim
        String satirdakiKategoriXpath ="";
        String satirdakiFiyatXpath = "";

        for (int i = 1; i <= satirElementleriList.size() ; i++) {

            // i. satirdaki kategori elementinin locate'i

            satirdakiKategoriXpath = "((//*[@role='trow'])[" + i + "]/*[@role='tdata'])[2]";
            satirdakiFiyatXpath = "((//*[@role='trow'])[" + i + "]/*[@role='tdata'])[3]";
            if (driver.findElement(By.xpath(satirdakiKategoriXpath)).getText().equals("Furniture")){

                System.out.println("Istenen urunun fiyati : " +
                        driver.findElement(By.xpath(satirdakiFiyatXpath)).getText());
            }

        }

        //10. Bir method olusturun, satir ve sutun sayisini girdigimde bana datayi yazdirsin

        istedenHucredekiDatayiYazdir(2,3); // Istenen hucredeki data : $399.00
        istedenHucredekiDatayiYazdir(1,2); // Istenen hucredeki data : Electronics

        // yukardaki gorevi method'u kullanarak yapalim

        // Tabloda " Category" si Furniture olan urunun fiyatini yazdirin

        String satirdakiKategoriDegeri ="";
        String satirdakiFiyatDegeri="";

        for (int i = 1; i <=satirElementleriList.size() ; i++) {

            satirdakiKategoriDegeri = istedenHucredekiDatayiDondur(i,2);
            satirdakiFiyatDegeri = istedenHucredekiDatayiDondur(i,3);

            if (satirdakiKategoriDegeri.equals("Furniture")){
                System.out.println("Kategorisi Furniture olan urun fiyati : "+ satirdakiFiyatDegeri);
            }
        }

        ReusableMethods.bekle(2);
    }

    public void istedenHucredekiDatayiYazdir(int satirNo, int sutunNo){

        // ((//*[@role='trow'])[3]/*[@role='tdata'])[3]

        String dinamikXpath = "((//*[@role='trow'])[" + satirNo + "]/*[@role='tdata'])[" + sutunNo + "]";

        System.out.println("Istenen hucredeki data : " +
                driver.findElement(By.xpath(dinamikXpath)).getText());
    }


    public String istedenHucredekiDatayiDondur(int satirNo, int sutunNo){

        // ((//*[@role='trow'])[3]/*[@role='tdata'])[3]

        String dinamikXpath = "((//*[@role='trow'])[" + satirNo + "]/*[@role='tdata'])[" + sutunNo + "]";


                return driver.findElement(By.xpath(dinamikXpath)).getText();
    }

}
