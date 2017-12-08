package com.blueweather.gateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The expected response object with the daily information.
 *
 * @author cgrivas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WundergroundDailyResponseDto {

    private HistoryDto history;

    public HistoryDto getHistory() {
        return history;
    }

    public void setHistory(HistoryDto history) {
        this.history = history;
    }
}
