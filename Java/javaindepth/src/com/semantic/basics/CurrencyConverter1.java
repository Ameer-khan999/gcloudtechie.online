/* METHOD TYPES:-

--> 1.Instance Methods
  -> Object level methods
  -> Invocation: objecrtReference.methodName()
  -> Affect object state
    1.Instance variables
	2.other instance methods
	
--> 2.Static Methods
  -> Keyword static in declaration
  -> Class level methods
  -> No access to state(instance variables/methods)
     1.serve as utility methods, e.g., sum(double x,double y)
	 2.can access static variables
	 3.can access other static methods
  -> Invocation:classname.methodname();
  -> main method is static
Note: when we are invoking static method we dont need to create object reference we can directly invoke with method name.

*/

class CurrencyConverter1 {
	/*double rupee=63.32;
	double dirham=3;
	float real=3;
	long chilean_peso=595;
	short mexican_peso=18;
	byte _yen=107;
	int $australian=2;
	int dollar;*/

	double[] exchangeRates={63.32,3.0,3.0,595.0,18.0,107.0,2.0};
	
	void setExchangerates (double[] rates) {
		exchangeRates=rates;
	}
	void updateExchangerate (int arrayindex,double newval) {
		exchangeRates[arrayindex]=newval;
	}
	double getExchangerate (int index) {
		return exchangeRates[index];
	}
	double TransferedAmount (int index,double amount) {
		return amount * exchangeRates[index];
	}
	void printCurrencies() {
		System.out.println("Indian rupee: " + exchangeRates[0]);
		System.out.println("UAE dirham: " + exchangeRates[1]);
		System.out.println("Saudi real: " + exchangeRates[2]);
		System.out.println("Chilean_peso: " + exchangeRates[3]);
		System.out.println("mexican_peso: " + exchangeRates[4]);
		System.out.println("Japanese_yen: " + exchangeRates[5]);
		System.out.println("Australian: " + exchangeRates[6]);
		System.out.println("Length is: " + exchangeRates.length);
		System.out.println("\n");
		
	}
	
	public static void main(String[] args) {
		CurrencyConverter1 cc=new CurrencyConverter1();
		
		System.out.println("Exchangerates in 01 January,2022..\n");
	    double[] rates={63.32,3.0,3.0,595.0,18.0,107.0,2.0};
		cc.setExchangerates(rates);
		cc.printCurrencies();
		
		System.out.println("Exchangerates in 02 january,2022..\n");
		rates=new double[]{65.02,6.0,3.0,595.0,18.0,105.0,2.0};
		cc.setExchangerates(rates);
		cc.printCurrencies();
		
		System.out.println("Exchangerates in 03 january,2022..\n");
		rates=new double[]{64.38,5.0,3.0,595.0,15.0,107.0,4.0};
		cc.setExchangerates(rates);
		cc.printCurrencies();
		
		cc.updateExchangerate(0,70.0);
		cc.printCurrencies();
		
		double amount=cc.TransferedAmount(0,90.0);
		System.out.println("Transferd amount in currency is: " + amount);
		
		
		
	}
}  