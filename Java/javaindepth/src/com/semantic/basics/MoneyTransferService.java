 class MoneyTransferService {

        CurrencyConverter1 cc = new CurrencyConverter1();
	
	
        double TransferedAmount(int index, double amount) {
                return cc.TransferedAmount(index, amount);		
        }
	
        double computeTransferFee(int index, double amount) {
                double transferAmount = TransferedAmount(index, amount);
                double transferFee = transferAmount * 0.02;
                return transferFee;
        }
	
        public static void main(String[] args) {
                MoneyTransferService transferService = new MoneyTransferService();
		
                double transferAmount = transferService.TransferedAmount(0, 1000);
                double transferFee = transferService.computeTransferFee(0, 1000);
				
		
		
                System.out.println("transferAmount: " + transferAmount);
                System.out.println("transferFee: " + transferFee);
        }

}
