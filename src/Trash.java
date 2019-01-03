//package src;
//
//import ToolsAshot.SA;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
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
//    WebDriver driver;
//
//    @Test()
//    public void topline() throws IOException, InterruptedException {
//
//
//        driver.get("https://www.rbc.ru/inttotestv10A");
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        int contentWidt1h1 = ((Number) js.executeScript("return document.body.scrollHeight")).intValue();
//        System.out.println(contentWidt1h1);
//
//        WebElement webElement = driver.findElement(By.cssSelector(".footer"));
//
//        if(contentWidt1h1 >= 15000)
//        {
//            System.out.println("Длинна страницы больше 15000px, пропускаем скролл");
//        } else{
//            System.out.println("Длинна страницы меньше 15000px, скролим до подвала");
//            Thread.sleep(200);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
//            Thread.sleep(200);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
//            Thread.sleep(200);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
//            Thread.sleep(200);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
//            Thread.sleep(200);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
//            Thread.sleep(200);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
//            Thread.sleep(200);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
//            Thread.sleep(200);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
//            Thread.sleep(200);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
//            Thread.sleep(200);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
//            Thread.sleep(200);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
//        }    }
//
//    @AfterMethod
//    void dfgfg() {
//        driver.quit();
//
//    }
//
//    @BeforeMethod
//    void ergdfbct() {
//        driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(1280, 1000));
//
//    }
//
//
//}
