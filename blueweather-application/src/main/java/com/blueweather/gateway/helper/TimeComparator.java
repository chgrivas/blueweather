package com.blueweather.gateway.helper;

import java.time.Instant;

/**
 * Interface abstracting time comparing functionality.
 *
 * @author cgrivas
 */
public interface TimeComparator {

    boolean isInTheSameMinuteWithLastCheck(Instant now, Instant lastInstantChecked);

    boolean isInTheSameDayWithLastCheck(Instant now, Instant lastInstantChecked);
}
