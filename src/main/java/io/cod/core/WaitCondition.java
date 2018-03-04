package io.cod.core;

import com.sun.media.jfxmedia.locator.LocatorCache;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

@Getter
@RequiredArgsConstructor
public enum WaitCondition {

    visible(ExpectedConditions::visibilityOfElementLocated),
    present(ExpectedConditions::presenceOfElementLocated),
    enabled(ExpectedConditions::elementToBeClickable),
    allVisible(ExpectedConditions::visibilityOfAllElementsLocatedBy),
    allPresent(ExpectedConditions::presenceOfAllElementsLocatedBy);

    private final Function<By, ExpectedCondition<?>> type;

}
