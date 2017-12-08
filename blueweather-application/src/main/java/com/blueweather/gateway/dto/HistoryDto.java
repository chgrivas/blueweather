package com.blueweather.gateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * The history DTO in www.wunderground.com daily response.
 *
 * @author cgrivas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistoryDto {

    private List<DailySummaryDto> dailysummary;

    public List<DailySummaryDto> getDailysummary() {
        return dailysummary;
    }

    public void setDailysummary(List<DailySummaryDto> dailysummary) {
        this.dailysummary = dailysummary;
    }
}
