package com.blueweather.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

public interface WeatherApi {

    @RequestMapping(method = RequestMethod.GET, value = "/api/weather/default")
    void getDefaultWeather(HttpServletResponse response);

}
