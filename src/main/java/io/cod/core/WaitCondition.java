package io.cod.core;
//
//import com.sun.media.jfxmedia.locator.LocatorCache;
//import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.BiFunction;
import java.util.function.Function;

//@Getter
@RequiredArgsConstructor
public enum WaitCondition {

    visible(ExpectedConditions::visibilityOfElementLocated),
    present(ExpectedConditions::presenceOfElementLocated),
    enabled((Function<By, ExpectedCondition<?>>) ExpectedConditions::elementToBeClickable),
    allVisible(ExpectedConditions::visibilityOfAllElementsLocatedBy),
    allPresent(ExpectedConditions::presenceOfAllElementsLocatedBy);
//   valueToBe((BiFunction<By, String, ExpectedCondition<?>>) ExpectedConditions::textToBe),
//    attributeToBe(ExpectedConditions::attributeToBe);


//    private final Function<By, ExpectedCondition<?>> type;
    private final BiFunction<?, ?, ExpectedCondition<?>> type;

    <T, V> WaitCondition(final  Function<T, ExpectedCondition<?>> type){
         this((T arg1, V arg2) -> type.apply(arg1));
    }

    @SuppressWarnings("unchecked")
    public <T, V, R> BiFunction <T, V, R> getType(){
        return (BiFunction<T, V, R>) type;
    }

}
