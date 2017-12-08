package com.blueweather.gateway.helper;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * Implementation of the time comparing functionality.
 *
 * @author cgrivas
 */
@Component
public class TimeComparatorImpl implements TimeComparator {

    private static final SimpleDateFormat daysOfInstantFormatter = new SimpleDateFormat("dd");
    private static final SimpleDateFormat minutesOfInstantFormatter = new SimpleDateFormat("mm");

    @Override
    public boolean isInTheSameMinuteWithLastCheck(Instant now, Instant lastInstantChecked) {
        Date nowDate = Date.from(now);
        Date lastDate = Date.from(lastInstantChecked);

        if (now.isAfter(lastInstantChecked) && now.minusSeconds(60).isBefore(lastInstantChecked)) {
            String formattedNow = minutesOfInstantFormatter.format(nowDate);
            String formattedLast = minutesOfInstantFormatter.format(lastDate);

            if (formattedNow.equals(formattedLast)) {
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean isInTheSameDayWithLastCheck(Instant now, Instant lastInstantChecked) {
        Date nowDate = Date.from(now);
        Date lastDate = Date.from(lastInstantChecked);

        if (now.isAfter(lastInstantChecked) && now.minusSeconds(3600 * 24).isBefore(lastInstantChecked)) {
            String formattedNow = daysOfInstantFormatter.format(nowDate);
            String formattedLast = daysOfInstantFormatter.format(lastDate);

            if (formattedNow.equals(formattedLast)) {
                return true;
            }

        }

        return false;
    }
}
