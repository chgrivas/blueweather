package com.blueweather.mapper;

import com.blueweather.api.dto.WeatherResponseDto;
import com.blueweather.gateway.dto.WundergroundDailyResponseDto;
import org.springframework.stereotype.Component;

/**
 * Class that handles converting wunderground weather response to internal dto.
 *
 * @author cgrivas
 */
@Component
public class WundergroundResponseMapperImpl implements WundergroundResponseMapper {

    @Override
    public WeatherResponseDto convertToWeatherResponseDto(WundergroundDailyResponseDto wundergroundDailyResponseDto) {
        WeatherResponseDto weatherResponseDto = new WeatherResponseDto();
        weatherResponseDto.setMaxHumidity(extractMaxHumidity(wundergroundDailyResponseDto));
        weatherResponseDto.setMaxTemperatureInCelcius(extractMaxTemperatureInCelcius(wundergroundDailyResponseDto));
        weatherResponseDto.setMinTemperatureInCelcius(extractMinTemperatureInCelcius(wundergroundDailyResponseDto));
        weatherResponseDto.setPrecipitation(extractPrecipitation(wundergroundDailyResponseDto));
        return weatherResponseDto;
    }

    String extractPrecipitation(WundergroundDailyResponseDto wundergroundDailyResponseDto) {
        return wundergroundDailyResponseDto.getHistory().getDailysummary().get(0).getPrecipm();
    }

    String extractMinTemperatureInCelcius(WundergroundDailyResponseDto wundergroundDailyResponseDto) {
        return wundergroundDailyResponseDto.getHistory().getDailysummary().get(0).getMintempm();
    }

    String extractMaxTemperatureInCelcius(WundergroundDailyResponseDto wundergroundDailyResponseDto) {
        return wundergroundDailyResponseDto.getHistory().getDailysummary().get(0).getMaxtempm();
    }

    String extractMaxHumidity(WundergroundDailyResponseDto wundergroundDailyResponseDto) {
        return wundergroundDailyResponseDto.getHistory().getDailysummary().get(0).getMaxhumidity();
    }
}
