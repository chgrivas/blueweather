package com.blueweather.gateway;

import com.blueweather.domain.enumeration.Place;
import com.blueweather.gateway.dto.WundergroundDailyResponseDto;

import java.time.Instant;

/**
 * The connection gateway with the external weather resources.
 *
 * @author cgrivas
 */
public interface WeatherGateway {
    WundergroundDailyResponseDto getWeatherHistory(Place place, Instant instant);
}
