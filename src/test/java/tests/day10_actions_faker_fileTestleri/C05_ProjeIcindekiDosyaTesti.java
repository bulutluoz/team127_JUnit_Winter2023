package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_ProjeIcindekiDosyaTesti {

    @Test
    public void fileExistsTesti(){

        // projemiz icerisinde day10 package'i altinda
        // deneme.txt dosyasinin oldugunu test edin

        String dosyaYolu = "/Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/com.team127_JUnit/src/test/java/tests/day10_actions_faker_fileTestleri/deneme.txt";


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //  Herkeste farkli olan kisim ==> user.dir
        //         /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/com.team127_JUnit
        // Herkeste ayni olan kisim ==> projenin icindeki dosya yolu
        //        /src/test/java/tests/day10_actions_faker_fileTestleri/deneme.txt";

        String dinamikDosyaYolu = System.getProperty("user.dir") +
                                    "/src/test/java/tests/day10_actions_faker_fileTestleri/deneme.txt";


        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

    }


}
