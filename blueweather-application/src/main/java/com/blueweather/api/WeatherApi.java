package com.blueweather.api;

import com.blueweather.api.dto.WeatherResponseDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface WeatherApi {

    @RequestMapping(method = RequestMethod.GET, value = "/api/weather/default")
    WeatherResponseDto getDefaultWeather();

}
