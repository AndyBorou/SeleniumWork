package io.cod.pages;

import one.util.streamex.StreamEx;

public interface Page {

    Page navigateTo();

    default String url(){
        return "http://localhost";
    };
}
