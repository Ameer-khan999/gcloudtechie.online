package com.tcs.concurrencypart1;
// recommended
public class SynchronizationDemo {
	// Use synchronization if there is a coperation b/w threads and sharable data is There
		// Ex:- for joint account getBalance() method needs to synchronized method.
	// Note:- In this class we only added synchronized makeWithdrawl() method coz
	// previous class RaceConditionDemo has undesirable behaviour with not thread 
	// safe and now this SynchronizationDemo is thread safe.

		public static void main(String[] args) {
			BankAccount1 task = new BankAccount1();
			task.setBalance(100);
			
			
			Thread john = new Thread(task);
			Thread anita = new Thread(task);
			john.setName("John");
			anita.setName("Anita");
			
			john.start();
			anita.start();
		}
	}

class BankAccount1 implements Runnable {
		private int balance;
		
		public void setBalance(int balance ) {
			this.balance=balance;
		}
		
		public synchronized double getBalance() {
			return balance;
		}

		@Override
		public void run() {
			makeWithdrawl(72);
			if(balance <0) {
				System.out.println("Money Overdrawn..");
				System.out.println("This class has Undesirable output and this is not a thread safe so we need to \n"
						+ "do it as thread safe, now synchronization comes into play ");
			}
			
		}
		
		private synchronized void makeWithdrawl(int amount) {
			if(balance >= amount) {
				System.out.println(Thread.currentThread().getName() + " is about to "
						+ "withdrawl money..");
				balance -= amount;
				System.out.println(Thread.currentThread().getName() + " has withdrawn "
						+ amount);
				System.out.println("Balance is " + getBalance());
			} else {
				System.out.println("Sorry ! "+ Thread.currentThread().getName() + " You have Only " 
			+ getBalance() + " and You are asking " + (double) amount);
			}
		}
		
}



