package com.blueweather.service;

import com.blueweather.api.dto.WeatherResponseDto;
import com.blueweather.domain.enumeration.Place;

import java.time.Instant;

/**
 * The weather retrieval supported operations.
 *
 * @author cgrivas
 */
public interface WeatherRetrievalService {

    WeatherResponseDto getDailyWeatherSummary(Place place, Instant date);
}
