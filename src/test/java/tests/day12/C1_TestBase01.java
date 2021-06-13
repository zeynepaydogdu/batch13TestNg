package tests.day12;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C1_TestBase01 extends TestBase {
    @Test
    public void test01(){
        // bu testin kullanilabilip driver objesinin hata vermemesi icin ya static  ya extends yada obje olusturularak
        //kullanilabileegini ama bizim extends yontemini tercih ettigimizi anlatan yer!!
        driver.get("https://www.youtube.com");//driver kirmizi veriyor acces modifier p
        //aynipackage yada child claslar in kullanabilmesi icin testbase clasindaki Webdriver driver'in basina protecded ekledik

    }


}
