package ge.TechMarket.Tech_Market;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;


@Component
public class CheckProfileIndicator implements HealthIndicator {

    private final Environment environment;

    public CheckProfileIndicator(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Health health() {

        String[] allProfiles = {"dev", "prod"};

        Health.Builder builder = Health.up().withDetail("environment", "profile status");

        for (String profile : allProfiles) {
            boolean isActive = isProfileActive(profile);
            builder.withDetail(profile, isActive ? "active" : "inactive");
        }

        return builder.build();
    }

    private boolean isProfileActive(String profile) {
        for (String activeProfile : environment.getActiveProfiles()) {
            if (activeProfile.equalsIgnoreCase(profile)) {
                return true;
            }
        }
        return false;
    }
}
