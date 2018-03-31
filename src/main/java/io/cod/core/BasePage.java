package io.cod.core;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import io.cod.pages.Page;
import io.github.sskorol.core.Browser;
import io.github.sskorol.listeners.BaseListener;
import io.qameta.allure.Step;
import io.vavr.Tuple;
import io.vavr.Tuple3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.cod.BaseConfig.BASE_CONFIG;
import static io.cod.core.WaitCondition.allPresent;
import static io.cod.core.WaitCondition.allVisible;
import static io.cod.core.WaitCondition.visible;
//import static io.cod.core.WebDriverListener.getDriver;
import static io.cod.utils.ElementTypeUtils.elementOf;
import static io.cod.utils.ElementTypeUtils.listOf;
import static io.cod.utils.ElementTypeUtils.streamOf;
import static io.github.sskorol.listeners.BaseListener.getDriverMetaData;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage implements Page {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        // вернет драйвер
        this.driver = getDriverMetaData()._1;
        // вернет драйвер с ожиданием
        this.wait = getDriverMetaData()._2;
        // переменна содержащая три разных типа
        // Tuple3<String, Integer, Double> string = Tuple.of("string", 1, 0.1);

        //   this.driver = getDriver();
     //   this.wait = new WebDriverWait(driver, BASE_CONFIG.waittimeOut());
    }

//    public void type(final By locator, CharSequence text) {
//       wait.until(elementToBeClickable(locator)).sendKeys(text);
//    }
    //более короткая форма
//    public void type2(final By locator, CharSequence text, final Function<By, ExpectedCondition<WebElement>> condition) {
//        waitFor(locator, condition).sendKeys(text);
//    }


//    public void click(final By locator) {
//        wait.until(elementToBeClickable(locator)).click();
//    }

//    public void type2(final By locator, CharSequence text) {
//        type2(locator, text, ExpectedConditions::visibilityOfElementLocated);
//    }


//    public void click2(final By locator,  final Function<By, ExpectedCondition<WebElement>> condition){
//        waitFor(locator, condition).click();
//    }


//    private WebElement waitFor(final By locator, final Function<By, ExpectedCondition<WebElement>> condition){
//        return wait.until(condition.apply(locator));
//    }

//    public void type3(final By locator, CharSequence text, final WaitCondition condition) {
//        ((WebElement)waitFor(locator, condition)).sendKeys(text);
//    }

//    public void type3(final By locator, CharSequence text, final WaitCondition condition) {
//        elementOf((WebElement) waitFor(locator, condition)).sendKeys(text);
//    }

    //    public void type3(final By locator, CharSequence text) {
//        type3(locator, text, visible);
//    }

    //    public void click3(final By locator, final WaitCondition condition) {
//        waitFor(locator, condition).click();
//    }

    //    private <W> W waitFor(final By locator, final WaitCondition condition) {
//        return (W) wait.until(condition.getType().apply(locator, ""));
//    }

    public void type4(final By locator, CharSequence text, final WaitCondition condition) {
        elementOf(waitFor(locator, "", condition)).sendKeys(text);
    }

    public void type4(final By locator, CharSequence text) {
        type4(locator, text, visible);
    }



    protected void select(final By locator, final String text) {
        new Select(waitFor(locator,"",  visible))
                .selectByVisibleText(text);
    }

    public List<String> getTextNodes(final By locator) {
        return getTextNodes(locator, allPresent);
    }

    public List<String> getTextNodes(final By locator, final WaitCondition condition) {
        return streamOf(waitFor(locator, "", condition))
                .map(WebElement::getText)
                .toList();
    }

    @SuppressWarnings("unchecked")
    private <T, V, R> R waitFor(final T arg1, final V arg2, final WaitCondition condition) {
        return (R) wait.until((Function<WebDriver, ? >) condition.getType().apply(arg1, arg2));
    }

//    @Step("Navigate to {browser.name}") example
//    public Page navigateTo(final Browser browser)
    @Step("Navigate to {url}")
    public Page navigateTo(final String url) {
        driver.get(url());
        return this;
    }



}
