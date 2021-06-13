package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_SoftAssertion {

    // "Selenium ogrenmek cok zevkli " cumlesinde asagidaki testleri yapiniz
    //-cumle ogrenmek iceriyor
    //-cumle java icermiyor
    //-cumle 4 kelimeden olusuyor
    //-cumledeki karakter sayisi 25 mi test ediniz

    WebDriver driver;
    String cumle="Selenium ogrenmek cok zevkli";

    @Test
    public void hardAssertion(){
        Assert.assertTrue(cumle.contains("ogrenmek"));
        System.out.println("1");
        Assert.assertFalse(cumle.contains("java"));
        System.out.println("2");

        //-cumle 4 kelimeden olusuyor
        String kelimeler[]=cumle.split(" ");
        Assert.assertEquals(kelimeler.length,4);
        System.out.println("3");

        //-cumledeki karakter sayisi 25 mi test ediniz
        String karakterler[]=cumle.split(" ");
        //execution burada durar ilk hatada durur hardassertion oldugu icin
        //ve bunlarin hicbirini test etmez ama 28 yapinca calisir ve test eder
        Assert.assertEquals(karakterler.length,25);
        System.out.println("4");

    }

    @Test
    public void softAssertionTesti(){
        //soft assert clasindan bir obje olusturalim
        SoftAssert softAssert=new SoftAssert();

        //-cumle ogrenmek iceriyor
        softAssert.assertTrue(cumle.contains("ogrenmek"));
        System.out.println("1");

        //-cumle java icermiyor
        softAssert.assertFalse(cumle.contains("Java"));
        System.out.println("2");

        //-cumle 4 kelimeden olusuyor
        String kelimeler[]=cumle.split(" ");
        Assert.assertEquals(kelimeler.length,4);
        System.out.println("3");


        String karakterler[]=cumle.split(" ");
        Assert.assertEquals(karakterler.length,25,"karakter sayisi testi failed");
        System.out.println("4");
        //burda faild olmasina ragmen calisti sonra bunu rapor etti


        softAssert.assertAll();//soft assert objesini olusturur olusturmaz durumun raporlanmasi icin ikinci adim olarak
        //hemen bunun olusturulmasi lazim


        //asserAll gorundugunde softassert test bitti olaarak algilar ve durumu rapor eder
        //tum testLer pass olduysa calismaya devam eder
        //yapilan soft assertlerden bir tanesi bile failed olursa bu satirda execute durur
        System.out.println("bu yazi consolda cikar mi?");//tum testler pass olursa yazi konsolda cikar
    }
}
