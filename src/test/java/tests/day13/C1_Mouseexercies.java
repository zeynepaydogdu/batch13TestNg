package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class C1_Mouseexercies extends TestBase {
    /*
       1- Yeni bir class olusturalim: D14_MouseActions1
       2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
       3- Cizili alan uzerinde sag click yapalim
       4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
       5- Tamam diyerek alert’I kapatalim
       6- Elemental Selenium linkine tiklayalim
       7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    */
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions=new Actions(driver);
        WebElement taraliYer=driver.findElement(By.id("hot-spot"));
        actions.contextClick(taraliYer).perform();

        String alerYazisi=driver.
                switchTo().
                alert().
                getText();

        String expectedAllert= "You selected a context menu”";

        Assert.assertEquals(alerYazisi,expectedAllert);


        String expectedYazi="You selected a context menu";
        Assert.assertEquals(alerYazisi,expectedYazi);
    }
}
