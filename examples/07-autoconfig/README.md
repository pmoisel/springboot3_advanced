# Autoconfig

http://localhost:8080/actuator/health


Ich möchte die in 07-01 erzeugten Health-Infos automatisch zum health-Endpoint in 08-02 hinzufügen. OHNE Änderungen an 07-02!

# Lösung
1) Neue Klasse `com.nterra.springbootadvanced.healthpublisher.MyResourceHealthIndicatorConfiguration`:
```
@AutoConfiguration
public class MyResourceHealthIndicatorConfiguration {

    @Bean
    public MyResourceHealthIndicator myResourceHealthIndicator(){
        return new MyResourceHealthIndicator();
    }
}
```
2) Neue Datei: `src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`
```
com.nterra.springbootadvanced.healthpublisher.MyResourceHealthIndicatorConfiguration
```
