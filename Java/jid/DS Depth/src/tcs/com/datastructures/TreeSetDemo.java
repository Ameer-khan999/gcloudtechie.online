package tcs.com.datastructures;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo {
	
	public void treesetDemo() {
		Notes note1=new Notes("Harry Potter","Ameer",1998);
		Notes note2=new Notes("Saddam Hussein","James Morg",2004);
		Notes note3=new Notes("Harry Potter","meer",1998);
		Notes note4=new Notes("Once Upon A Time","Battu",1987);
		Notes note5=new Notes("A Man","Khan",1980);
		
		Set<Notes> notes=new TreeSet<Notes>(new AuthorComparator()); // comipler executes this first 
		notes.add(note1);  											  // instead of natural 
		notes.add(note2);
		notes.add(note3);
		notes.add(note4);
		notes.add(note5);
		
		for(Notes n:notes) {
			// System.out.println(Notes.getYear());
			System.out.println("notes are: " + n);
		}
		
		
	}
	
	// TreeSetDemo2 ~ Exploring NavigableSet methods
	
	public void treeSetDemoWithNavigableSet() {
		NavigableSet<Double> navSet = new TreeSet<>();
		navSet.add(5.0);
		navSet.add(23.8);
		navSet.add(74.8);
		navSet.add(89.9);
		
		System.out.println("\nlower: " + navSet.lower(74.0));
		System.out.println("floor: " + navSet.floor(74.0));
		System.out.println("\nceiling: " + navSet.ceiling(74.0));
		System.out.println("higher: " + navSet.higher(84.0));
		
		System.out.println("\nfirst: " + navSet.first());
		System.out.println("last: " + navSet.last());
		
		System.out.println("\nascendingSet: " + navSet);
		
		NavigableSet<Double> descendingSet = navSet.descendingSet();
		System.out.println("descendingSet: " + descendingSet);
		
		NavigableSet<Double> headSet = navSet.headSet(74.0,true);
		System.out.println("\nheadSet: " + headSet);
		
		headSet.add(6.9); // returns in original set too if we add here
		System.out.println("\nnavSet: " + navSet);
		System.out.println("\nheadSet: " + headSet);
		
		headSet.add(1.9); // this is ok coz 74.0 > 1.9
		// headSet.add(76.9); // throws IllegalArgumentException coz headSet value 74.0 < 76.9
		
		System.out.println("\nheadSet: " + headSet);
		
		SortedSet<Double> subSet = navSet.subSet(5.0, 74.5);
		// subSet.add(2.0); // throws IllegalArgumentException coz subSet value 2.0 < 5.0
		
		navSet.add(25.5); // returns in subSet too if we add here
		System.out.println("subSet: " + subSet);
		
	}
	
	public static void main(String[] args) {
		TreeSetDemo tsd=new TreeSetDemo();
		tsd.treesetDemo();
		tsd.treeSetDemoWithNavigableSet();
	}
	
}


class Notes implements Comparable {
	private String title;
	private String author;
	private  int year;
	
	public String getTitle() {
		return title;
	}
	
	public void settitle() {
		this.title=title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor() {
		this.author=author;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear() {
		this.year=year;
	}
	
	public Notes(String title,String author,int year) {
		super();
		this.title=title;
		this.author=author;
		this.year=year;
	}
	
	@Override
	public String toString() {
		return "Notes [ title = " + title + ", author = " + author + ", year = " + year + " ]";
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Notes other = (Notes) obj; if (author == null) { if (other.getAuthor()
	 * != null) return false; } else if (!author.equals(other.getAuthor())) return
	 * false; if (title == null) { if (other.getTitle() != null) return false; }
	 * else if (!title.equals(other.getTitle())) return false; if (year !=
	 * other.getYear()) return false; return true; }
	 */
	@Override
	public int compareTo(Object note) { // unimplemented method from Comparable Interface.
		// TODO Auto-generated method stub
		return getTitle().compareTo(((Notes) note).getTitle());
		// returns the value in int as 0 and 1.
	}
}

class AuthorComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return ((Notes)o1).getAuthor().compareTo(((Notes)o2).getAuthor());
		//return ((Notes)o1).getAuthor().compareTo(((Notes)o2).getAuthor());
	}
	
	// Note:- we cannot apply compareTo on primitive type int for that we need to box it as
		// Integer.valueOf(int i) or Integer.valueOf(String s) and remember this is not
		// fo compare, we can compare on any type so matter is compareTo in compare
		// compareTo is Comaparable interface abstract method and compare is Comparator
		// interface abstract method.
	
}
