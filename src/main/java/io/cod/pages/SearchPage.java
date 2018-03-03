package io.cod.pages;

import io.cod.BaseConfig;
import io.cod.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static io.cod.core.WebDriverListener.getDriver;


public class SearchPage extends BasePage {

    //initilized on once
    private By inputsearch = By.cssSelector("#lst-ib");
    private By linkSearchResult = By.cssSelector("#rso h3 > a");

    // rivate By inputsearch = By.cssSelector("#lst-ib"); the same
    @FindBy(css = "lst-ib")
    private WebElement wInputSearch;

    public SearchPage search(final String text) {
        // wInputSearch.sendKeys(text);
//      final WebDriverWait wait = new WebDriverWait(getDriver(), BASE_CONFIG.waittimeOut());
        //  visibilityOfAllElementsLocatedBy
//       wait.until(elementToBeClickable(inputsearch)).sendKeys(text);
//        getDriver().findElement(inputsearch).sendKeys(text);

        type2(inputsearch, text, ExpectedConditions::elementToBeClickable);
        type2(inputsearch, text, ExpectedConditions::visibilityOfElementLocated);
        type2(inputsearch, text, ExpectedConditions::presenceOfElementLocated);

        type2(inputsearch, text);

        return this;
    }


    private Input inputsearchInput = By.cssSelector("#lst-ib");
    private List<Link> linkSearchResultList = By.cssSelector("#rso h3 > a");

    public SearchPage search2(final String text) {
        inputsearchInput.type(text);
        type2(inputsearchInput, text);

        return this;
    }


    public int getLinksAmount() {
        return getDriver().findElements(linkSearchResult).size();

    }
}
