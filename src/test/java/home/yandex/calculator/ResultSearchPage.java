package home.yandex.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSearchPage {

    public WebDriver driver;
    List<WebElement> calculatorButtonsPanelURL;       //Панель кнопок
    List<WebElement> calculatorButtonsOnFirstRowURL;  //Первая строка кнопок на панели
    List<WebElement> calculatorButtonsOnSecondRowURL; //Вторая строка кнопок на панели
    List<WebElement> calculatorButtonsOnThirdRowURL;  //Третья строка кнопок на панели
    List<WebElement> calculatorButtonsOnFourthRowURL; //Четвертая строка кнопок на панели
    List<WebElement> calculatorButtonsOnFifthRowURL;  //Пятая строка кнопок на панели
    WebElement calculatorScreen;                      //Экран калькулятора
    WebElement resultStringOnScreen;                  //Результат вычисления

    Map<String,Integer> calculatorBbuttonsNames;
    

    //Конструктор обращается к классу PageFactory
    //для инициализации элементы страницы по аннотация @FindBy
    public ResultSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    //======================элементы страницы==========================================

    //Калькулятор
    @FindBy(xpath = "//ul[@id = 'search-result']/li")
    public WebElement calculator;

    //======================методы работы с элементами ================================

    //Нажать кнопку калькулятора c именем buttonName
    public void clickButton(String buttonName) {
        //Индекс кнопки в строку
        int buttonIndex = calculatorBbuttonsNames.get(buttonName) % 10 ;
        //Выбор кноки по номеру строки и индексу кнопки с этой строке
        switch (calculatorBbuttonsNames.get(buttonName) / 10) {
            case 1:
                calculatorButtonsOnFirstRowURL.get(buttonIndex).click();
                break;
            case 2:
                calculatorButtonsOnSecondRowURL.get(buttonIndex).click();
                break;
            case 3:
                calculatorButtonsOnThirdRowURL.get(buttonIndex).click();
                break;
            case 4:
                calculatorButtonsOnFourthRowURL.get(buttonIndex).click();
                break;
            case 5:
                calculatorButtonsOnFifthRowURL.get(buttonIndex).click();
                break;
        }
    }

    //Получение результата вычисления
    public String getCalculateResult() {
        //Экран калькулятора
        //WebElement calculatorScreen = calculator.findElement(By.xpath(".//div[@class = 'calculator__screen']"));
        //return calculatorScreen
        //        .findElement(By.xpath(".//span[@class = 'calculator-display__result']")).getAttribute("innerHTML");
        return resultStringOnScreen.getAttribute("innerHTML");
    }

    //Проверка на существование Яндекс калькулятора
    public  boolean  existCalculator() {
        try {
            if (calculator.getAttribute("data-fast-name").equals("calculator")){
                initCalculatorElements();
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void initCalculatorElements() {
        //Локатор экрана калькулятора
        calculatorScreen = calculator.findElement(By.xpath(".//div[@class = 'calculator__screen']"));
        //Локатор результата на экране калькулятора
        resultStringOnScreen = calculatorScreen
                               .findElement(By.xpath(".//span[@class = 'calculator-display__result']"));
        //Панель кнопок калькулятора
        calculatorButtonsPanelURL = calculator
                .findElements(By.xpath(".//div[@class = 'calculator__row']"));
        //Локатор первой строки кнопок на панели
        calculatorButtonsOnFirstRowURL = calculatorButtonsPanelURL.get(0).findElements(By.tagName("button"));
        //Локатор второй строки кнопок на панели
        calculatorButtonsOnSecondRowURL = calculatorButtonsPanelURL.get(1).findElements(By.tagName("button"));
        //Локатор третьей строки кнопок на панели
        calculatorButtonsOnThirdRowURL = calculatorButtonsPanelURL.get(2).findElements(By.tagName("button"));
        //Локатор четвертой строки кнопок на панели
        calculatorButtonsOnFourthRowURL = calculatorButtonsPanelURL.get(3).findElements(By.tagName("button"));
        //Локатор пятой строки кнопок на панели
        calculatorButtonsOnFifthRowURL = calculatorButtonsPanelURL.get(4).findElements(By.tagName("button"));
        //Кнопки <имя кнопки, индекс кнопки на панели кнопок>
        //Старший разряд индекса  - номер строки кнопок на панели (1..5)
        //Младший разряд индекса - индекс кнопки в строке (0..7)
        calculatorBbuttonsNames = new HashMap<>();
        calculatorBbuttonsNames.put("xpy",10);
        calculatorBbuttonsNames.put("x!",11);
        calculatorBbuttonsNames.put("+-",12);
        calculatorBbuttonsNames.put("C",13);
        calculatorBbuttonsNames.put("()",14);
        calculatorBbuttonsNames.put("%",15);
        calculatorBbuttonsNames.put("/",16);
        calculatorBbuttonsNames.put("asin",20);
        calculatorBbuttonsNames.put("sin",21);
        calculatorBbuttonsNames.put("1/x",22);
        calculatorBbuttonsNames.put("7",23);
        calculatorBbuttonsNames.put("8",24);
        calculatorBbuttonsNames.put("9",25);
        calculatorBbuttonsNames.put("*",26);
        calculatorBbuttonsNames.put("acos",30);
        calculatorBbuttonsNames.put("cos",31);
        calculatorBbuttonsNames.put("sqrt",32);
        calculatorBbuttonsNames.put("4",33);
        calculatorBbuttonsNames.put("5",34);
        calculatorBbuttonsNames.put("6",35);
        calculatorBbuttonsNames.put("-",36);
        calculatorBbuttonsNames.put("atan",40);
        calculatorBbuttonsNames.put("tan",41);
        calculatorBbuttonsNames.put("ln",42);
        calculatorBbuttonsNames.put("1",43);
        calculatorBbuttonsNames.put("2",44);
        calculatorBbuttonsNames.put("3",45);
        calculatorBbuttonsNames.put("+",46);
        calculatorBbuttonsNames.put("lg",50);
        calculatorBbuttonsNames.put("pi",51);
        calculatorBbuttonsNames.put("e",52);
        calculatorBbuttonsNames.put("0",53);
        calculatorBbuttonsNames.put(",",54);
        calculatorBbuttonsNames.put("=",55);
    }
}
