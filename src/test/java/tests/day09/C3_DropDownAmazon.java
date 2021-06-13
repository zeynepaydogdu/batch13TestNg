package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C3_DropDownAmazon {
    /*
       ● https://www.amazon.com/ adresine gidin.
       - Test 1
           Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
       -Test 2
           1. Kategori menusunden Books secenegini  secin
           2. Arama kutusuna Java yazin ve aratin
           3. Bulunan sonuc sayisini yazdirin
           4. Sonucun Java kelimesini icerdigini test edin
    */
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void kategoriSayisiTesti(){
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        driver.get("https://www.amazon.com/");
        WebElement acilirListe=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(acilirListe);
        List<WebElement> tumOpsiyonlarListesi=select.getOptions();
        int expectedOpsiyonSayisi=45;
        int actualOpsiyonSayisi= tumOpsiyonlarListesi.size();
        Assert.assertEquals(actualOpsiyonSayisi,expectedOpsiyonSayisi,"beklenen sayi yanlis");
    }
    @Test
    public void javaKitabiTesti(){
        /*
        Test 2
            1. Kategori menusunden Books secenegini  secin
            2. Arama kutusuna Java yazin ve aratin
            3. Bulunan sonuc sayisini yazdirin
            4. Sonucun Java kelimesini icerdigini test edin
         */
        driver.get("https://www.amazon.com/");
        WebElement acilirListe=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(acilirListe);
        select.selectByVisibleText("Books");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi.getText());
        Assert.assertTrue(sonucYazisiElementi.getText().contains("Java"));

    }
    //GECEN DERS TEKRARI
    //priority: testng ile gelen bir yeniliktirJunit te testler belli bir siraya gore calismaz randomdur
    //ama testng de alfabetik siraya gore alisir
    //eger alfabetik siralama disinda ozel bir siralama yapmak istersek priorty ile test methotlarini siralayabiliriiz
    //priorty sirasi  en kucuk olan once calisir
    //hem priorty olan hem olmayan testler varsa once priorty olmayan calisir
    //sonra priorty siralamasi devreye girer.


    //dropdown: webelementlerini handle etmek icin 3 adim atmamiz gerekiyor
    //1. adim = dropdown'i locate etmek
    //2. adim = locate ettigimiz webelementi parametre olarak kullanip select objesi olusturmak
    //3. adim = select objesini kullanarak 3 yontemle istedigimiz optionu secebiliriz
    //1 )selectbyINDEX  2)selectbyVALUE  3)visibletext

    //uyari:dropdown webelementi genelde html tag olarak select i kullanir

    //Eger tum opsiyonlari testimizde kullanmak istiyorsak webelementlerden olusan bir liste olustup
    //opsiyonlari bu listeye kaydedebiliriz.Bu islem icin getoptions() methodu kullanilr
    //Eger select objesi ile bir opsiyonu secersek sectigimiz opsiyonu yazdirmak icin
    // select.getFirstSelectedOption() methodu kullanilir
    //testng varsa junit kullanmaya gerek kalmamistir
    //testng ve junit kutuphanelerinin bir projede ayni zamanda kullanilmasi tavsiye edilmez


}
