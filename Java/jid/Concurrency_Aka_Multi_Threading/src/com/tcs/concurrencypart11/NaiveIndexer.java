package com.tcs.concurrencypart11;

// The Demo of Thread Cooperation and Management
// In this program the Indexer Thread wasting cpu cycle while the page is downloading and 
// this is not correct.


/**
 * For N web links, this approach creates 2 * N threads.
 * 
 * Note: htmlPage is declared volatile in Weblink
 * 
 * Limitation:
 *    CPU cycles are wasted in Indexer as it is waiting for page to be downloaded
 *  
 * @author Ameer_Khan
 *
 */

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;

public class NaiveIndexer<E> {
	Deque<WebLink> queue = new ArrayDeque<>();
	
	private static class WebLink {
		private long id;
		private String title;
		private String url;
		private String host;
		
		private volatile String htmlPage;
		
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
				String htmlPage=HttpConnect.download(webLink.getUrl());
				webLink.setHtmlPage(htmlPage);
			} catch (MalformedURLException e) {
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
			while(true) {
				String htmlPage=webLink.getHtmlPage();
				if(htmlPage != null) {
					index(htmlPage);
					break;
				} else {
					System.out.println(webLink.getId() + " not yet downloaded!");
				}
			}
		}
		
		private void index(String text) {
			if (text != null) {
				System.out.println("\nIndexed: " + webLink.getId() + "\n");
			}
		}
	}
	
	// methods of NaiveIndexer class and this first go() method in this class
	public void go() {
		while (queue.size() > 0) {
			WebLink weblink = queue.remove();
			Thread downloaderThread = new Thread(new Downloader(weblink));
			Thread indexerThread = new Thread(new Indexer(weblink));
			
			downloaderThread.start();
			indexerThread.start();
		}
	}
	
	// add method of NaiveIndexer class 
	public void add(WebLink link) {
		queue.add(link);
	}
	
	// createWeblink method of NaiveIndexer class 
	public WebLink createWeblink(long id, String title, String url, String host) {
		WebLink weblink = new WebLink();
    	weblink.setId(id);
    	weblink.setTitle(title);
    	weblink.setUrl(url);
    	weblink.setHost(host);
    	return weblink;
    }
	
	// main method of NaiveIndexer class
	public static void main(String[] args) {
		NaiveIndexer naiveIndexer = new NaiveIndexer();
		naiveIndexer.add(naiveIndexer.createWeblink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com"));
		naiveIndexer.add(naiveIndexer.createWeblink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com"));
		naiveIndexer.add(naiveIndexer.createWeblink(2002, "Interface vs Abstract Class", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
		naiveIndexer.add(naiveIndexer.createWeblink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
		naiveIndexer.go();
	}
}
