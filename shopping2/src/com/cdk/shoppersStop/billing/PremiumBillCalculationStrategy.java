package com.cdk.shoppersStop.billing;

import java.util.List;

public class PremiumBillCalculationStrategy implements IBillCalculationStrategy {

	private List<DiscountRate> discountRates;
  // though we could create an abstarct class to encapsulate below method, we are still keeping in subclass because
	//we may have different implementation for calculation.   
	
	@Override
	public float calculate(float purchaseAmount) {
		float totalDiscuount = 0;
		float tempBillAmount = purchaseAmount; //the current amount to be billed
		for (DiscountRate discountRate : discountRates) {
			if ((discountRate.getHighterAmount() == 0 && tempBillAmount>0) || discountRate.getLowerAmount() <= purchaseAmount
					&& discountRate.getHighterAmount() >= purchaseAmount) {
				//totalDiscuount += tempBillAmount * (discountRate.getPercentage()) / 100;
				totalDiscuount += (purchaseAmount-discountRate.getLowerAmount()+1) * (discountRate.getPercentage()) / 100;
				tempBillAmount -= (discountRate.getHighterAmount() - discountRate.getLowerAmount());
			} else if (discountRate.getLowerAmount() < purchaseAmount && tempBillAmount>0) {
				tempBillAmount -= (discountRate.getHighterAmount() - discountRate.getLowerAmount());
				totalDiscuount += (discountRate.getHighterAmount() - discountRate.getLowerAmount())
						* (discountRate.getPercentage()) / 100;
			}
		}
		return purchaseAmount - totalDiscuount;
	}
	private static IBillCalculationStrategy instance;
    
	
	
	public static IBillCalculationStrategy getInstance() {
		return instance;
	}

	static {
		instance = new PremiumBillCalculationStrategy();
	}

	private PremiumBillCalculationStrategy() {
		discountRates = DiscountsLoader.getDiscounts("myResources/premiumDiscounts.xml");

	}

}
