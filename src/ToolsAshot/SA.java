package ToolsAshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.io.IOException;
import java.util.List;
import java.util.Set;

//SA сокращенно от ScreenshotAshot
public class SA {
    public static WebDriver driver;
    private static String url;
    public static ImageDiff diff1;

/*
Здесь Универсальные методы создания скриншотов
наверное это можно назвать высокоуровневым кодом.
Код низкого уровня находится в SAtools
 */



    //Метод скриншотилки. Сперва происходит скролл до подвала, А потом уже скрин с прокруткой блока через ShootingStrategies
    public static void ashot2scrollForFooterAndWait(String url, String element) throws IOException, InterruptedException {

        System.out.println("метод ashot2scrollForFooterAndWait. Запуск");
        //Проверка запущен ли браузер. И если не запущен Запуск браузера
        SAtools.startWebDriver();

        //Открываем прод через этот метод
        SAtools.openProd2(url);

//        Закрепляем шапку, чтобы не мешала при скроле НЕ РАБОТАЕТ для в10
        SAtools.fixTopLine();

        //Скролл до подвала. Чтобы вся страница подгрузилась. Нужно чтобы потом скрины нормальные получались
        SAtools.scrollForFooter();

//        делаем скрин
        Screenshot prodScreenshot = SAtools.screenShootingStrategy(element);
        SAtools.saveScreenshot("Prod", prodScreenshot, element);

        //Открываем новую вкладку
//        SAtools.openNewTabOrSwitchToStage(url);


        //Открываем стейдж через этот метод
        SAtools.openStage2(url);


        //        Закрепляем шапку, чтобы не мешала при скроле НЕ РАБОТАЕТ для в10
        SAtools.fixTopLine();

        //Скролл до подвала. Чтобы вся страница подгрузилась. Нужно чтобы потом скрины нормальные получались
        SAtools.scrollForFooter();

        //Скролл до элемента который будем скриншотить. Иначе скрин будет корявый.
//        moveToElement(element);

//        Закрепляем шапку, чтобы не мешала при скроле НЕ РАБОТАЕТ для в10
//        SAtools.fixTopLine();

//        делаем скрин
        Screenshot stageScreenshot = SAtools.screenShootingStrategy(element);
        SAtools.saveScreenshot("Stage", stageScreenshot, element);

        SAtools.switchToProd();

//        Сравниваем
        SAtools.imageDiffer(prodScreenshot, stageScreenshot, element);

        SAtools.asserting();
    }

    //Метод скриншотилки с игнором элементов.
    public static void ashot3ShootingAndIgnoreElements(String url, String element, Set<By> ignorElements) throws IOException, InterruptedException {
        //Метод скриншотилки. Для длинных элементов. С игнором. С прокруткой
        System.out.println("метод ashot3ShootingAndIgnoreElements. Запуск");
        //Проверка запущен ли браузер. И если не запущен Запуск браузера
        SAtools.startWebDriver();

        //Открываем прод через этот метод
        SAtools.openProd2(url);

//        Закрепляем шапку, чтобы не мешала при скроле
        SAtools.fixTopLine();

        //Скролл до подвала. Чтобы вся страница подгрузилась. Нужно чтобы потом скрины нормальные получались
        SAtools.scrollForFooter();

//        делаем скрин
//        Screenshot prodScreenshot2 = screenLongElementWithIgnor(element, ignorElements);
//        saveScreenshot("Prod", prodScreenshot2, element);

        //        делаем скрин
        Screenshot prodScreenshot = SAtools.screenLongElementWithIgnor(element, ignorElements);
        SAtools.saveScreenshot("Prod", prodScreenshot, element);

        //Скролл в самый вверх страницы. Помогает на слайдовых страницах не оказаться на втором слайде
        SAtools.scrollHeight();


        //Открываем новую вкладку
//        SAtools.openNewTabOrSwitchToStage(url);

        //Открываем стейдж через этот метод
        SAtools.openStage2(url);

//        Закрепляем шапку, чтобы не мешала при скроле
        SAtools.fixTopLine();

        //Скролл до подвала. Чтобы вся страница подгрузилась. Нужно чтобы потом скрины нормальные получались
        SAtools.scrollForFooter();



//        делаем скрин
//        Screenshot stageScreenshot2 = screenLongElementWithIgnor(element, ignorElements);
//        saveScreenshot("Stage", stageScreenshot2, element);

        //        делаем скрин
        Screenshot stageScreenshot = SAtools.screenLongElementWithIgnor(element, ignorElements);
        SAtools.saveScreenshot("Stage", stageScreenshot, element);

        //Скролл в самый вверх страницы. Помогает на слайдовых страницах не оказаться на втором слайде
        SAtools.scrollHeight();

        SAtools.switchToProd();

//        Сравниваем
        SAtools.imageDiffer(prodScreenshot, stageScreenshot, element);

        SAtools.asserting();

    }

    //Метод скриншотилки. Просто сразу элемента
    public static void ashot1liteScreen(String url, String element) throws IOException, InterruptedException {
        System.out.println("метод ashot1liteScreen. Запуск");

        //Проверка запущен ли браузер. И если не запущен Запуск браузера
        SAtools.startWebDriver();

        //Открываем прод через этот метод
        SAtools.openProd2(url);

//        Открываем ПРОД
//        SAtools.openUrl(url);

//        делаем скрин
        Screenshot prodScreenshot = SAtools.screenLite(element);
        SAtools.saveScreenshot("Prod", prodScreenshot, element);

        //Открываем стейдж через этот метод
        SAtools.openStage2(url);

//        делаем скрин
        Screenshot stageScreenshot = SAtools.screenLite(element);
        SAtools.saveScreenshot("Stage", stageScreenshot, element);

        SAtools.switchToProd();

//        Сравниваем
        SAtools.imageDiffer(prodScreenshot, stageScreenshot, element);

        SAtools.asserting();

    }

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    public static void ashot4ScreenElementsGroup(String url, String cssSelector,Set<By> setIgnoredElements,String screenName) throws IOException, InterruptedException {
        System.out.println("метод ashot4ScreenElementsGroup. Запуск");

        //Проверка запущен ли браузер. И если не запущен Запуск браузера
        SAtools.startWebDriver();

        //Открываем прод через этот метод
        SAtools.openProd2(url);

        //Закрепляем шапку, чтобы не мешала при скроле
        SAtools.fixTopLine();

        //Скролл до подвала. Чтобы вся страница подгрузилась. Нужно чтобы потом скрины нормальные получались
        SAtools.scrollForFooter();

        List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));

        Screenshot prodScreenshot = new AShot()
                .ignoredElements(setIgnoredElements)
                .shootingStrategy(ShootingStrategies.viewportPasting(0))
                .takeScreenshot(driver, elements);

        SAtools.saveScreenshot("Prod", prodScreenshot, screenName);

        //Открываем новую вкладку
//        SAtools.openNewTabOrSwitchToStage(url);

//        открываем СТЕЙДЖ
        SAtools.openStage2(url);

        //        Закрепляем шапку, чтобы не мешала при скроле
        SAtools.fixTopLine();

        //Скролл до подвала. Чтобы вся страница подгрузилась. Нужно чтобы потом скрины нормальные получались
        SAtools.scrollForFooter();

        //Переделываем стринг который пришел из теста в вид переменной, который подходит для работы ашота - List<WebElement>
        List<WebElement> elements5 = driver.findElements(By.cssSelector(cssSelector));

        Screenshot stageScreenshot = new AShot()
                .ignoredElements(setIgnoredElements)
                .shootingStrategy(ShootingStrategies.viewportPasting(0))
                .takeScreenshot(driver, elements5);

        SAtools.saveScreenshot("Stage", stageScreenshot, screenName);

        SAtools.switchToProd();


//        Сравниваем
        SAtools.imageDiffer(prodScreenshot, stageScreenshot, screenName);

        SAtools.asserting();

    }


}
