package com.hpcreation.portfolioBackendApp.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TimeUtils {
    private TimeUtils() {
    }
    public static Instant now() {
        return Instant.now().truncatedTo(ChronoUnit.MILLIS);
    }
}
