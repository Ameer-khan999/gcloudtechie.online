package com.tcs.concurrencypart11;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;

/* In Last NaiveIndexer program the Indexer Thread wasting cpu cycle while the page is 
   downloading like not yet downloaded and this is not correct. now we are going to set 
   that problem in this program by avoiding wasting cpu cycle. */

/**
 * For N web links, this approach creates 2 * N threads.
 * 
 * Benefit: Better coordination of control flow between threads. Relinquishes lock on wait()!
 * 
 * Note: htmlPage is NOT declared volatile in Weblink as unlock on a monitor 
 *          'happens before' every subsequent lock on that same monitor.
 * 
 * Limitation:
 *    Solves task cooperation in a low-level fashion. Josh Bloch says it is like
 *          programming in "concurrency assembly language"
 *    Synchronized blocks are needed
 *  
 * @author Ameer_Khan
 *
 */

public class WaitNotifyIndexer {
	Deque<WebLink> queue = new ArrayDeque<>();
	
	private static class WebLink {
		private long id;
		private String title;
		private String url;
		private String host;
		
		private String htmlPage; // In earlier program it is volatile, Now it is not coz 
		// wait() and notify() methods are already have happens before relation so we dont 
		// need volatile
		
		// creating getters and setters for above variables
		public long getId() {
			return id;
		}
		
		public void setId(long id) {
			this.id=id;
		}
		
		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title=title;
		}
		

		public String getUrl() {
			return url;
		}
		
		public void setUrl(String url) {
			this.url=url;
		}
		
		public String getHost() {
			return host;
		}
		
		public void setHost(String host) {
			this.host=host;
		}
		
		public String getHtmlPage() {
			return htmlPage;
		}
		
		public void setHtmlPage(String htmlPage) {
			this.htmlPage=htmlPage;
		}
	}
	
	// Downloader static nested class
	private static class Downloader implements Runnable {
		private WebLink webLink;
		// constructour
		public Downloader(WebLink webLink) {
			this.webLink=webLink;
		}
		public void run() {
			try {
				synchronized (webLink ) {
					String htmlPage=HttpConnect.download(webLink.getUrl());
					webLink.setHtmlPage(htmlPage);
					webLink.notifyAll(); // notifies the Indexer coz it is waiting
					// notify() wakes up single thread (chosen arbitrarily if multiple 
					// threads are waiting). Moves waiting threads to BLOCKED
				} // lock is released via wait() or exiting synchronized block 
			} catch(MalformedURLException e) {
			e.printStackTrace();
		    } catch (URISyntaxException e) {
		    	e.printStackTrace();
		    }
		}
	}
	
	// Indexer static nested class
	private static class Indexer implements Runnable {
		private WebLink webLink;
		// constructor
		public Indexer(WebLink webLink) {
			this.webLink=webLink;
		}
		public void run() {
			// before synchronization block we got java.lang.IllegalMonitorStateException
			// coz of locking mechanism and to achieve atomicity we kept synchronization 
			// block by passing webLink a s arguement and invoked thier methods wait() &
			// notify() or notifyAll()(prefferred)
// 			String htmlPage=webLink.getHtmlPage(); // Gives Low-level handshaking thats 
			// why moved this statement in synchronized block
// Without synchronized block, wait/notify calls will throw IllegalMonitorStateException 
			synchronized (webLink) {
			String htmlPage=webLink.getHtmlPage(); // this staemet is also above but 
			// prefer to put here means in synchronization block.
	// Standard idiom for using wait method
	// + while condition is critical as some other thread could have acquired the 
	// lock and changed the state of the variable or 
	// + Due to "spurious wakeup": A waiting thread can rarely wake up in the 
	// absence of notify. ASAP use wait in while it means not in if but while is recommended
				while(htmlPage==null) {
					try {
						System.out.println(webLink.getId() + " not yet downloaded..");
						// wait() --> Comes from "Object" class. Not Thread!
						webLink.wait(); // waits if page is null
						// Suspends thread. Releases lock (unlike sleep()/yield()). 
						//Goes into WAITING state
						System.out.println(webLink.getId() + " Awakened.");
						htmlPage=webLink.getHtmlPage(); // once it gets the page it come out 
						// from the while loop and that page will index outside of loop
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				index(htmlPage);
			}
			
		}
		
		private void index(String text) {
			if (text != null) {
				System.out.println("\nIndexed: " + webLink.getId() + "\n");
			}
		}
	}
	
	// methods of WaitNotifyIndexer class and this first go() method in this class
	public void go() {
		while (queue.size() > 0) {
			WebLink weblink = queue.remove();
			Thread downloaderThread = new Thread(new Downloader(weblink));
			Thread indexerThread = new Thread(new Indexer(weblink));
			
			downloaderThread.start();
			indexerThread.start();
		}
	}
	
	// add method of WaitNotifyIndexer class 
	public void add(WebLink link) {
		queue.add(link);
	}
	
	// createWeblink method of WaitNotifyIndexer class 
	public WebLink createWeblink(long id, String title, String url, String host) {
		WebLink weblink = new WebLink();
    	weblink.setId(id);
    	weblink.setTitle(title);
    	weblink.setUrl(url);
    	weblink.setHost(host);
    	return weblink;
    }
	
	// main method of WaitNotifyIndexer class
	public static void main(String[] args) {
		WaitNotifyIndexer waitNotifyIndexer = new WaitNotifyIndexer();
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com"));
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com"));
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2002, "Interface vs Abstract Class", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
		waitNotifyIndexer.go();
	}
}

/*
 	getting IllegalMonitorStateException coz wait method is not releasing lock to notify
 	for we need synchronize block for atomicity and we can perform this task by passing
 	webLink Object as argument to synchronize block and we can invoke wait() and notify()
 	Objects methods(Note:- wait & notify are not Thread methods) and wait() releases lock
 	to notify() and it acuires that lock after releasing from wait(), later wait goes to 
 	block state,once notify wakes another thread and wait acuires lock again.
 	 
 	
 	Note:- sleep & yield methods not works on locking mechanism like wait and notify does
 		and wait,notify & notifyAll are Object methods and sleep,yield are Thread methods.
 
 	
 	Final Note:- This logic is used before Java 5 and after Java 5 there is a concept of
 	Concurrency utilities and it gives cleaner code to this output, and it is preferrable 
 	to use over wait() and notify() methods. wait() and notify() methods uses in legacy
 	code that has handshake concept.
*/