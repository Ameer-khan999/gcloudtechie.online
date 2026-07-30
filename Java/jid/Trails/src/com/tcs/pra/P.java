package com.tcs.pra;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P {
	public static class Passenger<T> implements Comparable {
		private String passengerName;
		private  int passengerAge;
		private  long distanceTravelled;
		
		Passenger(String passengerName,int passengerAge,long distanceTravelled) {
			this.passengerName=passengerName;
			this.passengerAge=passengerAge;
			this.distanceTravelled=distanceTravelled;
		}
		
		public String getPassengerName() {
			return passengerName;
		}
		
		public int getPassengerAge() {
			return passengerAge;
		}
		
		public long getDistanceTravelled() {
			return distanceTravelled;
		}
		
		public void setPassengerName(String passengerName) {
			this.passengerName=passengerName;
		}
		
		public void setPassengerAge(int passengerAge) {
			this.passengerAge=passengerAge;
		}
		
		public void setDistanceTravelled(long distanceTravelled) {
			this.distanceTravelled=distanceTravelled;
		}
		
	/*	public static int getPriceFare(int tax) {
			    int ticketPrice = 3000;
				int fare = 0;
				if (p.getPassengerAge() >=21 && p.getPassengerAge() <= 60) {
					fare = tax * (int) p.getDistanceTravelled();
				} 
			return 0;
		} */
		
		@Override
		public int hashCode() {
			return Objects.hash(passengerAge);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Passenger other = (Passenger) obj;
			return passengerAge== other.passengerAge;
		}
		
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return Integer.valueOf(passengerAge).compareTo(((Passenger)o).getPassengerAge());
		}
		
		public String toString() {
			return "Name = " + getPassengerName() + ",Age = " + getPassengerAge() +
					",DistanceTravelled = " + getDistanceTravelled();
		}
		
	}	
		
		public static void main(String[] args) {
			fresco();
			P p = new P();
			List<Passenger> li = new ArrayList<>();
			li.addAll(PExtraction.method());
			calculateTicketfare(li);
			
		}
		public static void calculateTicketfare(List<Passenger> list) {
			List<String> result= list.stream().
					filter( a -> a.getPassengerAge() >=21 && a.getPassengerAge() <= 60).
					map( n -> n.getPassengerName()).collect(Collectors.toList());
			System.out.println(result);
			
		/*	Map<Integer,Passenger> fare1 = list.stream()
					.filter( a -> a.getPassengerAge() >=21 && a.getPassengerAge() <= 60).
					collect(toMap(Passenger::getPassengerAge,b -> b)); */
			System.out.println("\nfailed..!");
			Map<String,Passenger> mapSorted = list.stream()
					.collect(toMap(Passenger::getPassengerName,a -> a,
							(b1,b2) -> b1.getDistanceTravelled() <= b2.getDistanceTravelled() ? b1 : b2
					));

					for(Entry<String, Passenger> entry : mapSorted.entrySet()) {
						System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
					}
			System.out.println("\nSucceed :)");		
			Map<Object,Object> mapSorted1 = list.stream()
					.collect(toMap(Passenger::getPassengerName,a -> a.getDistanceTravelled()));
			
			for(Entry<Object, Object> entry : mapSorted1.entrySet()) {
				System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
			}
			
		} 
		
	/*	private static <T, K, U> Collector<T, ?, Map<K,U>>
		toMap(Function<? super T, ? extends K> keyMapper,
                                    Function<? super T, ? extends U> valueMapper) {
			// TODO Auto-generated method stub
			return toMap(keyMapper, valueMapper);
		} */ // getting error
		
		public static void fresco() {
			List<Passenger> lii = new ArrayList<>();
			lii.addAll(PExtraction.method());
			Optional<Passenger> p = lii.stream().reduce((a,b) -> a.getPassengerAge() < b.getPassengerAge() ? a : b);
			System.out.println(p.toString());
		}
		
}