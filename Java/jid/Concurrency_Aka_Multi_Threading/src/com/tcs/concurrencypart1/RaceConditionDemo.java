package com.tcs.concurrencypart1;

/* This class has Undesirable output like a mad and this is not a thread safe so we 
   need to do it as thread safe, now synchronization comes into play */

public class RaceConditionDemo {

	public static void main(String[] args) {
		BankAccount task = new BankAccount();
		task.setBalance(100);
		
		
		Thread john = new Thread(task);
		Thread anita = new Thread(task);
		john.setName("John");
		anita.setName("Anita");
		
		john.start();
		anita.start();
	}
}

class BankAccount implements Runnable {
	private int balance;
	
	public void setBalance(int balance ) {
		this.balance=balance;
	}
	
	public double getBalance() {
		return balance;
	}

	@Override
	public void run() {
		makeWithdrawl(175);
		if(balance <0) {
			System.out.println("Money Overdrawn..");
			System.out.println("This class has Undesirable output and this is not a thread safe so we need to \n"
					+ "do it as thread safe, now synchronization comes into play ");
		}
		
	}
	
	private void makeWithdrawl(int amount) {
		if(balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " is about to "
					+ "withdrawl money..");
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " has witdrwan "
					+ amount);
			System.out.println("Balance is " + getBalance());
		} else {
			System.out.println("Sorry ! "+ Thread.currentThread().getName() + " You have Only " 
		+ getBalance() + " and You are asking " + (double) amount);
		}
	}
	
}


