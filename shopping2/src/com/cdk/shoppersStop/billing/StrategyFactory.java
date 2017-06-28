package com.cdk.shoppersStop.billing;

public class StrategyFactory {
    public static IBillCalculationStrategy getStrategy(String customerType) {
    	
    	IBillCalculationStrategy strategy=null;
    	if(customerType.equals("premium")) {
			strategy=PremiumBillCalculationStrategy.getInstance();
		}else {
			strategy=RegularBillCalculationStrategy.getInstance();
		}
    	return strategy;
    	
    }
}
