package webx;

import java.util.*;

public class Spider {

	private int MAX_PAGES; // Upper Bound
	private Set<String> pagesVisited = new HashSet<String>(); // Distinct pages visited
	private List<String> pagesToVisit = new LinkedList<String>(); // Collection of Non-distinct unvisited pages

	public void search(String depth, String url, String searchWord) {
		int urlNum = 1;
		int l = 0;
		long startTime, endTime, duration;
		MAX_PAGES = Integer.parseInt(depth);
		int freq[] = new int[MAX_PAGES];
		long time[] = new long[MAX_PAGES];
		do // Inbuilt Function to return size of HashSet
		{
			
			String currentUrl = "";

			if (this.pagesToVisit.isEmpty()) {
				
				currentUrl = url;
				System.out.println("\nWEBX IS ON = " + url);
				this.pagesVisited.add(url);
			}
			if (!this.pagesToVisit.isEmpty()) {

				currentUrl = this.nextUrl();
				System.out.println("\nWEBX IS ON = " + url);
				this.pagesVisited.add(currentUrl);
			}
			SpiderLeg leg = new SpiderLeg();
			leg.crawl(currentUrl);

			startTime = System.nanoTime();
			int frequency = leg.searchForWord(searchWord, currentUrl, urlNum);
			endTime = System.nanoTime();
			duration = endTime - startTime;
			time[l] = duration;
			freq[l] = frequency;
			l = l + 1;
			urlNum = urlNum + 1;
			if (frequency != 0) {
				
				System.out.print("\nWORD = " + searchWord
						+ "\n FOUND in PAGE :- " + currentUrl);
				System.out.println("\nFrequency of the word is = " + frequency);
			} else {
				System.out.print("\nWORD = " + searchWord
						+ "\n NOT FOUND in PAGE :- " + currentUrl);
				System.out.println("\nFrequency of the word is = " + frequency);
			}
			this.pagesToVisit.addAll(leg.getLinks());

			System.out.println("\nWEBX Visited = " + this.pagesVisited.size()
					+ " Webpages");
		} while (this.pagesVisited.size() < MAX_PAGES);

		// Graph
		graph grap = new graph(MAX_PAGES, freq, time);
		grap.setVisible(true);

	}

	private String nextUrl() {
		String nextUrl;
		do {
			nextUrl = this.pagesToVisit.remove(0);
		} while (this.pagesVisited.contains(nextUrl));

		return nextUrl;
	}

}
