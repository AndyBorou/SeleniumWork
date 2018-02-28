package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.WebDriverListener.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

public class SearchPage {

    //initilized on once
    private By inputsearch = By.cssSelector("#lst-ib");
    private By linkSearchResult = By.cssSelector("#rso h3 > a");

    // rivate By inputsearch = By.cssSelector("#lst-ib"); the same
    @FindBy(css = "lst-ib")
    private WebElement wInputSearch;

    public SearchPage search(final String text) {
       // wInputSearch.sendKeys(text);
        final WebDriverWait wait = new WebDriverWait(getDriver(), 5);
      //  visibilityOfAllElementsLocatedBy

        wait.until(elementToBeClickable(inputsearch)).sendKeys(text);

        getDriver().findElement(inputsearch).sendKeys(text);
        return this;
    }

    public int getLinksAmount () {
        return getDriver().findElements(linkSearchResult).size();

    }
}
