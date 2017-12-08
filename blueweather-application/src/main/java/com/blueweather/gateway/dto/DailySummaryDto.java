package com.blueweather.gateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The daily summery DTO in www.wunderground.com daily response.
 *
 * @author cgrivas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DailySummaryDto {

    private String precipm;
    private String maxtempm;
    private String mintempm;
    private String maxhumidity;

    public String getPrecipm() {
        return precipm;
    }

    public void setPrecipm(String precipm) {
        this.precipm = precipm;
    }

    public String getMaxtempm() {
        return maxtempm;
    }

    public void setMaxtempm(String maxtempm) {
        this.maxtempm = maxtempm;
    }

    public String getMintempm() {
        return mintempm;
    }

    public void setMintempm(String mintempm) {
        this.mintempm = mintempm;
    }

    public String getMaxhumidity() {
        return maxhumidity;
    }

    public void setMaxhumidity(String maxhumidity) {
        this.maxhumidity = maxhumidity;
    }
}
