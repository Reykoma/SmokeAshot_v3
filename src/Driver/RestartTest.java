package Driver;

import ToolsAshot.SA;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.ArrayList;

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