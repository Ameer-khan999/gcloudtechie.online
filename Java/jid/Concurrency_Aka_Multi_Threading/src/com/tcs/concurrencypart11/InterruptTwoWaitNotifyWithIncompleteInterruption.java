package com.tcs.concurrencypart11;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class InterruptTwoWaitNotifyWithIncompleteInterruption {
	Deque<WebLink> queue = new ArrayDeque<>();
	
	private List<Thread> downloaderThreadList = new ArrayList<>();
	private List<Thread> indexerThreadList = new ArrayList<>();
	
	
	private static class WebLink {
		private long id;
		private String title;
		private String url;
		private String host;
		
		private volatile boolean stop; // init stop sets to always false
	    public boolean isStop() {
			return stop;
		}
		public void setStop(boolean stop) {
			this.stop = stop;
		}
		
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
					InputStream in = HttpConnect.getInputStream(webLink.getUrl());

					// Background thread for stopping download process
					Thread bgThread = new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								while (!webLink.isStop()) {	// false if it is true it gets out from loop and invokes close() on in.close();
									TimeUnit.SECONDS.sleep(1);								
								} 
								System.out.println("Time out. Closing stream for " + webLink.getId());
								in.close();
							} catch (InterruptedException e) {
								System.out.println("bgThread interrupted -- " + webLink.getId());
							} catch (IOException e) {
								e.printStackTrace();
							}
						}						
					});
					bgThread.start();
					
					String htmlPage;
					try {
						htmlPage = HttpConnect.download(in);						
						System.out.println(webLink.getId() + " download complete ...");
						webLink.setHtmlPage(htmlPage);
						
						bgThread.interrupt();
						
						webLink.notifyAll();
					} catch (IOException e) {
						System.out.println(webLink.getId() + " could not be downloaded. Terminating as stream closed!!!");;
					}					
				}
				// lock is released
				
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
			try {
				// Threads waiting here on intrinsic locks are uninterruptible
				synchronized (webLink) {
					String htmlPage = webLink.getHtmlPage();
					
					while (htmlPage == null) {
						try {
							System.out.println(webLink.getId() + " not yet downloaded. Waiting ...");
							webLink.wait();
							System.out.println(webLink.getId() + " awakened!");
							htmlPage = webLink.getHtmlPage();
						} catch (InterruptedException e) {
							throw e;							
						} // WAITING
					}
					index(htmlPage);
				}
			} catch (InterruptedException e) {
				System.out.println(webLink.getId() + " (indexer) interrupted!!");
				
				// Clean-up: Stopping downloader thread indirectly
				webLink.setStop(true);
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
			

			downloaderThread.setName("Downloader Thread with ID: " +  weblink.getId());
			indexerThread.setName("Indexer Thread with ID: " +  weblink.getId());
			
			downloaderThreadList.add(downloaderThread);
			indexerThreadList.add(indexerThread);
			
			downloaderThread.start();
			indexerThread.start();
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Interrupting downloader threads that got BLOCKED
		System.out.println("\nTime Up!!\n");
		for (int i = 0; i < downloaderThreadList.size(); i++) {
			Thread downloaderThread = downloaderThreadList.get(i);
			if (downloaderThread.isAlive()) {
				System.out.println(downloaderThread.getName() + " is still active. Stopping it ...");
				indexerThreadList.get(i).interrupt();				
			}
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
		InterruptTwoWaitNotifyWithIncompleteInterruption incompleteInterruption = 
				new InterruptTwoWaitNotifyWithIncompleteInterruption();
		incompleteInterruption.add(incompleteInterruption.createWeblink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com"));
		incompleteInterruption.add(incompleteInterruption.createWeblink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com"));
		incompleteInterruption.add(incompleteInterruption.createWeblink(2002, "Interface vs Abstract Class", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
		incompleteInterruption.add(incompleteInterruption.createWeblink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
		incompleteInterruption.go();
	}
}
