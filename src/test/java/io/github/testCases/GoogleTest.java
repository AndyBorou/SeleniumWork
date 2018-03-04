package io.github.testCases;

import io.cod.BaseConfig;
import io.cod.core.PageFactoty;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import io.cod.pages.SearchPage;


import static io.cod.BaseConfig.BASE_CONFIG;
import static io.cod.core.PageFactoty.at;
import static io.cod.core.PageFactoty.open;
import static io.cod.core.WebDriverListener.getDriver;
import static org.testng.Assert.assertEquals;

public class GoogleTest { //extends BaseTest {

//    @Test
//    public void test1() throws InterruptedException {
//        // WebDriverManager сам скачиваает указанный драйвер
//
//        getDriver().get("https://www.google.com");
//        getDriver().findElement(By.cssSelector("#lst-ib")).sendKeys("auto", Keys.ENTER);;
//
//        Assert.assertEquals(getDriver().findElements(By.cssSelector("#rso h3 > a")).size(), 13);
//        Thread.sleep(5000);
//
//    }

    @Test
    public void test1(){
        // WebDriverManager сам скачиваает указанный драйвер
        //getDriver().get("https://www.google.com");
        //получение переменной окружения из настройек запуска тестнг,градле
//        getDriver().get(System.getenv("URL"));
//        System.out.println(System.getenv("JAVA_HOME") + " System.getenv");
//        System.out.println(System.getenv("URL")+ " System.getenv");

        //initilize all Autotest annotations like  @FindBy(css = "lst-ib")


//        getDriver().get(System.getenv("URL"));
//
//        final SearchPage searchPage = PageFactory.initElements(getDriver(), SearchPage.class);
//
//        getDriver().get(BASE_CONFIG.url());

        open(SearchPage.class)
                .searchFor("auto");

        // assertEquals(getDriver().findElements(By.cssSelector("#rso h3 > a")).size(), 13);

        assertEquals(at(SearchPage.class).getLinksAmount(), 13);
      }

    @Test
    public void test2(){

        open(SearchPage.class)
                .searchFor("auto");



    }

}
