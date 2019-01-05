
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
import java.util.List;


/*
переделать опен урл
переделать опен стейдж

а щас проверяю возможность переключения между вкладками стейдж и прод

Метод для открытия СТЕЙДЖ площадки

узнать текущий урл
getcurent url

Если это стейдж. то ничего не делать
if curenturl == стейдж
возврат

если это прод
if current url

проверить. есть ли другие вкладки с урлом стейджа. Если есть. переключитья на них
Если нет создать

первый вариант когда стейдж еще не создан
второй вариант когда стейдж уже создан
 */


public class Trash {

    @Test()
    public void topline() throws IOException, InterruptedException {
        String prod = "https://www.rbc.ru/inttotestv10A";
        String stage = "https://staging.rbc.ru/inttotestv10A";

        SA.driver.get(prod);
        prod = SA.driver.getCurrentUrl();

    //В селениум нет команды на открытие нвого окна. Нужно использоваьт другие средства. Код ниже открывает новое окно
        ((JavascriptExecutor) SA.driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(SA.driver.getWindowHandles());
        System.out.println(tabs.size());

    //Переключение на новое окно
        SA.driver.switchTo().window(tabs.get(1));

        SA.driver.get(prod);
        String actualUrl = SA.driver.getCurrentUrl();
        System.out.println(prod);



        if (actualUrl.equals("https://staging.rbc.ru/")) {
            System.out.println("Текущий урл " + SA.driver.getCurrentUrl() + " по этому переключаемся на первую вкладку");
            SA.driver.switchTo().window(tabs.get(0));

        } else {
            System.out.println("Текущий урл " + SA.driver.getCurrentUrl() + " по этому return");
            return;
        }

        System.out.println("Текущий урл говно полное " + SA.driver.getCurrentUrl());




    }


//    @Test()
//    public void gyjvgyj()  {
//        SA.driver.get("https://www.rbc.ru/inttotestv10A");
//
//        String actualUrl = SA.driver.getCurrentUrl();
//        System.out.println("Актуальный урл " + actualUrl);
//
//        String expectedUrl = "https://www.rbc.ru/";
//        System.out.println("Ожидаемый урл " + expectedUrl);
//
////        System.out.println("Aaaaa " + actualUrl.equals(expectedUrl));
////        new String("test").equals("test");
//
//        if (actualUrl.equals("https://staging.rbc.ru/")) {
//            System.out.print("равно");
//        } else {
//            System.out.print("не равно");
//        }
//
//
//

//    }


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
