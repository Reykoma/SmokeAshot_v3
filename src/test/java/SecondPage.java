package test.java;

import Driver.RestartTest;
import ToolsAshot.SA;
import ToolsAshot.SAtools;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.*;
import java.io.IOException;

public class SecondPage {

    /*
ВТОРЫЕ СТРАНИЦЫ
     */



    @Test(retryAnalyzer = RestartTest.class)
    //Центральная колонка 1ый слайд
    public void a_slide1() throws IOException, InterruptedException {
        Set<By> setIgnoredElements = new HashSet<By>();
//        setIgnoredElements.add(By.cssSelector(".l-col-right"));
        setIgnoredElements.add(By.cssSelector(".article__header__counter")); //Это счетчик количества просмотров материала

//        SAtools.startWebDriver();
//        SAtools.openUrl("https://www.rbc.ru/inttotestv10A");

        SA.ashot3ShootingAndIgnoreElements("https://www.rbc.ru/business/19/11/2018/5be5b0c99a7947d6778b7580\n", ".article .l-col-main", setIgnoredElements);
        Assert.assertEquals(SA.diff1.getDiffSize(), 0);

    }

    @Test(retryAnalyzer = RestartTest.class)
    //Материалы по теме в правой колонке
    public void b_theme_materials() throws IOException, InterruptedException {

        SA.ashot2scrollForFooterAndWait("https://www.rbc.ru/business/19/11/2018/5be5b0c99a7947d6778b7580\n",".theme-materials");
        Assert.assertEquals(SA.diff1.getDiffSize(), 0);
    }

    //НЕ СДЕЛАНО. Банеры в правой колонке

    //НЕ СДЕЛАНО. Блок с рекламой внизу материала

    //.intresting


    @Test(retryAnalyzer = RestartTest.class)
    //Материалы по теме в правой колонке
    public void intresting() throws IOException, InterruptedException {

        SA.ashot2scrollForFooterAndWait("https://www.rbc.ru/business/19/11/2018/5be5b0c99a7947d6778b7580\n",".intresting");
        Assert.assertEquals(SA.diff1.getDiffSize(), 0);
    }

//    @Test(retryAnalyzer = RestartTest.class)
//    //Страница Рубрики. Скрин первых 5 элементов
//    public void dfgdfgfg() throws IOException, InterruptedException {
//
//        //Проставляем нужную куку
//        SAtools.startWebDriver();
//        SAtools.openUrl("https://www.rbc.ru/inttotestv10A");
//
//        String url = ("https://www.rbc.ru/business/");
//
//        String cssSelector = ".g-overflow";
//
//
//        SA.ashot1liteScreen(url,cssSelector);
//        Assert.assertEquals(SA.diff1.getDiffSize(), 0);
//    }





    @AfterSuite
    public void dfgdfg() {
//        SAtools.jsWindowClose();
        SAtools.quitDriver();
    }
}
