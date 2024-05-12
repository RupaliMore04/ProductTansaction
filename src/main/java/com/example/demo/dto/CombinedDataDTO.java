package com.example.demo.dto;

import java.util.List;
import java.util.Map;

public class CombinedDataDTO {
    public CombinedDataDTO(TransactionDTO transactions2, StatisticsDTO statistics2, BarChartDataDTO barChartData2,
			PieChartDataDTO pieChartData2) {
		// TODO Auto-generated constructor stub
	}
	private List<TransactionDTO> transactions;
    private StatisticsDTO statistics;
    private Map<String, Integer> barChartData;
    private Map<String, Integer> pieChartData;

    // Constructors, getters, and setters
    // You'll need to implement these according to your requirements
}
