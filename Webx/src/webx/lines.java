package webx;
public class lines
{
    public static int linesAfter(String body, char s, int i)
    {
        char c = '.';
        int lines = 0;
        int k= 1;
        while(body.charAt(i+k) != s)
        {
            if(body.charAt(i+k) == c)
            {
                lines = lines + 1;
            }
            k++;
        }
        //System.out.println("The number of lines after is = "+ (lines-1));
        return lines;
    }
    
    public static int linesBefore(String body, char s, int i)
    {
        //System.out.println("i in linesBefore = "+i);
        char c = '.';
        int lines = 0;
        int k = 1;
        while(body.charAt(i-k) != s)
        {
            //System.out.println("i-k = "+(i-k)); // debugging
            if(body.charAt(i-k) == c)
            {
                lines = lines + 1;
            }
            k++;
        }
        //System.out.println("The number of lines before is = "+lines);
        return lines;
    }
    
    // prints the line containing the word in a text file
    public static String getLine(String body, int i, int freq)
    {
        int up,down;
        String line;
        String res;
        String append;
        //up = i-1;
        down = i+1;
        int k = 1;
        char c = '.';
        char cf = '<';
        //while(c != body.charAt(up)) || body.charAt(up)!= cf
        while(body.charAt(i-k)!= cf && body.charAt(i-k) != c)
        {
            //System.out.println("i-k = "+(i-k));
            k = k + 1;
        }
        while(c != body.charAt(down))
        {
            down = down + 1;
        }
        //line = body.substring(up+1,down);
        line = body.substring(i-k+1,down+1);
        append = "This is line number "+freq+" : \n";
        res = append + line;
        return res;
    }
}