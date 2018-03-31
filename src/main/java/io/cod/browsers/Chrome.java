package io.cod.browsers;

import io.github.sskorol.config.XmlConfig;
import io.github.sskorol.core.Browser;
import org.openqa.selenium.Capabilities;

public class Chrome implements Browser {

    public Name name() {
        return Browser.Name.Chrome;
    }

    //для настройки удаленного запуска нужно перезаписать метод, указать юрл
//    @Override
//    public boolean isRemote() {
//        return true;
//    }
//    @Override
//    public String url(){
//        return null;
//    }
//
//    @Override
//    public Capabilities configuration(XmlConfig config) {
//        return null;
//    }
}
