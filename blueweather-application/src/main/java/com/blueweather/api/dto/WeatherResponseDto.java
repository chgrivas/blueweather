package com.blueweather.api.dto;

public class WeatherResponseDto {

    private Integer temp;

    public WeatherResponseDto(Integer temp) {
        this.temp = temp;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }
}
