package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class C3_SoftAssertTest {
    /*
            Yeni bir Class Olusturun : D10_SoftAssertTest
        1. “http://zero.webappsecurity.com/” Adresine gidin
         2. Sign in butonuna basin
         3. Login kutusuna “username” yazin
         4. Password kutusuna “password.” yazin
         5. Sign in tusuna basin
         6. Pay Bills sayfasina gidin
         7. “Purchase Foreign Currency” tusuna basin
         8. “Currency” drop down menusunden Eurozone’u secin
         9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
         10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
     */
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test01(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.className("icon-signin")).click();
        // 3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
        // 4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        // guvenlik icin
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        // 6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();
        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement acilirListe=driver.findElement(By.id("pc_currency"));
        Select select=new Select(acilirListe);
        select.selectByVisibleText("Eurozone (euro)");
        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String actualSeciliOpsiyon= select.getFirstSelectedOption().getText();
        String expectedValue="Eurozone (euro)";
        softAssert.assertEquals(actualSeciliOpsiyon,expectedValue);

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        List<WebElement> tumOpsiyonlar= select.getOptions();
        List<String> tumOpsiyonlarString = new ArrayList<String>();
        for (WebElement w:tumOpsiyonlar
        ) {
            tumOpsiyonlarString.add(w.getText());
        }
        List<String> expectedOptionsList = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)", "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)", "Singapore (dollar)","Thailand (baht)");
        softAssert.assertEquals(tumOpsiyonlarString,expectedOptionsList,"options listesi actual ile uyusmuyor");
        softAssert.assertAll();
    }
    //ONCEKI DERS  TEKRARI

    //1) DependsOnMethods= test methotlarini birbirine baglar.Baglanilan test calisip PASS olursa
    //bagli olan testte calisir,baglanilan test calismaz veya failed olursa baglanan test CALISMAZ ignored olur
    //2)(Hard) Asser = Kod yazilirken Hard yazilmaz ama sadece Assert ile baslar
    //ozelligi; Assert edilen durumlardan bir tanesi failed olursa execution  durur.Sonraki
    //kodlar calismaz bu nun pozitif tarafi problem bulunur bulunmaz bize rapor eder bizde duzeltiriz
    //negatif tarafi ise hata sayisi birden coksa her seferinde bir hatayi verir biz onu
    //duzeltip calistirinca sonraki hatayi verir

    //SoftAssert (verification) : Test edilen durumlarin PASS veya FAILED olmasina bakmaksizin tum assertionlari
    //gozden gecirir ve en sonda kac assertion PASS kac tanesi Failed onu rapor  eder
    //3 Adimda calisir
    //1) Softassertion objesi olustur  2) tum assertionlari yap
    //3)soft assert.assertAll ile assertionlari raporla
    //Eger bizim için test edin derlerse hardAssertion ama
    // verification diyorlarsa ozaman soft assert yapıyoruz


    //allert
    /*
    - JS Alert'unun 3 cesidi vardir.
    Alert sayfada acildiginda inceleme yapilamaz ve biz alert'u handle edene kadar bekler.
            1) Sadece "Tamam" secenegine tiklanabilen.
            2) JS Alert'unde "Tamam" veya "Iptal" butonu cikan.
    Tamam'a tiklarsak arkada baska bir kod calisir.
    Iptal'e basarsak bambaska bir kod calisir.
            3) Icerisine yazi yazilan bir kutucuk ile alert veren.
    Burada iptal'e basarsak null deger gonderir ve o calisir, uyari verebilir bos girilemeyecegine dair.
    Eger yazi kutucuguna deger girersek girdigimiz degere gore kodu yapilandirir.
    3 cesit alllert vardir
    ilk is js mi html allertmi onu anlamak
    js mi html mi anlamak icin sag tik yapamiyorsan js allerrttir
    tmm deyip sag tiki calistirabilirsin

     */



}
