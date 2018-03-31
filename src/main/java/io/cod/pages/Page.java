package io.cod.pages;


import io.cod.BaseConfig;

import static io.cod.BaseConfig.BASE_CONFIG;

public interface Page {

    default Page navigateTo(){
       return navigateTo(url());
    }

    Page navigateTo(String url);

    default String url(){
        return BASE_CONFIG.url();
    };
}
