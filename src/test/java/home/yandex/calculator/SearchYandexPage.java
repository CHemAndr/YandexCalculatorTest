package home.yandex.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchYandexPage {

    public WebDriver driver;

    //Конструктор обращается к классу PageFactory, чтобы заработала аннотация @FindBy
    //Он инициализирует элементы страницы
    public SearchYandexPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    //======================элементы страницы==========================================

    //Строка поиска в Яндексе
    @FindBy(id = "text")
    public WebElement searchString;

    //Кнопка "Найти"
    @FindBy(xpath = "//button[text() = 'Найти']")
    public WebElement searchButton;



    //=======================методы работы с элементами страницы ================================

    //Ввод текста в строку поиска
    public void enterTextInSearchString (String text) {
        searchString.click();
        searchString.sendKeys(text);
    }

    //Нажать кнопку "Найти"
    public void clickSearchButton() {
        searchButton.click();
    }

}
