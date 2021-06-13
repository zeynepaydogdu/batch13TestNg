package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class  TestBase {

    //olusturdugumuz driver i farkli packagelerden kullanabilmek icin
    //acces modifieri PROTECTED yapariz ki farkli backageler ve classlar kullanabilsin

   protected WebDriver driver;

    // public : herkes ulasabilir
    // protected : ayni package veya child class
    // default ( bir sey yazmayinca da default kabul edilir) : package private
    // private : sadece class icinde kullanabiliriz

    @BeforeMethod
    public void  setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
         //driver.close();
    }
}
