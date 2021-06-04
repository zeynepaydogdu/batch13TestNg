package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.testng.annotations.*;// yukardaki son ikinin yerine ve daha fazlasina bu kullaniliir
import java.util.concurrent.TimeUnit;

public class C1_Priority {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("before methot calisti");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        System.out.println("ater methot calisti");
    }

    @Test(priority = 10)
    public void test01(){
        System.out.println("test 01 calisti");
    }
    @Test(priority = 5)
    public void ikincitest(){
        System.out.println("ikinci test calisti");
    }
    @Test(priority = 2)
    public void yazdimTest(){
        System.out.println("yazdim test calisti");
    }

    //priority sayisi belirtmeden once alfabetik siraya gore calisir
    //priority numarasi koyunca en kucuk sayidan baslayarak calisir
    //ikisine prority yazip birine yamazsam numarasiz olan once calisir sonra numaralamaya gore devam eder

    /*
    1- PRIORITY YAZILMAYAN METHODLAR EN BASTA CALISIR
    2- PRIORITY YAZILAN METHODLAR ISE ; VERILEN ONCELIK SIRASINA GORE CALISIR
    3- EGER HERHANGI BIR PRIORITY VERILMEDIYSE ALFABETIK SIRAYA GORE CALISIR.
 */
}
