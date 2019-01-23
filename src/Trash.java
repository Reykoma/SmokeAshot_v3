
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

Такого вида функция, примерно: url.contains(mass_add)
Где url - строка в которой надо искать, а mass_add - строка которую надо искать в url

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


        SA.driver.get("https://www.rbc.ru/technology_and_media/23/01/2019/5c48677a9a79477e89283fa4?from=from_main");

        System.out.println("Ждем");

        Thread.sleep(5000);

        System.out.println("Скроллим");

        ((JavascriptExecutor) SA.driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");

        System.out.println("Закончили");


        Thread.sleep(5000);


        SA.driver.close();

        //Переключение на новое окно
//        SA.driver.switchTo().window(tabs2.get(1));








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
