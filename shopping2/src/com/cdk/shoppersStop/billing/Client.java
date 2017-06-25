package com.cdk.shoppersStop.billing;

public class Client {
    /*
     * We are taking input from main for type of customer and purchased amount
     * Based on the type of customer , we are creating the strategy i.e either premium or regular.
     * We are dynamically passing the algo to the billing objects.
     * Since we are loading discounts from xml, we are making strategy classes as singleton ,lest load the xmls multiple times.
     * */
	public static void main(String[] args) {
		Float purchasedAmount=Float.parseFloat(args[0]);
		String customerType=args[1];
		IBillCalculationStrategy strategy=null;
		if(customerType.equals("premium")) {
			strategy=PremiumBillCalculationStrategy.getInstance();
		}else {
			strategy=RegularBillCalculationStrategy.getInstance();
		}
		
				BillCalculator billCalculator=new BillCalculator();
				billCalculator.setStrategy(strategy);
				Float finalBillAmount=billCalculator.calculate(purchasedAmount);
				System.out.println(Math.ceil((new Double(finalBillAmount+""))));
		

	}

}
