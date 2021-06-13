package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseClass;

import static org.testng.Assert.*;

public class C4_UploadFile extends TestBase {
    /*
    1.Tests packagenin altina bir class oluşturun : D14_UploadFile
2.https://the-internet.herokuapp.com/upload adresine gidelim
3.chooseFile butonuna basalim
4.Yuklemek istediginiz dosyayi secelim.
5.Upload butonuna basalim.
6.“File Uploaded!” textinin goruntulendigini test edelim.
     */
    @Test
    public void uploadFile() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        // 1- dosya sec butonunu locate edin
        WebElement dosyaSecButonu=driver.findElement(By.id("file-upload"));
        // 2- Yuklemekistedigimiz dosyanin dosya yolunu kaydedin
        String dosyaYolu= System.getProperty("user.home")+"\\Desktop\\FLOWER.jpg";
        // 3- SendKeys ile dosyayi dosyasec butonuna yollayin
        dosyaSecButonu.sendKeys(dosyaYolu);
        Thread.sleep(5000);
        // Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedYazisiElementi=driver.findElement(By.tagName("h3"));
        assertTrue(fileUploadedYazisiElementi.isDisplayed());
        /*

       -  Eger bir sayfada birden fazla Assert.assertTrue yapilacaksa , bastaki ASSERT. yazisini sileriz
             assertTrue(uploadedText.isDisplayed()); == gibi
       -  ardindan CTE veren kismin ustune gidip ALT+ENTER yapip import edersek eger bir sonraki assert islemleriin basina
             surekli Assert. yazmak zorunda kalmayiz.
       -  Eger ayni sayfada assertTrue,assertFalse,assertEquals yapilacak ise ,
            import kismina gidilir
            import org.testng.Assert; yazan kismi
            import org.testng.*; == ile update edilir
     */
        // birden fazla Assert yapacaksak her seferinde basın assert yazmamak icin
// basta ki assert u silip ilgili dosyayı import edebiliriz
// Assert ı sil  alt+enter yap
// sofAssert olmaz cunku obj uz ulasıyoruz
// bunları static old icin yapabiliyoruz.
// nereden anladık; Assert.assert ulasabildiğimiz icin..
        assertTrue(fileUploadedYazisiElementi.getText().contains("File"));
        assertFalse(fileUploadedYazisiElementi.getText().contains("Mehmet"));
        assertEquals(fileUploadedYazisiElementi.getText(),"File Uploaded");

    }

}
