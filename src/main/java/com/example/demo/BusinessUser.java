package com.example.demo;

public class BusinessUser extends User {
	private  int revenue;
	private int expenses;
	private int machineryOrPlant;
	private int buildings;
	private int furnitureOrFixtures;
	private int vehicles;
	private int intangibles;
	
	public String tax() {
		float tax = 0;
		double income = revenue - expenses - (machineryOrPlant * 0.15) - 
				(buildings * 0.1) - (furnitureOrFixtures * 0.1) -
				(vehicles * 0.4) - (intangibles * 0.25);
		
		double netTaxableIncome = income;
		
		if(netTaxableIncome < 500000) {
			tax = 0;
		}else if (netTaxableIncome < 750000 && netTaxableIncome > 500000 ) {
			tax = (float) (netTaxableIncome * 0.1);
		}else if(netTaxableIncome < 1000000 && netTaxableIncome > 750000 ) {
			tax = (float) (netTaxableIncome * 0.15);
		}else if (netTaxableIncome > 1000000 && netTaxableIncome < 1250000 ) {
			tax = (float) (netTaxableIncome * 0.2);
		}else if (netTaxableIncome < 1500000 && netTaxableIncome > 1250000 ) {
			tax = (float) (netTaxableIncome * 0.25);
		}else if(netTaxableIncome > 1500000) {
			tax = (float) (netTaxableIncome * 0.3);
			
		}
		
		return "tax: " + tax;
	
	}
	
	@Override
	public String toString() {
		return "BusinessUser [revenue=" + revenue + ", expenses=" + expenses + ", machineryOrPlant=" + machineryOrPlant
				+ ", buildings=" + buildings + ", furnitureOrFixtures=" + furnitureOrFixtures + ", vehicles=" + vehicles
				+ ", intangibles=" + intangibles + "]";
	}

	public BusinessUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusinessUser(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public int getExpenses() {
		return expenses;
	}
	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}
	public int getMachineryOrPlant() {
		return machineryOrPlant;
	}
	public void setMachineryOrPlant(int machineryOrPlant) {
		this.machineryOrPlant = machineryOrPlant;
	}
	public int getBuildings() {
		return buildings;
	}
	public void setBuildings(int buildings) {
		this.buildings = buildings;
	}
	public int getFurnitureOrFixtures() {
		return furnitureOrFixtures;
	}
	public void setFurnitureOrFixtures(int furnitureOrFixtures) {
		this.furnitureOrFixtures = furnitureOrFixtures;
	}
	public int getVehicles() {
		return vehicles;
	}
	public void setVehicles(int vehicles) {
		this.vehicles = vehicles;
	}
	public int getIntangibles() {
		return intangibles;
	}
	public void setIntangibles(int intangibles) {
		this.intangibles = intangibles;
	}
	
	
}
