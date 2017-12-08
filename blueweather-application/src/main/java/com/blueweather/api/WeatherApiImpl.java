package com.blueweather.api;

import com.blueweather.api.dto.WeatherResponseDto;
import com.blueweather.domain.enumeration.Place;
import com.blueweather.service.WeatherRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

@RestController
public class WeatherApiImpl implements WeatherApi, ErrorController
{
  private static final String MAX_HUMIDITY_LABEL = "Max percentage humidity";
  private static final String MAX_TEMPERATURE_LABEL = "Max Temp in C";
  private static final String MIN_TEMPERATURE_LABEL = "Min Temp in C";
  private static final String PRECIPATION_LABEL = "Precipation in mm";
  private static final String FILE_KEY_VALUE_SEPARATOR = ": ";

  private static final String PATH = "/error";

  @Autowired
  private WeatherRetrievalService weatherRetrievalService;

  @Autowired
  private ErrorAttributes errorAttributes;

  @Override
  public void getDefaultWeather(HttpServletResponse response) {
    WeatherResponseDto weatherResponseDto = weatherRetrievalService.getDailyWeatherSummary(Place.NEW_YORK, Instant.now());
    constructResponse(response, weatherResponseDto);
  }

  private void constructResponse(HttpServletResponse response, WeatherResponseDto weatherResponseDto) {
    try {

      response.setContentType("text/html");
      response.setHeader("charset", "utf-8");
      response.setHeader("Content-Disposition", "attachment; filename=somefile.txt");

      response.getWriter().println(MAX_HUMIDITY_LABEL + FILE_KEY_VALUE_SEPARATOR + weatherResponseDto.getMaxHumidity());
      response.getWriter().println(MAX_TEMPERATURE_LABEL + FILE_KEY_VALUE_SEPARATOR + weatherResponseDto.getMaxTemperatureInCelcius());
      response.getWriter().println(MIN_TEMPERATURE_LABEL + FILE_KEY_VALUE_SEPARATOR + weatherResponseDto.getMinTemperatureInCelcius());
      response.getWriter().println(PRECIPATION_LABEL + FILE_KEY_VALUE_SEPARATOR + weatherResponseDto.getPrecipitation());

      response.flushBuffer();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getErrorPath() {
    return PATH;
  }

  @RequestMapping(value = PATH)
  ResponseEntity<String> error(HttpServletResponse response) {
    HttpHeaders responseHeaders = new HttpHeaders();
    HttpStatus httpStatus = HttpStatus.valueOf(response.getStatus());
    return new ResponseEntity<>("Cannot Process Your Request Right Now! Please Contact the Administrator for more detail.", responseHeaders, httpStatus);
  }
}
