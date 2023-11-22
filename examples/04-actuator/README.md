# Actuator

`docker-compose.yaml` starten!

Füge einen eigenen HealthIndicator hinzu!

# Lösung
neue Klasse `MyResourceHealthIndicator`:
```
@Component
public class MyResourceHealthIndicator implements HealthIndicator {

    @Autowired
    HealthToggleController c;

    @Override
    public Health health() {
        if (c.up) {
            return Health
                    .up()
                    .withDetail("owner", "Philipp Moisel")
                    .build();
        } else {
            return Health
                    .down()
                    .withDetail("owner", "Philipp Moisel")
                    .build();
        }
    }
}
```
