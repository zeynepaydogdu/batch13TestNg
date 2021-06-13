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

public class C4_Amazon {
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
       // driver.close();
    }

    @Test
    public void dropDown(){
        driver.get("https://www.amazon.com/");
        // dropdown'i kullanabilmek icin 3 asama yapmamiz gerekir
        // 1.asama---- dropdown'u locate edelim
        WebElement menu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        // 2.asama=== locate ettiigm webelementi kullanarak select objesi olusturacagim
        Select select =new Select(menu);
        List<WebElement> tumKategori=select.getOptions();
        int expectedKategori=45;
        int actualKategori=tumKategori.size();
        Assert.assertEquals(actualKategori,expectedKategori);
        // 3.asama dropdown menusunden istedigimiz option'i secelim
        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

    }
    @Test
    public void books(){
        /*
         1. Kategori menusunden Books secenegini  secin
           2. Arama kutusuna Java yazin ve aratin
           3. Bulunan sonuc sayisini yazdirin
           4. Sonucun Java kelimesini icerdigini test edin
         */
        driver.get("https://www.amazon.com/");
        WebElement menu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(menu);
        select.selectByVisibleText("Books");

        WebElement search =driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Java" + Keys.ENTER);

        WebElement sonucYaz=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYaz.getText());

        Assert.assertTrue(sonucYaz.getText().contains("Java"));
    }
}
