package tests.com.techproed.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
public class AmazonSearchTest extends TestBase {
    /*
        1. kullanıcı amazon.com sayfasına gider
        2. search input box'a kelime girer
        3. Tahmini sonuçların aranan kelimeyi içerdiği test ediler
        4. Tahmin sayısnın en fazla 10 olduğu test edilir
     */
    @Test
    public void test1() {
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        int a = 123;
        // WebElement searchBox =driver.findElement(By.cssSelector("#twotabsearchtextbox"));

        //send keys methodu icine herzaman string alir
        //int a =123; gondermek istersek
        // int a=123;  -> sendKeys(String.valueOf(a))'ta yapılabilir
       /*
        Burada int i String.valuof ile String yaptik
        int a =123;
        aramaKutusu.sendKeys(String.valueOf(a));
        aramaKutusu.sendKeys(String.valueOf(123));
         */
        //send keys e int gondermek icin String.valueOf methodunu kullanarak a nin degerini gonderebilir

        searchBox.sendKeys("bilgisaray");
        List<WebElement> suggestions = driver.findElements(By.cssSelector("#suggestions>div"));
        //Tahmini sonuçların aranan kelimeyi içerdiği test ediler
        Assert.assertTrue(suggestions.size() < 11 && suggestions.size() > 1);
        //11 den kucuk ve 1 den buyuk olacak gibi assertion icin de konditionlari artirabiliriz
    }

    @Test
    public void test2() {
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        //int a=123;
        String sorgu = "bilgisayar";
        searchBox.sendKeys(sorgu);
        List<WebElement> suggestions = driver.findElements(By.cssSelector("#suggestions>div"));
        //Tahmini sonuçların aranan kelimeyi içerdiği test ediler
        List<String> liste = getWebElementText(suggestions);
        Assert.assertTrue(checkSuggestion(liste, sorgu));
    }

    /*
    bir method yazacaz
    return type=List<String>
    parameter=list<WebElement>
     */
    /*
        yeni methodu methot disinda clas icinde olusturmaliyiz
        bir methot yazacaz bu methotun return type List olacak
        parametre larak te list of sitring webelement olacak
        dah sonra tekrar bi assert icin methot olustup assertion dogrulamasini burde
        yapmis olacagiz
         */
    public List<String> getWebElementText(List<WebElement> elements) {
        List<String> liste = new ArrayList<>(); //liste.size()=0
        for (WebElement elm : elements) {
            liste.add(elm.getText());
        }
        return liste;
    }

    /*
     ?=> Framework oluştururken nelere dikkat edersini?
     - desing pattern (P0M)
    - sürdürülebilir
    - tekrar kullanılabilir
    - OOP konseptini kullanarak oluşturlması
    - Data local makinanızdan isole lazım
     */
    // assert için bir method yazacaz.
    public boolean checkSuggestion(List<String> liste, String sorgu) {
        for (String list : liste) {
            if (!list.contains(sorgu)) {
                return false;
            }
        }
        return true;
    }
}
    /*
    method yazacaz nav bar için
    parameter olarak 2 tane String alacak
    1. String ile hoverover, 2. ile submenulere tıklayacak
     */
