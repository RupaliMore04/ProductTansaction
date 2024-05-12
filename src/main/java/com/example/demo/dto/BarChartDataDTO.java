package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class BarChartDataDTO {
    private Map<String, Integer> priceRanges;

    public BarChartDataDTO() {
        this.priceRanges = new HashMap<>();
    }

    public Map<String, Integer> getPriceRanges() {
        return priceRanges;
    }

    public void setPriceRanges(Map<String, Integer> priceRanges) {
        this.priceRanges = priceRanges;
    }
}

