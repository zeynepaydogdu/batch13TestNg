package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseClass;

import java.util.Set;

public class C3_HandleWindows02 extends TestBaseClass {
    /*
        ● https://the-internet.herokuapp.com/windows adresine gidin.
        ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        ● Click Here butonuna basın.
        ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */
    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        SoftAssert softAssert=new SoftAssert();
        WebElement yaziWebElementi=driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        softAssert.assertEquals(yaziWebElementi.getText(),expectedYazi);
        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        softAssert.assertEquals(driver.getTitle(),expectedTitle);


        // yeni bir sayfa acma islemi yapilmadan once varolan sayfanin window handle degerini kaydetmeliyiz
       String ilkSayfaHandleDegeri= driver.getWindowHandle();

        // Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        // click islemi yapilinca yeni sayfaya gecebilmek icin ikinci sayfa handle degerini bulmam lazim
       Set <String> handleSeti= driver.getWindowHandles();

        String ikinciSayfaHandleDegeri="";
        for (String each : handleSeti
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }
        //simdi ikinci sayfaya gecebiliriz
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedIkinciSayfaTitle="New Window";
        softAssert.assertEquals(driver.getTitle(),expectedIkinciSayfaTitle);
        // ayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaYaziWebElementi=driver.findElement(By.tagName("h3"));
        String expectedIkinciSayfaYazisi="New Window";
        softAssert.assertEquals(ikinciSayfaYaziWebElementi.getText(),expectedIkinciSayfaYazisi);
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        softAssert.assertEquals(driver.getTitle(),expectedTitle);
        softAssert.assertAll();
    }
    /*
    TESTBASE
    testbase clasin amaci :her test icin gerekli olan ayarlamalri tekrar tekrar yapmak yerine
    /before ve after methotlarini utulities clasin altindaki testbase clasi altinda olusturuyoruz

    testlerde ihtiyacimiz oldugunda yeniden obje olusturmakla ugrasmamamk icin testbase clasina
    extends yaparak oradaki methodlari inherit ederiz

    TestBase clasi bizim test claslarimizin bulundugu packageden olmadigi icin
    testBase de olusturdugumuz drivera ulasmak icin acces modifieri protected yapiyoruz\
    TestBase clasindan obje olusturulmasini engellemek istersek classi abstrack yapariz

    WINDOWHANDLE
    
    Bir test sirasinda kullandigiiz bir link yeni sekmade acilirsa acilan yeni sekmeye gecebilmek icin
    o sayfanin windowHandle degerine ihtiyacimiz var .Bunun icin 3 adim yapilir
    1)linke tiklamadan once var olan windowun handle degerini alip
     String bir variable kaydederiz
    2)linki tikladiktan sonra elimizde bulunan 2 sayfanin window handle degerlerini
     bir set icine koyariz
    3)ForeachLoop kullanarak setteki herbir Handle degerini alip
    ilk sayfanin handle degeri ile karsilstiriiz
    ilk sayfanin handle degerine esit olmayan deger 2inci sayfanin handle degeridir
    bu sekilde elde ettigimiz ikini sayfanin handle degerini kullanarak
    o sayfaya switch yani gecis yapmis oluruz.

     */
}
