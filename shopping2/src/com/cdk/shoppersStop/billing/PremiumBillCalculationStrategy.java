package com.cdk.shoppersStop.billing;

import java.util.List;

public class PremiumBillCalculationStrategy extends AbstractCalcualtionStrategy  {

	List<DiscountRate> discountRates;
    // though we could create an abstarct class to encapsulate below method, we are still keeping in subclass because
	//we may have different implementation for calculation.   
	
	static IBillCalculationStrategy instance;
    
	
	static {
		instance = new PremiumBillCalculationStrategy();
	}

	private PremiumBillCalculationStrategy() {
		discountRates = DiscountsLoader.getDiscounts("myResources/premiumDiscounts.xml");

	}
	
	public static IBillCalculationStrategy getInstance() {
		return instance;
	}

	@Override
	public List<DiscountRate> getDiscountRates() {
		// TODO Auto-generated method stub
		return discountRates;
	}

}
