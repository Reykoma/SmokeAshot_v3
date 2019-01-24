package Driver;

import ToolsAshot.SA;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.ArrayList;

/*
Этот класс отвечает за количетество перезапусков теста, если он прошел не успешно.
Это нужно, так как верстка сайта вещь не стабиьлная, бывает отрендерится(Отрисуется) сайт со сдвигом по всей высоте на 1 пиксель.
Тогда весь тест провалиться.

Так же некоторые элементы находятся в ротации. Как например рекламные ссылки в топлайне.
Для того чтобы избежать ложных крашей по этой причине, в том числе добавлена возможносьт перезапука.

 */



public class RestartTest implements IRetryAnalyzer {

    private int retryCount = 0;

    //Количество перезапусков
    private static final int maxRetryCount = 10;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("метод перезапуска при провале теста. Рефреш страниц и ПЕРЕЗАПУСК!!!");

            SA.driver.navigate().refresh();
            ArrayList<String> tabs = new ArrayList<String>(SA.driver.getWindowHandles());
            SA.driver.switchTo().window(tabs.get(1));
            SA.driver.navigate().refresh();
            SA.driver.switchTo().window(tabs.get(0));
            return true;
        }
        return false;
    }
}