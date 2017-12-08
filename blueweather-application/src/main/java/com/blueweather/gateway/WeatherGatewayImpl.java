package com.blueweather.gateway;

import com.blueweather.domain.enumeration.Place;
import com.blueweather.gateway.dto.WundergroundDailyResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.MessageFormat;
import java.time.Instant;

/**
 * The weather retrieval gateway using https://www.wunderground.com
 *
 * @author cgrivas
 */
@Component
public class WeatherGatewayImpl implements WeatherGateway {

    @Value("${wunderground.api.url.history}")
    private String historyUrl;

    @Value("${wunderground.api.token}")
    private String token;

    @Override
    public WundergroundDailyResponseDto getWeatherHistory(Place place, Instant instant) {
        String formattedUrl = String.format(historyUrl, token, formatInstantForPathParam(instant), place.getWundergroundName());
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(formattedUrl);
        return restTemplate.getForObject(uriBuilder.toUriString(), WundergroundDailyResponseDto.class);
    }

    private String formatInstantForPathParam(Instant instant) {
        return "20171030";
    }
}
