package webx;

public class SpiderTest {
	
	private static String site;
	private static String word;
	private static String depth;
	
	public SpiderTest(String dep,String website,String keyword) {
		depth = dep;
		site = website;
		word = keyword;
		Spider spider = new Spider();
        spider.search(depth,site,word);
	}

}
