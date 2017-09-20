package webx;

public class lines {

	public static int linesAfter(String body, char s, int i) {
		char c = '.';
		int lines = 0;
		int k = 1;
		while (body.charAt(i + k) != s) {
			if (body.charAt(i + k) == c) {
				lines = lines + 1;
			}
			k++;
		}
		
		return lines;
	}

	public static int linesBefore(String body, char s, int i) {
		
		char c = '.';
		int lines = 0;
		int k = 1;
		while (body.charAt(i - k) != s) {
			if (body.charAt(i - k) == c) {
				lines = lines + 1;
			}
			k++;
		}
		
		return lines;
	}

	// prints the line containing the word in a text file
	public static String getLine(String body, int i, int freq) {
		int up, down;
		String line;
		String res;
		String append;
		down = i + 1;
		int k = 1;
		char c = '.';
		char cf = '<';
		
		while (body.charAt(i - k) != cf && body.charAt(i - k) != c) {
			k = k + 1;
		}
		
		while (c != body.charAt(down)) {
			down = down + 1;
		}
		
		line = body.substring(i - k + 1, down + 1);
		append = "This is line number " + freq + " : \n";
		res = append + line;
		return res;
	}

}
