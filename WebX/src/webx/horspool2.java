package webx;

import java.io.BufferedWriter;
import java.io.*;

public class horspool2 {

	public int search(String bodyText, String searchWord, String currentUrl, int urlNum) {
		int freq = 0;
		bodyText = bodyText.toLowerCase();
		searchWord = searchWord.toLowerCase();
		int arr[] = new int[26];
		shifttable(searchWord, arr);
		int m = searchWord.length();
		int n = bodyText.length();
		int i = m - 1;
		char s = '<';
		String modifiedBodyText = s + bodyText + s;
		lines line = new lines();
		int numLinesBefore, numLinesAfter;
		String currentLine = "";
		while (i <= n - 1) {
			int k = 0;
			while (k <= m - 1
					&& searchWord.charAt(m - 1 - k) == bodyText.charAt(i - k)) {
				k = k + 1;
			}
			if (k == m) {
				freq++;
				currentLine = line.getLine(modifiedBodyText, i, freq);
				numLinesBefore = line.linesBefore(modifiedBodyText, s, i);
				numLinesAfter = line.linesAfter(modifiedBodyText, s, i);
				printToFile1(currentLine, urlNum);
				printToFile2(numLinesBefore, numLinesAfter, urlNum);
			}
			if (i == n) {
				return freq;
			} else if (symbol(bodyText.charAt(i))) {
				i += m;
			} else {
				i = i + arr[bodyText.charAt(i) - 'a'];
			}
		}
		return freq;
	}

	private static boolean symbol(char ch) {

		int a = (int) ch;
		return (a < 97 || a > 122);
	}

	private static void shifttable(String searchWord, int[] arr) {

		int len = searchWord.length();
		for (int i = 0; i < 26; ++i)
			arr[i] = len;
		for (int j = len - 2; j >= 0; --j) {
			char ch = 'a';
			for (int a = 0; a < 26; ++a) {
				if (searchWord.charAt(j) == (ch + a)) {
					if (arr[a] > len - 1 - j)
						arr[a] = len - 1 - j;
					break;
				}
			}
		}
	}

	public static void printToFile1(String text, int fileNum) {
		try {
			String filePath = new File("").getAbsolutePath(); // to get absolute path
			String filename = "\\src\\webx\\files\\currentLine";
			String FileNum = fileNum + "";
			String modifiedFileName = filePath + filename + FileNum;
			System.out.println("********************************"+modifiedFileName);
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter(modifiedFileName, true));
			bw.write(text);
			bw.newLine();
			bw.write("********************************");
			bw.newLine();
			bw.close();
		} catch (Exception e) {
		}
	}

	public static void printToFile2(int x, int y, int fileNum) {
		try {
			String filePath = new File("").getAbsolutePath(); // to get absolute path
			String filename = "\\src\\webx\\files\\numOfLines";
			String FileNum = fileNum + "";
			String modifiedFileName = filePath + filename + FileNum;
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter(modifiedFileName, true));
			bw.write("" + x);
			bw.write(",");
			bw.write("" + y);
			bw.newLine();
			bw.close();
		} catch (Exception e) {
		}
	}

}
