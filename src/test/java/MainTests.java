package test.java;

import Driver.RestartTest;
import Driver.RestartTest10;
import ToolsAshot.SA;
import ToolsAshot.SAtools;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.*;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class MainTests {

    /*
    ГЛАВНАЯ СТРАНИЦА
    Здесь собраны тесты для главной

    1. На странице с помощью JS меняются стили.
    А именно сделано так, чтобы перестал залипать прямой эфир, топлайн и билборд.
    Делается это в методе         SAtools.fixTopLine();

    НЕ СДЕЛАНО:
    Правая колонка кроме блока "Опросы"
    Отображения новостей в подгрузке
    Кнопка "Еще материалы и функционал под ней
    Подгружаемые элементы в ленте новостей


Нужно улучшить:
- Доделать остальные блоки
- Вторые страницы
     */


    //Топлайн. Рандомная хрень... Специально ради таких вещей создан класс с количеством попыток больше чем 1-2
    //В топлайне есьт рекламные ссылки которые рандомно появляются в ротации.
//
//
//
//


    @Test(retryAnalyzer = RestartTest.class)
    public void topline() throws IOException, InterruptedException {

        SA.ashot1liteScreen("https://www.rbc.ru/", ".topline__wrapper");

    }

    @Test(retryAnalyzer = RestartTest.class)
    //Блок прямого эфира. С игнором бегущей строки
    public void liveTV() throws IOException, InterruptedException {
        Set<By> setIgnoredElements = new HashSet<By>();
        setIgnoredElements.add(By.cssSelector(".topline__forecast__move"));

        SA.ashot3ShootingAndIgnoreElements("https://www.rbc.ru/", ".l-col-left-border", setIgnoredElements);
    }


    @Test(retryAnalyzer = RestartTest.class)
    //Заголовок Ленты новостей
    public void newsFeedHeader() throws IOException, InterruptedException {
        SA.ashot1liteScreen("https://www.rbc.ru/", ".news-feed__header");
    }

    @Test(retryAnalyzer = RestartTest10.class)
//    //Элементы Ленты новостей, C Первого по 6ой. С учетом игнора банерной позиции
    public void newfFeedItem() throws IOException, InterruptedException {

        String url = ("https://www.rbc.ru/");

        //Элементы которые будем скриншотить
        String cssSelector = ".news-feed__item:nth-child(1), .news-feed__item:nth-child(2), .news-feed__item:nth-child(3), .news-feed__item:nth-child(5), .news-feed__item:nth-child(6), .news-feed__item:nth-child(7)";

        //игнорируемые элементы
        Set<By> setIgnoredElements = new HashSet<By>();
        setIgnoredElements.add(By.cssSelector(".banner[data-banner-id='firstpage_left2']")); //Игнорируется первый баннер

        //Название png файликов с полученными скринами
        String screenName = "Newsfeed";

        SA.ashot4ScreenElementsGroup(url, cssSelector, setIgnoredElements, screenName);

    }


//    @Test(retryAnalyzer = RestartTest.class)
//    //Блок Главное за сутки. Сюжеты и первый материал Кроме заголовка первого материала. Заголовок делается отдельно.
//    // Иначе скриншот кривой. Заголовок первого материала делается в main__big__title
//    public void main() throws IOException, InterruptedException {
//
//        Set<By> setIgnoredElements = new HashSet<By>();
//        setIgnoredElements.add(By.cssSelector(".main__big__title"));
//
//        SA.ashot3ShootingAndIgnoreElements("https://www.rbc.ru/", ".main.js-index-central-column-type", setIgnoredElements);
//    }

    @Test(retryAnalyzer = RestartTest.class)
    //Блок Главное за сутки. Заголовок первого материала.
    public void main__big__title() throws IOException, InterruptedException {
        SA.ashot2scrollForFooterAndWait("https://www.rbc.ru/", ".main__big__title");
    }

    //    @Test //Биллборд. НЕ СДЕЛАНО

    @Test(retryAnalyzer = RestartTest.class)
    //Блок Главное за сутки. Остальные элементы блока
    public void main__list() throws IOException, InterruptedException {
        SA.ashot1liteScreen("https://www.rbc.ru/", ".main__list");
    }


    @Test(retryAnalyzer = RestartTest.class)
//Блок Центральная колонка. Первые 4 карточки материалов. (три маленьких и одна большая)
    public void central_column_main() throws IOException, InterruptedException {

        String url = ("https://www.rbc.ru/");

        String cssSelector = ".js-index-central-column-main:nth-child(1), .js-index-central-column-main:nth-child(2), .js-index-central-column-main:nth-child(3), .js-index-central-column-big.js-index-doscroll[data-vr-contentbox='Position 4']";

        //игнорируемые элементы
        Set<By> setIgnoredElements = new HashSet<By>();
        setIgnoredElements.add(By.cssSelector(".banner[data-banner-id='firstpage_left2']")); //Игнорируется первый баннер

        //Название png файликов с полученными скринами
        String screenName = "central_column_main";

        SA.ashot4ScreenElementsGroup(url, cssSelector, setIgnoredElements, screenName);
    }

//    @Test(retryAnalyzer = RestartTest.class)
////Блок Правая колонка индикаторы и первый 240x400 НЕ РАБОТАЕТ
//    public void right_col() throws IOException, InterruptedException {
//
//        String cssSelector = ".banner__container:nth-child(2)";
//
//        //игнорируемые элементы
//        Set<By> setIgnoredElements = new HashSet<By>();
////        setIgnoredElements.add(By.cssSelector(".indicators__wrap")); //Игнорируются тикеры
//        setIgnoredElements.add(By.cssSelector(".banner[data-banner-id=\'new_top_left\']")); //Игнорируется баннер в правой колонке
//
//        //Название png файликов с полученными скринами
//        String screenName = "right_col";
//
//        SA.ashot4ScreenElementsGroup(cssSelector, setIgnoredElements, screenName);
//        Assert.assertEquals(SA.diff1.getDiffSize(), 0);
//    }


//    @Test(retryAnalyzer = RestartTest.class)
    //Блок Индикаторы //НЕ РАБОТАЕТ. Нет игнора элементов что "тикают". Нужно написать игнор отдельных значений. закомиченный ниже код не игнорирует.
//    public void indicators() throws IOException, InterruptedException {
//        Set<By> setIgnoredElements = new HashSet<By>();
//        setIgnoredElements.add(By.cssSelector(".indicators__wrap"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(1)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(2)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(3)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(4)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(5)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(6)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(7)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(8)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(9)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(10)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(11)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(12)"));
//        setIgnoredElements.add(By.cssSelector(".indicators__item:nth-child(13)"));
//
//
////        SA.ashot1liteScreen("https://www.rbc.ru/inttotestv10A", ".indicators");
//        SA.ashot3ShootingAndIgnoreElements("https://www.rbc.ru/inttotestv10A", ".indicators",setIgnoredElements );
//        Assert.assertEquals(SA.diff1.getDiffSize(), 0);
//    }

    //    @Test //Блок Правая колонка. Первый баннер

    //    @Test //Блок Правая колонка. ТГБ

    //НЕ стабильная вещь. рендерниг страницы происходит со смещением в пару пикселей. и по этому очень часто стейдж отличается от прода в этом блоке.
//    @Test(retryAnalyzer = RestartTest.class)
//    //Блок Опросы в правой колонке
//    public void poll_opinion() throws IOException, InterruptedException {
//        SA.ashot2scrollForFooterAndWait("https://www.rbc.ru/inttotestv10A", ".poll-opinion");
//    }

    //    @Test //Блок Правая колонка. Второй баннер


    @Test(retryAnalyzer = RestartTest10.class)
    //Блок Футер/Подвал
    public void footer() throws IOException, InterruptedException {
        SA.ashot2scrollForFooterAndWait("https://www.rbc.ru/", ".footer");
    }


    @AfterSuite
    public void dfgdfg() {



//            SAtools.jsWindowClose();


            SAtools.quitDriver();

    }
}
