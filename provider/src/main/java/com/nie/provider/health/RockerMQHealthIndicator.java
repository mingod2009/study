package com.nie.provider.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RockerMQHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		String errorCode = "10001";
		if (errorCode != null) {
			return Health.down().withDetail("Error Code", errorCode).build();
		}
		return Health.up().build();
	}

}
