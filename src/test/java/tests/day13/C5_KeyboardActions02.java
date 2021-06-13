package tests.day13;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C5_KeyboardActions02 extends TestBase {
    /*
        1- Bir Class olusturalim D14_KeyboardActions2
        2- https://html.com/tags/iframe/ sayfasina gidelim
        3- video’yu gorecek kadar asagi inin
        4- videoyu izlemek icin Play tusuna basin
        5- videoyu calistirdiginizi test edin
     */
    @Test
    public void test01(){
        // 2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        //4- videoyu izlemek icin Play tusuna basin
        WebElement iFrame=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        //5.
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='html5-video-player " +
            "ytp-exp-bottom-control-flexbox ytp-title-enable-channel-logo ytp-embed ytp-embed-playlist ad-created playing-mode ytp-autohide']")).isDisplayed());

        //Action Class :klavye ve mouse le yapabildigimiz butun islemlerin otomasyon ile
        //yapmammiz icin hazirlanmistir
        /*
        2 ye ayiriyorduk
        1)mause base actions :mause ile yapilan islemler
        *context click =sag klik
        *drag and drop= surukle birak
        *click and hold=tikla ve bekle
        *double click = iki defa tikla
        *move to element=webelemente git
        2)keyboard base actions: klavye ile yapilan islemler
        *sendKeys=parametre olarak string bir deger verilirse o stringi ilgili webelementine yollar,
        parametre olarak klavyeden bir key kullanilirsa orn keys enter gibi o tusa bir kez basar
        *keys down =  ise parametre olarak girilen tusa KeysUp denene kadar basili tutar
        keysUp basili tututlan tustan elimizi cekmisiz gibi o tusu basili olamaktan cikarir

        Actions clasindaki methotlari kullanmak icin 3 adim atmamliyiz
        1) Action clasindan obje olustirmak ,parametre olarak driveri girmemiz gerekir
        2)islem yapmak istedigimiz Webelementi locate etmek
        3)locate ettigimiz web elementini kullanarak actions classindan ilgili methotlari
        kullanmak


        NOT: Actions objesini yadiktan sonra istedigimiz KADAR METHODU KULLANABILIRIZ

         Onemli olan konu en sonda .perform() kullanmamizdr
         */


    }



}
