package com.blueweather.gateway;

import com.blueweather.domain.enumeration.Place;
import com.blueweather.gateway.dto.WundergroundDailyResponseDto;
import com.blueweather.gateway.helper.TimeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * The weather retrieval gateway using https://www.wunderground.com
 *
 * @author cgrivas
 */
@Component
public class WeatherGatewayImpl implements WeatherGateway {
    private static final SimpleDateFormat wundergroundDateFormatter = new SimpleDateFormat("yyyyMMdd");

    private static Instant lastInstantChecked = Instant.now();
    private static int currentMinuteCalls = 0;
    private static int currentDayCalls = 0;

    @Autowired
    private TimeComparator timeComparator;

    @Value("${wunderground.api.url.history}")
    private String historyUrl;

    @Value("${wunderground.api.token}")
    private String token;

    @Value("${wunderground.api.limit.minute}")
    private int minuteLimit;

    @Value("${wunderground.api.limit.day}")
    private int dailyLimit;

    @Override
    public WundergroundDailyResponseDto getWeatherHistory(Place place, Instant instant) {
        String formattedUrl = String.format(historyUrl, token, formatInstantForPathParam(instant), place.getWundergroundName());
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(formattedUrl);

        checkTokenAvailability();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uriBuilder.toUriString(), WundergroundDailyResponseDto.class);
    }

    private synchronized void checkTokenAvailability() {
        Instant now = Instant.now();

       if (timeComparator.isInTheSameMinuteWithLastCheck(now, lastInstantChecked)) {
           currentMinuteCalls++;
       } else {
           currentMinuteCalls = 1;
       }

        if (currentMinuteCalls > minuteLimit) {
           throw new IllegalStateException();
       }

       if (timeComparator.isInTheSameDayWithLastCheck(now, lastInstantChecked)) {
           currentDayCalls++;
       } else {
           currentDayCalls = 1;
       }

       if (currentDayCalls > dailyLimit) {
           throw new IllegalStateException();
       }

        lastInstantChecked = now;
    }

    private String formatInstantForPathParam(Instant instant) {
        return "20171030";
    }
}
