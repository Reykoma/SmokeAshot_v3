//package src;
//
//import src.Driver.RestartTest;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
//
//import javax.imageio.ImageIO;
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//public class Trash {
//    @Test(retryAnalyzer = RestartTest.class)
//    public void topline() throws IOException, InterruptedException {
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(1280, 1000));
//
//        driver.get("https://www.rbc.ru/inttotestv10A");
//
//
//        String cssSelector = ".news-feed__item:nth-child(1), .news-feed__item:nth-child(2), .news-feed__item:nth-child(3)";
//
//
//        List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));
//
//
//
//        Screenshot myScreenshot1 = new AShot()
//                .shootingStrategy(ShootingStrategies.viewportPasting(0))
//                .takeScreenshot(driver, elements);
//
//
//
//        //Сохраняем скрин с ошибками
//        ImageIO.write(myScreenshot1.getImage(), "png", new File("Screenshot\\" + "dfgdfgdfgdfg" + ".png"));
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }
