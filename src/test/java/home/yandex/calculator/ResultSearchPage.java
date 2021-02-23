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
    List<WebElement> calculatorButtonsPanelURL;
    List<WebElement> calculatorButtonsOnFirstRowURL;
    List<WebElement> calculatorButtonsOnSecondRowURL;
    List<WebElement> calculatorButtonsOnThirdRowURL;
    List<WebElement> calculatorButtonsOnFourthRowURL;
    List<WebElement> calculatorButtonsOnFifthRowURL;
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
        // Кнопки из первой строки
        if (buttonName.equals("/")) {
            calculatorButtonsOnFirstRowURL.get(6).click();}
        if (buttonName.equals("C")) {
            calculatorButtonsOnFirstRowURL.get(3).click();}
        // Кнопки из второй строки
        if (buttonName.equals("7")) {
            calculatorButtonsOnSecondRowURL.get(3).click();}
        if (buttonName.equals("8")) {
            calculatorButtonsOnSecondRowURL.get(4).click();}
        if (buttonName.equals("9")) {
            calculatorButtonsOnSecondRowURL.get(5).click();}
        if (buttonName.equals("*")) {
            calculatorButtonsOnSecondRowURL.get(6).click();}
        // Кнопки из третьей строки
        if (buttonName.equals("4")) {
            calculatorButtonsOnThirdRowURL.get(3).click();}
        if (buttonName.equals("5")) {
            calculatorButtonsOnThirdRowURL.get(4).click();}
        if (buttonName.equals("6")) {
            calculatorButtonsOnThirdRowURL.get(5).click();}
        if (buttonName.equals("sqrt")) {
            calculatorButtonsOnThirdRowURL.get(2).click();}
        if (buttonName.equals("cos")) {
            calculatorButtonsOnThirdRowURL.get(1).click();}
        // Кнопки из четвертой строки
        if (buttonName.equals("1")) {
            calculatorButtonsOnFourthRowURL.get(3).click();}
        if (buttonName.equals("2")) {
            calculatorButtonsOnFourthRowURL.get(4).click();}
        if (buttonName.equals("3")) {
            calculatorButtonsOnFourthRowURL.get(5).click();}
        // Кнопки из пятой строки
        if (buttonName.equals("0")) {
            calculatorButtonsOnFifthRowURL.get(3).click();}
        if (buttonName.equals("=")) {
            calculatorButtonsOnFifthRowURL.get(5).click();}
        if (buttonName.equals(",")) {
            calculatorButtonsOnFifthRowURL.get(4).click();}
        if (buttonName.equals("pi")) {
            calculatorButtonsOnFifthRowURL.get(1).click();}
    }

    //Получение результата вычисления
    public String getCalculateResult() {
        //Экран калькулятора
        WebElement calculatorScreen = calculator.findElement(By.xpath(".//div[@class = 'calculator__screen']"));
        return calculatorScreen
                .findElement(By.xpath(".//span[@class = 'calculator-display__result']")).getAttribute("innerHTML");
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
        //Панель кнопок калькулятора
        calculatorButtonsPanelURL = calculator
                .findElements(By.xpath(".//div[@class = 'calculator__row']"));
        //Первая строка кнопок панели
        calculatorButtonsOnFirstRowURL = calculatorButtonsPanelURL.get(0).findElements(By.tagName("button"));
        //Вторая строка кнопок панели
        calculatorButtonsOnSecondRowURL = calculatorButtonsPanelURL.get(1).findElements(By.tagName("button"));
        //Третия строка кнопок панели
        calculatorButtonsOnThirdRowURL = calculatorButtonsPanelURL.get(2).findElements(By.tagName("button"));
        //Четвертая строка кнопок панели
        calculatorButtonsOnFourthRowURL = calculatorButtonsPanelURL.get(3).findElements(By.tagName("button"));
        //Пятая строка кнопок панели
        calculatorButtonsOnFifthRowURL = calculatorButtonsPanelURL.get(4).findElements(By.tagName("button"));
        //Кнопки
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
