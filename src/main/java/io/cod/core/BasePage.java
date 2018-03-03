package io.cod.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static io.cod.BaseConfig.BASE_CONFIG;
import static io.cod.core.WebDriverListener.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {

    private final WebDriver driver;
    private  final WebDriverWait wait;

    public BasePage(){
        this.driver = getDriver();
        this.wait  = new WebDriverWait(driver, BASE_CONFIG.waittimeOut());
    }

//    public void type(final By locator, CharSequence text) {
//       wait.until(elementToBeClickable(locator)).sendKeys(text);
//    }
    //более короткая форма
    public void type2(final By locator, CharSequence text, final Function<By, ExpectedCondition<WebElement>> condition) {
        waitFor(locator, condition).sendKeys(text);
    }

//    public void click(final By locator) {
//        wait.until(elementToBeClickable(locator)).click();
//    }

    public void type2(final By locator, CharSequence text) {
        type2(locator, text, ExpectedConditions::visibilityOfElementLocated);
    }


    public void click2(final By locator,  final Function<By, ExpectedCondition<WebElement>> condition){
        waitFor(locator, condition).click();
    }

    protected void select(final By locator, final String text){
        new Select(waitFor(locator, ExpectedConditions::visibilityOfElementLocated))
        .selectByVisibleText(text);
    }

    private WebElement waitFor(final By locator, final Function<By, ExpectedCondition<WebElement>> condition){
        return wait.until(condition.apply(locator));
    }


}
