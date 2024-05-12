package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class PieChartDataDTO {
    private Map<String, Integer> categoryCounts;

    public PieChartDataDTO() {
        this.categoryCounts = new HashMap<>();
    }

    public Map<String, Integer> getCategoryCounts() {
        return categoryCounts;
    }

    public void setCategoryCounts(Map<String, Integer> categoryCounts) {
        this.categoryCounts = categoryCounts;
    }
}
