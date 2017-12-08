package com.blueweather.mapper;

import com.blueweather.api.dto.WeatherResponseDto;
import com.blueweather.gateway.dto.WundergroundDailyResponseDto;

/**
 * Interface of mapper to convert wunderground response according to services needs.
 *
 * @author cgrivas
 */
public interface WundergroundResponseMapper {
    WeatherResponseDto convertToWeatherResponseDto(WundergroundDailyResponseDto wundergroundDailyResponseDto);
}
