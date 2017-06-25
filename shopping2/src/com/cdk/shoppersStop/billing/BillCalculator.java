package com.cdk.shoppersStop.billing;

public class BillCalculator {
	//having ref of strategy to apply algo dynamically
    IBillCalculationStrategy strategy;
    
	public void setStrategy(IBillCalculationStrategy strategy) {
		this.strategy = strategy;
		
		
	
	}
	
	public float calculate(float purchaseAmount) {
		return strategy.calculate(purchaseAmount);
	}
    
}
