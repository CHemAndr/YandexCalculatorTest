package home.yandex.calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YandexCalculatorTest {

    public static WebDriver driver;
    public static SearchYandexPage searchYandexPage;
    public static ResultSearchPage resultSearchPage;

    @BeforeAll
    public static void setup() {
        //определение пути к драйверу
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        //создание экземпляра драйвера (открывается браузер)
        driver = new ChromeDriver();
        searchYandexPage = new SearchYandexPage(driver);
        resultSearchPage = new ResultSearchPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //неявное ожидание = 15 сек при загрузке страницы
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        //неявное ожидание = 1 сек при каждом поиске элемента
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //получение ссылки на страницу
        driver.get("http://www.yandex.ru/");
    }


    @Test
    public void testYandexCalculator() {
        searchYandexPage.enterTextInSearchString("калькулятор");
        searchYandexPage.clickSearchButton();
        if (resultSearchPage.existCalculator()) {
            //test1
            resultSearchPage.clickButton("1");
            resultSearchPage.clickButton("4");
            resultSearchPage.clickButton("4");
            resultSearchPage.clickButton("sqrt");
            resultSearchPage.clickButton("=");
            String resultTest1 = resultSearchPage.getCalculateResult();
            System.out.println("Result of test1: " + resultTest1);
            //test 2
            resultSearchPage.clickButton("C");
            resultSearchPage.clickButton("cos");
            resultSearchPage.clickButton("pi");
            resultSearchPage.clickButton("/");
            resultSearchPage.clickButton("2");
            resultSearchPage.clickButton("=");
            String resultTest2 = resultSearchPage.getCalculateResult();
            System.out.println("Result of test2: " + resultTest2);
            //test 3
            resultSearchPage.clickButton("C");
            resultSearchPage.clickButton("1");
            resultSearchPage.clickButton(",");
            resultSearchPage.clickButton("5");
            resultSearchPage.clickButton("*");
            resultSearchPage.clickButton("1");
            resultSearchPage.clickButton("0");
            resultSearchPage.clickButton("0");
            resultSearchPage.clickButton("=");
            String resultTest3 = resultSearchPage.getCalculateResult();
            System.out.println("Result of test3: " + resultTest3);
            try {
                   assertAll("Should return the next results",
                             () -> assertEquals("12", resultTest1),
                             () -> assertEquals("0,99962421685", resultTest2),
                             () -> assertEquals("150", resultTest3)
                            );
            } catch (Exception e) {System.out.println("Test to fall");}

        }

    }

    @AfterAll
    public static void finished() {
        driver.close();
    }
}

