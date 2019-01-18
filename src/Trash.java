
import ToolsAshot.SA;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
Создал метод по простановке куки. Работает. Но не работает создание скринов с площадки Стейдж для вторых страниц. Чиню.
 */


public class Trash {




    @Test()
    public void gyjvgyj() throws InterruptedException {
//        SA.driver.get("https://www.google.ru/");
//        System.out.println("dsfdfg");
//        Cookie ck = new Cookie("abv7v8_tk", "10A");
//        SA.driver.manage().addCookie(ck);
//        SA.driver.get("https://www.rbc.ru/");
//
//        Thread.sleep(1000);

        SA.driver.get("https://www.rbc.ru/inttotestv10A");

        //В селениум нет команды на открытие нвого окна. Нужно использоваьт другие средства. Код ниже открывает новое окно
        ((JavascriptExecutor) SA.driver).executeScript("window.open()");
        ArrayList<String> tabs2 = new ArrayList<String>(SA.driver.getWindowHandles());

        SA.driver.close();

        //Переключение на новое окно
        SA.driver.switchTo().window(tabs2.get(1));








    }

//
    @AfterMethod
    void dfgfg() {
        SA.driver.quit();

    }

    @BeforeMethod
    void ergdfbct() {
        SA.driver = new ChromeDriver();
        SA.driver.manage().window().setSize(new Dimension(1280, 1000));

    }


}
