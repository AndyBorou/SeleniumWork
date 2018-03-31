package io.cod;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

//подключение интерфейса aeonbits
//Reloadable обновление конфигурации прооперти

@Config.LoadPolicy(Config.LoadType.MERGE) // если есть одинаковые проперти
@Config.Sources("classpath:config.properties")
public interface BaseConfig  extends Config, Reloadable{

    BaseConfig BASE_CONFIG = ConfigFactory.create(BaseConfig.class, System.getenv(), System.getProperties());

    @Key("explicit.wait.timeout") // имя ключа
    @DefaultValue("3")
    long waittimeOut();

    @Key("url")
    @DefaultValue("http://localhost")
    String url();
}
