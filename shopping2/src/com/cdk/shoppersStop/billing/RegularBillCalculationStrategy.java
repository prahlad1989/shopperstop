package com.cdk.shoppersStop.billing;

import java.util.List;

public class RegularBillCalculationStrategy extends AbstractCalcualtionStrategy {

	private List<DiscountRate> discountRates;
	// though we could create an abstarct class to encapsulate below method, we are still keeping in subclass because
	//we may have different implementation for calculation.
		
	

	private static IBillCalculationStrategy instance;

	public static IBillCalculationStrategy getInstance() {
		return instance;
	}

	
	static {
		instance = new RegularBillCalculationStrategy();
	}

	private RegularBillCalculationStrategy() {
		discountRates = DiscountsLoader.getDiscounts("myResources/regularDiscounts.xml");
	}

	@Override
	public List<DiscountRate> getDiscountRates() {
		// TODO Auto-generated method stub
		return discountRates;
	}

}
