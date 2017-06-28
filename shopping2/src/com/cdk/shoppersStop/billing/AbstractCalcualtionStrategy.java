package com.cdk.shoppersStop.billing;

import java.util.List;

public abstract class AbstractCalcualtionStrategy implements IBillCalculationStrategy{

	public abstract List<DiscountRate> getDiscountRates();
	
	
	//Since the calculation logic is at common present, we are keeping this in abstract class.
	@Override
	public float calculate(float purchaseAmount) {
		float totalDiscuount = 0;
		float tempBillAmount = purchaseAmount; //the current amount to be billed
		for (DiscountRate discountRate : getDiscountRates()) {
			if ((discountRate.getHighterAmount() == 0 && tempBillAmount>0) || discountRate.getLowerAmount() <= purchaseAmount
					&& discountRate.getHighterAmount() >= purchaseAmount) {
				
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

	public AbstractCalcualtionStrategy() {
		super();
	}

}