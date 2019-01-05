package ToolsAshot;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SAtools {

    static Screenshot screenLite(String element) {
        System.out.println("Делаем скрины с площадки: " + SA.driver.getCurrentUrl());
        System.out.println("Через метод ashot1liteScreen. Просто скрин элемента, без спец условий ");

        WebElement myWebElement1 = SA.driver.findElement(By.cssSelector(element));

        Screenshot myScreenshot1 = new AShot()
                .takeScreenshot(SA.driver, myWebElement1);

        return myScreenshot1;
    }


    static Screenshot ScreenAllviewPage(Set<By> ignorElements) {
        System.out.println("Делаем скрины с площадки: " + SA.driver.getCurrentUrl());
        System.out.println("Через метод ScreenAllviewPage. Скрин видимой части страницы с учетом игноров ");

//        WebElement myWebElement1 = driver.findElement(By.cssSelector(ignorElements));

        //Коллекция, в которую можно передавать много игнорируемых элементов в теории


        //Прокрутка страницы в самый вверх. Так как после предыдущих тестов неизвестно в каком месте страницы мы окажемся
        ((JavascriptExecutor) SA.driver).executeScript("scroll(0,0)");


        Screenshot myScreenshot1 = new AShot()
                .ignoredElements(ignorElements)
                //.shootingStrategy(ShootingStrategies.viewportPasting(0))
//                .element(driver, element);

//                .ignoredElements(ignorElements)
                .takeScreenshot(SA.driver);

        return myScreenshot1;
    }

    static Screenshot screenLongElementWithIgnor(String element, Set<By> ignorElements) {
        //Для длинных элементов

        System.out.println("Делаем скрины с площадки: " + SA.driver.getCurrentUrl());
        System.out.println("Через метод screenLongElementWithIgnor. Скрин видимой части страницы с учетом игноров ");

        WebElement myWebElement1 = SA.driver.findElement(By.cssSelector(element));

        //Коллекция, в которую можно передавать много игнорируемых элементов в теории


        //Прокрутка страницы в самый вверх. Так как после предыдущих тестов неизвестно в каком месте страницы мы окажемся
        ((JavascriptExecutor) SA.driver).executeScript("scroll(0,0)");


        Screenshot myScreenshot1 = new AShot()
                .ignoredElements(ignorElements)
                .shootingStrategy(ShootingStrategies.viewportPasting(0))
                .takeScreenshot(SA.driver, myWebElement1);

//                .ignoredElements(ignorElements)
//                .takeScreenshot(driver);

        return myScreenshot1;
    }

    static void imageDiffer(Screenshot scrin1, Screenshot scrin2, String element) throws IOException {
        System.out.println("Метод imageDiffer. Сравниваем скрины");
        //Сравниваем
        SA.diff1 = new ImageDiffer()
                //.withColorDistortion(10)              //  В теории добавляет игнорирование какого то количества пикселей
                .makeDiff(scrin1, scrin2);

        //Удаляет спецсимволы в селекторе
        pepelac2(element);

        System.out.println("Сохраняем полученный результат");
        ImageIO.write(SA.diff1.getMarkedImage(), "png", new File("Screenshot\\" + "DIFF" + element + ".png"));
        System.out.println("Сохранили успешно");

    }

    static void saveScreenshot(String stageOrProdUrl, Screenshot screenshot, String element) throws IOException {
        System.out.println("метод saveScreenshot. Сохраняем скриншот");
        //Перед сохранением из селектора убираем все спецсимволы. Иначе Windows будет ругаться на недопустимое название
        element.replaceAll("[-+.^:,]", "");//.substring(10).substring(10);

        //Сохраняем скрин с ошибками
        ImageIO.write(screenshot.getImage(), "png", new File("Screenshot\\" + stageOrProdUrl + element + ".png"));
        System.out.println("метод saveScreenshot. Сохранили успешно.");

    }

    static void openStageUrl(String s) {
        System.out.println("метод openStageUrl. Создаю урл для стейдж");
        //вариант когда стейдж еще не открыт
//        if ()


        //Вариант когда стейдж уже открыт


//        //нужен ЦИКЛ
//        String stage = SA.driver.getCurrentUrl();
//        String expectedUrl = "https://www.staging.rbc.ru";
//
//
//        if (stage == expectedUrl) {
//            System.out.println("Текущий урл стейдж" + SA.driver.getCurrentUrl() + " по этому переключаемся на первую вкладку");
//
//            //В селениум нет команды на открытие нвого окна. Нужно использоваьт другие средства. Код ниже открывает новое окно
////            ((JavascriptExecutor) SA.driver).executeScript("window.open()");
//            ArrayList<String> tabs = new ArrayList<String>(SA.driver.getWindowHandles());
//
//            //Переключение на первое окно
//            SA.driver.switchTo().window(tabs.get(0));
//
//
//        } else {
//            System.out.println("Текущий урл " + SA.driver.getCurrentUrl() + " по этому return");
//        }
//
        StringBuilder str = new StringBuilder(s);
//
//        // insert character value at offset 8
        str.insert(11, ".staging");
        String stage = str.toString();

        System.out.println("Открываю созданный урл");
        openUrl(stage);
//
//        stage = SA.driver.getCurrentUrl();
//
//
//        return s;
    }

    static Screenshot screenShootingStrategy(String element) throws InterruptedException {
        System.out.println("Делаем скрины с площадки: " + SA.driver.getCurrentUrl() + "С прокруткй, ожиданием и shooting strategy");


        WebElement myWebElement1 = SA.driver.findElement(By.cssSelector(element));

        //Прокрутка окна браузера до нужного элемента
//        Actions actions = new Actions(SA.driver);
//        actions.moveToElement(myWebElement1);
//        actions.perform();

//        Thread.sleep(3000); //Вместо ожидания хорошо бы тту написать метод. Который проверяет грузится ли какие нибудь js сейчас. И если да, то ждет их загрузки

        Screenshot myScreenshot1 = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(0))
                .takeScreenshot(SA.driver, myWebElement1);

        return myScreenshot1;
    }

    public static void fixTopLine() {
        //Топлайн
        JavascriptExecutor js = (JavascriptExecutor) SA.driver;
        WebElement fixTopline = SA.driver.findElement(By.cssSelector(".topline__wrapper"));
        js.executeScript("arguments[0].setAttribute('style','position:static!important;')", fixTopline);

        //Прямой эфир
        JavascriptExecutor js2 = (JavascriptExecutor) SA.driver;
        WebElement fixTopline2 = SA.driver.findElement(By.cssSelector(".l-col-left-border"));
        js2.executeScript("arguments[0].setAttribute('style','position:static!important;')", fixTopline2);


        try {
            //Билборд
            JavascriptExecutor js3 = (JavascriptExecutor) SA.driver;
            WebElement fixTopline3 = SA.driver.findElement(By.cssSelector(".l-sticky.l-small-width-left-margin"));
            js3.executeScript("arguments[0].setAttribute('style','position:static!important;')", fixTopline3);
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }

    }

    static void openNewTabOrSwitchToStage(String url) throws InterruptedException {

        //Узнаем текущее количество вкладок
        ArrayList<String> tabs = new ArrayList<String>(SA.driver.getWindowHandles());
        System.out.println("метод openNewTabOrSwitchToStage. Количество вкладок в данный момент: " + tabs.size());

        String actualUrl = SA.driver.getCurrentUrl();

        //Записываем в переменную taaabs количество вкладок
        int taaabs = tabs.size();

//        //Если вкладок 2, то переключаюсь на соседнюю вкладку
//        if (taaabs == 2) {
//            System.out.println("Стейдж уже открыт в соседней вкладке, переключаюсь на нее");
//            SA.driver.switchTo().window(tabs.get(1));
//        }
//
//
//        //Если вкладок 1, то значит сетйдж еще не создан. создаю
//        else if ( actualUrl.equals("data:,")) {
//            System.out.println("Еще не открывали прод. Открываю");
//
//            openUrl(url);
//        }
//
//        //Если вкладок 1, то значит сетйдж еще не создан. создаю
//         if (taaabs == 1) {
//            System.out.println("Открытого стейджа нет. Подготавливаю");
//
//            System.out.println("Создаю новую вкладку");
//            //В селениум нет команды на открытие нового окна. Нужно использоваьт другие средства. Код ниже открывает новое окно
//            ((JavascriptExecutor) SA.driver).executeScript("window.open()");
//
//
//            ArrayList<String> tabs2 = new ArrayList<String>(SA.driver.getWindowHandles());
//            System.out.println("Текущее количество вкладок " + tabs2.size());
//
//            System.out.println("Переключаюсь драйвером в эту созданную вкладку");
//            SA.driver.switchTo().window(tabs2.get(1));
//
////            System.out.println("Выполняем метод openStageUrl");
////            openStageUrl(url);
//
//        } else {
//            System.out.println("Количество вкладок больше 2. По этому крашим дальнейшее исполнение кода");
//            return;
//        }


        //В селениум нет команды на открытие нвого окна. Нужно использоваьт другие средства. Код ниже открывает новое окно
//        ((JavascriptExecutor) SA.driver).executeScript("window.open()");
//        ArrayList<String> tabs = new ArrayList<String>(SA.driver.getWindowHandles());

        //Переключение на новое окно
//        SA.driver.switchTo().window(tabs.get(1));
    }

    public static void openUrl(String url) {

        System.out.println("метод openUrl. открываем: " + url);


        try {
            SA.driver.get(url);
        } catch (TimeoutException ignore) {
        }

        try {
            SA.driver.findElement(By.cssSelector(".dcfdddaf_poll-popup .dcfdddaf-close")).click();
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }


        try {
            SA.driver.findElement(By.cssSelector(".push-allow__button_no")).click();
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }


    public static void startWebDriver() {
        //Проверка запущен ли браузер. И если не запущен Запуск браузера
//        System.out.println("11");

        if
                (SA.driver == null) {
            System.out.println("метод startWebDriver. Дравйер = null, запускаем драйвер");
            SA.driver = new ChromeDriver();
            // устанавливаем таймаут ожидания загрузки
            SA.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            SA.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//            driver.manage().window().maximize();
            SA.driver.manage().window().setSize(new Dimension(1280, 1000));

        } else {
            System.out.println("метод startWebDriver. Дравйер уже запущен. return");
            return;
        }
    }

    public static void quitDriver() {

        SA.driver.quit();

    }

    public static void jsWindowClose() {
        ArrayList<String> tabs = new ArrayList<String>(SA.driver.getWindowHandles());
        ((JavascriptExecutor) SA.driver).executeScript("window.close()");
        SA.driver.switchTo().window(tabs.get(0));
        ((JavascriptExecutor) SA.driver).executeScript("window.close()");
    }

    public static String pepelac2(String string) {
        string = string.replaceAll("/$", "");
//        System.out.println("После удаления ординарных слешей " + string);
        string = string.replaceAll("//", "");
//        System.out.println("После удаления еще слешей " + string);

        string = string.replaceAll("[-+.^:?=,/]", "");
//        System.out.println("Остальные спецсимволы " + string);
        return (string);
    }

    //Скролл до подвала. Потом ожидание подгрузки новых элементов, потом снова скрол. И так пока до подвала не доскролим.
    public static void scrollForFooter() throws InterruptedException {

        //Узнаем текущую длинну страницы и помещаем значение в переменную contentWidt1h1
        JavascriptExecutor js = (JavascriptExecutor) SA.driver;
        int contentWidt1h1 = ((Number) js.executeScript("return document.body.scrollHeight")).intValue();
        System.out.println("Текущая длинна страницы " + contentWidt1h1);
        WebElement webElement = SA.driver.findElement(By.cssSelector(".footer"));

        //Цикл. Если длинна страницы "длинная" то есть больше 15000px то ничего не делаем. Если же меньше 15000px то скролим до подвала с ожиданиями
        if (contentWidt1h1 >= 15000) {
            System.out.println("Метод scrollForFooter. Длинна страницы больше 15000px, пропускаем скролл");
        } else {
            System.out.println("Метод scrollForFooter. Длинна страницы меньше 15000px, скролим до подвала");
            Thread.sleep(200);
            ((JavascriptExecutor) SA.driver).executeScript("arguments[0].scrollIntoView();", webElement);
            Thread.sleep(200);
            ((JavascriptExecutor) SA.driver).executeScript("arguments[0].scrollIntoView();", webElement);
            Thread.sleep(200);
            ((JavascriptExecutor) SA.driver).executeScript("arguments[0].scrollIntoView();", webElement);
            Thread.sleep(200);
            ((JavascriptExecutor) SA.driver).executeScript("arguments[0].scrollIntoView();", webElement);
            Thread.sleep(200);
            ((JavascriptExecutor) SA.driver).executeScript("arguments[0].scrollIntoView();", webElement);
            Thread.sleep(200);
            ((JavascriptExecutor) SA.driver).executeScript("arguments[0].scrollIntoView();", webElement);
            Thread.sleep(200);
            ((JavascriptExecutor) SA.driver).executeScript("arguments[0].scrollIntoView();", webElement);
            Thread.sleep(200);
            ((JavascriptExecutor) SA.driver).executeScript("arguments[0].scrollIntoView();", webElement);
            Thread.sleep(200);
            ((JavascriptExecutor) SA.driver).executeScript("arguments[0].scrollIntoView();", webElement);
            Thread.sleep(200);
            ((JavascriptExecutor) SA.driver).executeScript("arguments[0].scrollIntoView();", webElement);
            Thread.sleep(200);
            ((JavascriptExecutor) SA.driver).executeScript("arguments[0].scrollIntoView();", webElement);
        }
    }

    public static Screenshot screenElementsAndAddIgnor(String elements, Set<By> ignorElements) {

        System.out.println("Внутри метода скриншотилки" + elements);

        List<WebElement> elementsList = SA.driver.findElements(By.cssSelector(elements));

        Screenshot myScreenshot1 = new AShot()
                .ignoredElements(ignorElements)
                .shootingStrategy(ShootingStrategies.viewportPasting(0))
                .takeScreenshot(SA.driver, elementsList);

        return myScreenshot1;
    }

    public static void switchToProd() {
        System.out.println("Метод switchToProd. Возвращаемся на первую вкладку");
        ArrayList<String> tabs = new ArrayList<String>(SA.driver.getWindowHandles());
        SA.driver.switchTo().window(tabs.get(0));

        System.out.println("Возвращение на первую вкладку произведено. Урл в текущей вкладке = " + SA.driver.getCurrentUrl());

    }

    public static void openProd2(String url) {


        String actualUrl = SA.driver.getCurrentUrl();
        System.out.println("метод openProd2. Текущий урл: " + actualUrl);





        if (actualUrl.equals("data:,")) {
            System.out.println("если текущий урл 'data:,' то открываем прод");
            openUrl(url);
        }
        if (actualUrl.equals("https://www.rbc.ru/")) {
            System.out.println("если текущий урл 'https://www.rbc.ru/' Ничего не открываем.");

        }
        if (actualUrl.equals("https://staging.rbc.ru/")) {
            System.out.println("если текущий урл 'https://staging.rbc.ru/' Переключаемся на соседнюю вкладку");

            ArrayList<String> tabs = new ArrayList<String>(SA.driver.getWindowHandles());
            SA.driver.switchTo().window(tabs.get(0));

            System.out.println("Возвращение на первую вкладку произведено. Ожидаемый урл в текущей вкладке 'https://www.rbc.ru/', факт: = " + SA.driver.getCurrentUrl());
        }


    }

    public static void openStage2(String url) {



        String actualUrl = SA.driver.getCurrentUrl();
        System.out.println("метод openStage2. Текущий урл: " + actualUrl);

        ArrayList<String> tabs = new ArrayList<String>(SA.driver.getWindowHandles());
        int size = tabs.size();
        System.out.println("Текущее количество вкладок = " + size);

        if (size == 2) {
            if (actualUrl.equals("https://www.rbc.ru/")) {
                System.out.println("Если вкладок 2 и если текущий урл 'https://www.rbc.ru/' переключаемся на соседнюю вкладку");
                SA.driver.switchTo().window(tabs.get(1));
            }
        }

        if (size == 1) {
            if (actualUrl.equals("https://www.rbc.ru/")) {

                System.out.println("Если вкладок 1 и если текущий урл 'https://www.rbc.ru/' Создаем и переключаемся на соседнюю вкладку");

                //В селениум нет команды на открытие нвого окна. Нужно использоваьт другие средства. Код ниже открывает новое окно
                ((JavascriptExecutor) SA.driver).executeScript("window.open()");
                ArrayList<String> tabs2 = new ArrayList<String>(SA.driver.getWindowHandles());

                //Переключение на новое окно
                SA.driver.switchTo().window(tabs2.get(1));

                //Добавляем к урлу прода приписку "stage"
                StringBuilder str = new StringBuilder(url);
                str.insert(11, ".staging");
                String stage = str.toString();
                System.out.println("3");

                System.out.println("Открываю созданный урл");
                openUrl(stage);
            }
        }


    }
}
