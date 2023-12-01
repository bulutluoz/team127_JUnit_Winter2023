package tests.day12_webTables_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcelOtomasyonu {

    @Test
    public void excelOtomasyonTesti() throws IOException {

        String dosyaYolu = "src/test/java/tests/day12_webTables_excelOtomasyon/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        /*
            Bilgisayarimizdaki fiziki bir dosyayi
            kodlarimiza direk eklememiz mumkun degil

            Apache poi verdigimiz dosya yolundaki
            fiziki excel dosyasinda bulunan tum datalari
            fileInputStream objesi sayesinde okuyup
            o bilgileri kullanabileceginiz
            EXCEL dosyasinin KOPYASINI olusturur

            biz de bu kopya excel uzrinde istedigimiz islemleri yapabiliriz

            ONEMLI NOT :
            bu test methodu icinde yaptigimiz tum islemler
            excel uzerinde degil
            36.satirin calistigi anda excel'de varolan bilgiler uzerindedir

            satir ve sutun bilgileri index ile calisir
            yani 0'dan baslar
         */
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        Row ucuncuSatir = sayfa1.getRow(3); // index=3, fiziki olarak 4.satira gider
        Cell ikinciData = ucuncuSatir.getCell(2); // index=2, fiziki olarak 3.dataya gider

        System.out.println(ikinciData); // Cezayir

        // 12.satirda bulunan ulkenin turkce isminin "Azerbaycan" oldugunu test edin

        String actualIstenenUlkeAdi = sayfa1.getRow(11).getCell(2).toString();
        String expectedUlkeAdi = "Azerbaycan";

        Assert.assertEquals(expectedUlkeAdi,actualIstenenUlkeAdi);
    }
}
