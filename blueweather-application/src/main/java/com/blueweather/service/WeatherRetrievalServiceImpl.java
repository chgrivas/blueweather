package com.blueweather.service;

import com.blueweather.api.dto.WeatherResponseDto;
import com.blueweather.domain.enumeration.Place;
import com.blueweather.gateway.WeatherGateway;
import com.blueweather.gateway.dto.WundergroundDailyResponseDto;
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

    @Override
    public WeatherResponseDto getDailyWeatherSummary(Place place, Instant date) {
        WundergroundDailyResponseDto wundergroundDailyResponseDto = weatherGateway.getWeatherHistory(place, date);
        System.out.println(wundergroundDailyResponseDto.getHistory().getDailysummary().get(0).getMaxtempm());
        return new WeatherResponseDto(18);
    }
}
