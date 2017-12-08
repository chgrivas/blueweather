package com.blueweather.api.dto;

public class WeatherResponseDto {

    private String maxTemperatureInCelcius;
    private String minTemperatureInCelcius;
    private String maxHumidity;
    private String precipitation;

    public String getMaxHumidity() {
        return maxHumidity;
    }

    public void setMaxHumidity(String maxHumidity) {
        this.maxHumidity = maxHumidity;
    }

    public String getMaxTemperatureInCelcius() {
        return maxTemperatureInCelcius;
    }

    public void setMaxTemperatureInCelcius(String maxTemperatureInCelcius) {
        this.maxTemperatureInCelcius = maxTemperatureInCelcius;
    }

    public String getMinTemperatureInCelcius() {
        return minTemperatureInCelcius;
    }

    public void setMinTemperatureInCelcius(String minTemperatureInCelcius) {
        this.minTemperatureInCelcius = minTemperatureInCelcius;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }
}
