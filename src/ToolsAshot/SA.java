package ToolsAshot;

import ToolsAshot.SAtools;
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
        //Проверка запущен ли браузер. И если не запущен Запуск браузера
        SAtools.startWebDriver();

//        Открываем ПРОД
        SAtools.openUrl(url);

//        Закрепляем шапку, чтобы не мешала при скроле НЕ РАБОТАЕТ для в10
        SAtools.fixTopLine();

        //Скролл до подвала. Чтобы вся страница подгрузилась. Нужно чтобы потом скрины нормальные получались
        SAtools.scrollForFooter();

//        делаем скрин
        Screenshot prodScreenshot = SAtools.screenShootingStrategy(element);
        SAtools.saveScreenshot("Prod", prodScreenshot, element);

        //Открываем новую вкладку
        SAtools.openNewTab();

//        открываем СТЕЙДЖ
        SAtools.openStageUrl(url);

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

//        Сравниваем
        SAtools.imageDiffer(prodScreenshot, stageScreenshot, element);

    }

    //Метод скриншотилки с игнором элементов.
    public static void ashot3ShootingAndIgnoreElements(String url, String element, Set<By> ignorElements) throws IOException {
        //Метод скриншотилки. Для длинных элементов. С игнором. С прокруткой

        //Проверка запущен ли браузер. И если не запущен Запуск браузера
        SAtools.startWebDriver();

//        Открываем ПРОД
        SAtools.openUrl(url);

//        Закрепляем шапку, чтобы не мешала при скроле
        SAtools.fixTopLine();

//        делаем скрин
//        Screenshot prodScreenshot2 = screenLongElementWithIgnor(element, ignorElements);
//        saveScreenshot("Prod", prodScreenshot2, element);

        //        делаем скрин
        Screenshot prodScreenshot = SAtools.screenLongElementWithIgnor(element, ignorElements);
        SAtools.saveScreenshot("Prod", prodScreenshot, element);

        //Открываем новую вкладку
        SAtools.openNewTab();

//        открываем СТЕЙДЖ
        SAtools.openStageUrl(url);

//        Закрепляем шапку, чтобы не мешала при скроле
        SAtools.fixTopLine();



//        делаем скрин
//        Screenshot stageScreenshot2 = screenLongElementWithIgnor(element, ignorElements);
//        saveScreenshot("Stage", stageScreenshot2, element);

        //        делаем скрин
        Screenshot stageScreenshot = SAtools.screenLongElementWithIgnor(element, ignorElements);
        SAtools.saveScreenshot("Stage", stageScreenshot, element);

//        Сравниваем
        SAtools.imageDiffer(prodScreenshot, stageScreenshot, element);

    }

    //Метод скриншотилки. Просто сразу элемента
    public static void ashot1liteScreen(String url, String element) throws IOException {

        //Проверка запущен ли браузер. И если не запущен Запуск браузера
        SAtools.startWebDriver();

//        Открываем ПРОД
        SAtools.openUrl(url);

//        делаем скрин
        Screenshot prodScreenshot = SAtools.screenLite(element);
        SAtools.saveScreenshot("Prod", prodScreenshot, element);

        //Открываем новую вкладку
        SAtools.openNewTab();

//        открываем СТЕЙДЖ
        SAtools.openStageUrl(url);

//        делаем скрин
        Screenshot stageScreenshot = SAtools.screenLite(element);
        SAtools.saveScreenshot("Stage", stageScreenshot, element);

//        Сравниваем
        SAtools.imageDiffer(prodScreenshot, stageScreenshot, element);

    }

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    public static void ashot4ScreenElementsGroup(String url, String cssSelector,Set<By> setIgnoredElements,String screenName) throws IOException, InterruptedException {

        //Проверка запущен ли браузер. И если не запущен Запуск браузера
        SAtools.startWebDriver();

//        Открываем ПРОД
        SAtools.openUrl(url);

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
        SAtools.openNewTab();

//        открываем СТЕЙДЖ
        SAtools.openStageUrl(url);

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

//        Сравниваем
        SAtools.imageDiffer(prodScreenshot, stageScreenshot, screenName);


    }


}
