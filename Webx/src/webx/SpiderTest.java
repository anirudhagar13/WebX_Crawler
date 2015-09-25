package webx;
public class SpiderTest
{
    /**
     * This is our test. It creates a spider (which creates spider legs) and crawls the web.
     * 
     * @param args
     *            - not used
     */
	private static String site;
	private static String word;
	private static String depth;
	public SpiderTest(String dep,String website,String keyword)
	{
		depth = dep;
		site = website;
		word = keyword;
		Spider spider = new Spider();
        spider.search(depth,site,word);
	}/*
	public static void main(String[] args)
	{
		Spider spider = new Spider();
		spider.search(site, word);
	}
	*/
	
    /*public static void main(String[] args)
    {
        Spider spider = new Spider();
        //Crawl c = new Crawl();
        //Sites s = new Sites();
        spider.search("http://en.wikipedia.org/wiki/Book", "book");
        //spider.search(c.website,s.keyword);
    }*/
}