//import java.io.BufferedWriter;
package webx;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import java.io.PrintWriter;
//import java.io.FileWriter;
//import java.io.File;
public class SpiderLeg
{
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private List<String> links = new LinkedList<String>();
    private Document htmlDocument;

     // Using JSoup Class,we makes an HTTP request, check the response.
     // Then Gather up all the links on that particular Page. 
    
    public boolean crawl(String url)
    {
        try
        {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
             htmlDocument = connection.get();
            
        	//Document htmlDocument = Jsoup.connect(url).userAgent(USER_AGENT).get();                  
            if(connection.response().statusCode() == 200) 				// 200 is the HTTP OK status code
                                                          				// Indicating that Connection Established.
            {
                System.out.println("\n**Visiting** Received web page at " + url);
            }
            if(!connection.response().contentType().contains("text/html"))
            {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }
            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("No. Of Links on this Page = " + linksOnPage.size());                //Number Of Links Found in a Page.
            for(Element link : linksOnPage)
            {
                this.links.add(link.absUrl("href"));
            }
            return true;
        }
        catch(IOException ioe)
        {
            //  HTTP request Failure
            return false;
        }
    }

    //public boolean searchForWord(String searchWord)
    public int searchForWord(String searchWord, String currentUrl, int urlNum)
    {
        //boolean res = false;
    	//int res;
    	int res = 0;
    	if(this.htmlDocument == null)
        {
            //System.out.println("ERROR! Document Is Empty");
            return 0;
        }
        String bodyText = this.htmlDocument.body().text();                 //Converts HTML BODY to a Single String.
        String url = currentUrl;
        try
        {
           	horspool2 hrs = new horspool2();
        	//res = hrs.search(bodyText,modifiedSearchWord);
        	res = hrs.search(bodyText,searchWord,url,urlNum);
        	
        }
        catch(Exception e)
        {
        }
        
        return res;
    }

    public List<String> getLinks()
    {
        return this.links;
    }
}