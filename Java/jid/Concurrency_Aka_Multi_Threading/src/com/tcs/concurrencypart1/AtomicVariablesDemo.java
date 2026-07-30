package com.tcs.concurrencypart1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* Atomic variables which were introduced in java 5.it is better than volatile coz
 * this atomic variables supports better visibily like Volatiles and at same time
 * they also supports atomicity like locks.However regards to atomicity they are 
 * constraints to only single variables that is they cannot guard a block of code
 * that synchronization does.since we are discussing memory visibilty this demo is
 * also related to Java Memory Model (JMM).
*/
public class AtomicVariablesDemo {

	// nested static class
	public static class MeetUpEvent {
		private String name;
		private AtomicInteger count = new AtomicInteger(1); // 1 for organizer

		public MeetUpEvent(String name) {
			this.name = name;
		}

		// attending method
		public void attending(int guestCount) {
			if (guestCount == 1) {
				count.incrementAndGet(); // gets value count=1 if attendees are 0 and
				// it only increments to 2 if guestCount is 1 otherwise remains 1.
			} else {
				count.addAndGet(guestCount); // if attendees are more than 1 this
				// method gets guestCount+count value.
			}
		//	System.out.println("Attendees are: " + count);
		}

		// not attending method
		public void notAttending(int guestCount) {
			if (guestCount == 1) {
				count.decrementAndGet();
			} else {
				boolean updated = false;

				while (!updated) {
					int currentCount = count.get();
					int newCount = currentCount - guestCount;
					updated = count.compareAndSet(currentCount, newCount);
					// System.out.println(currentCount);
				}
			}
		//	System.out.println("Not Attendees are: " + count);
		}

		public int getCount() {
			return count.get();
		}

		public static void main(String[] args) {
			/*
			 * This is for my clarification and not part of Demo.
			 * m= new MeetUpEvent(); m.attending(9); m.notAttending(3);
			 * System.out.println(m.getCount());
			 */
			MeetUpEvent jugBoston=new MeetUpEvent("The Boston Java User group..");
			
			MeetUpEvent jugTexas=new MeetUpEvent("The Texas Java User group..");
			
			MeetUpEvent jugChicago=new MeetUpEvent("The Chicago Java User group..");
			
			Thread user1=new Thread(new Runnable() {
				@Override
				public void run() {
					jugBoston.attending(200);
					System.out.println(jugBoston.getCount() + " ,peoples are attending from Group " +  
					Thread.currentThread().getName());
		
				}
				
			});
			
			Thread user2=new Thread(new Runnable() {
				@Override
				public void run() {
					jugTexas.attending(300);
					System.out.println(jugTexas.getCount() + " ,peoples are attending from Group " +  
					Thread.currentThread().getName());
					jugTexas.notAttending(139);
					System.out.println(jugTexas.getCount() + " ,peoples are not attending from Group " + 
					Thread.currentThread().getName());
				}
				
			});
			
			Thread user3 = new Thread(new Runnable() {
				@Override
				public void run() {
					jugChicago.attending(431);
					System.out.println(jugChicago.getCount() + " ,peoples are attending from Group " +  Thread.currentThread().getName());
				}			
			});
			
			
			user1.setName("User 1");
			user2.setName("User 2");
			user3.setName("User 3");
			user1.start();
		//	user1.sleep(1); to this ty of invoking on sleep method we need try Catch block
			sleep(1); // this is ok we no need to exception handle.
			user2.start();
			sleep(2);
			user3.start();
			sleep(3);
			Integer jugBoston1 = jugBoston.getCount();
			Integer jugTexas1 = jugTexas.getCount();
			Integer jugChicago1 = jugChicago.getCount();
			System.out.println("Total attending : " + (Integer) jugBoston1 + (Integer) jugTexas1 + (Integer) jugChicago1);

		}
		
		private static void sleep(int i) {
			try {
				TimeUnit.SECONDS.sleep(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		
	}

}
