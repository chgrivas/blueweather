package com.blueweather.service;

import com.blueweather.api.dto.WeatherResponseDto;
import com.blueweather.domain.enumeration.Place;
import com.blueweather.gateway.WeatherGateway;
import com.blueweather.gateway.dto.WundergroundDailyResponseDto;
import com.blueweather.mapper.WundergroundResponseMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * A weather retrieval information service.
 *
 * @author cgrivas
 */
@Component
public class WeatherRetrievalServiceImpl implements WeatherRetrievalService {

    @Autowired
    private WeatherGateway weatherGateway;

    @Autowired
    private WundergroundResponseMapperImpl wundergroundResponseMapperImpl;

    @Override
    public WeatherResponseDto getDailyWeatherSummary(Place place, Instant date) {
        WundergroundDailyResponseDto wundergroundDailyResponseDto = weatherGateway.getWeatherHistory(place, date);
        return wundergroundResponseMapperImpl.convertToWeatherResponseDto(wundergroundDailyResponseDto);
    }
}
