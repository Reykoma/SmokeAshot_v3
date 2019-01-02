package Driver;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RestartTest implements IRetryAnalyzer {

    private int retryCount = 0;

    //Количество перезапусков
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Тест провалился, ПЕРЕЗАПУСК!!!");
            return true;
        }
        return false;
    }
}