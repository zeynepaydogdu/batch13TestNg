package tests.day15;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C1_Senkronizasyon extends TestBase {
/*
synchronization UI icin cok onemlidir.
. beklemeyi yapmazsak no such element exception aliriz
 */
    @Test
    public void test01(){
        driver.get("https://youtube.com");
        driver.findElement(By.xpath("//yt-formatted-string[text()='Music']")).click();
        //TESTBASE deki bekleme suresi kapali old icin test failed olur no suchelement exp verir

        //testbase deki bekleme suresi yani senkronuize acilinca test pass olmasi gerekir
    //senkronizasyonu implictlywait ile saglamis olur her sayfanin acilmasi hemde her bir webelementin
        //lokate i icin 15  saniye bekliyor


         /*
        Senkronizasyon :kodlarimizla test yaptigimiz uygulamamnin uyumlu bir sekilde calismasin saglamak icin yaptigimiz islemlerdir
        Bu uyumu saglamak icin uygulammanin yavas kaldigi durumlarda kodlarimizi bekletmemiz gerekir

        -thread.sleep = javadan gelir dinamik degildir yazilan sure kadar kodlarimizi bekletir
        -implicitly wait=  dinamiktir,test yapacagimiz sayfadaki her bi webelemetin locate edilmesi icin beklenecek maximum
        sureyi belirler globaldir.Belirlenen sureden once locate edilirse ileme devam eder,belirlenen sure icinde locate edemezse
        NOSUCHELEMENTEXCEPTION verir

        Explicitly wait: bir webelementin locate edilmesi icin extra bir sureye ihtiyac oldugunnda kullaniriz
        bunu kullanmak icin once
         -bir wait objesi olusturulur
         -wait.until(ExpectedConditions.istedigimizMethod())visibiltlyof clicableof vb gibi methtlar kullanilir
         Hangisi kullanilmali?
         -Karar vermeden once mutlaka testimizi manuel olarak yapariz
         test steplerinde standart bekleme yeterli ise implictly ile cozeriz,bunun cozemedigi
          durumlarda explictly wait veya thread.sleepkullanabiliriz

         */
    }


}
