package com.cdk.shoppersStop.billing;

public class DiscountRate implements Comparable<DiscountRate>{
     Float lowerAmount;
     Float highterAmount;
     Float percentage;
	public float getLowerAmount() {
		return lowerAmount;
	}
	public void setLowerAmount(float lowerAmount) {
		this.lowerAmount = lowerAmount;
	}
	public float getHighterAmount() {
		return highterAmount;
	}
	public void setHighterAmount(float highterAmount) {
		this.highterAmount = highterAmount;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	
	@Override
	public int compareTo(DiscountRate o) {
		
		return this.lowerAmount.compareTo(o.lowerAmount);
	}
     
     
}
