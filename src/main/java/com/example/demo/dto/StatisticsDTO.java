package com.example.demo.dto;

public class StatisticsDTO 
{
    private double totalSaleAmount;
    private int totalSoldItems;
    private int totalNotSoldItems;
	public StatisticsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatisticsDTO(double totalSaleAmount, int totalSoldItems, int totalNotSoldItems) {
		super();
		this.totalSaleAmount = totalSaleAmount;
		this.totalSoldItems = totalSoldItems;
		this.totalNotSoldItems = totalNotSoldItems;
	}
	public double getTotalSaleAmount() {
		return totalSaleAmount;
	}
	public void setTotalSaleAmount(double totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}
	public int getTotalSoldItems() {
		return totalSoldItems;
	}
	public void setTotalSoldItems(int totalSoldItems) {
		this.totalSoldItems = totalSoldItems;
	}
	public int getTotalNotSoldItems() {
		return totalNotSoldItems;
	}
	public void setTotalNotSoldItems(int totalNotSoldItems) {
		this.totalNotSoldItems = totalNotSoldItems;
	}

   
}
