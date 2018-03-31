package io.cod.core;

import lombok.experimental.UtilityClass;
import org.joor.Reflect;

import static org.joor.Reflect.on;


@UtilityClass
public class PageFactoty {

    @SuppressWarnings("unchecked")
    public static <T extends BasePage> T open(final Class<T> pageClass){

        return (T) at(pageClass).navigateTo();
    }

    @SuppressWarnings("unchecked")
    public static <T extends BasePage> T at(final Class<T> pageClass){
        return on(pageClass).create().get();
    }

}
