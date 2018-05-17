import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class CharacterCounter {
	protected String filename;
	
	protected String fileData;
	protected char[] letters;
	protected int[] letterCount;
	protected int totalLetters;

	/* Create a table of letter counts in a given file */
	public CharacterCounter (String filename) throws IOException {
		this.filename = filename;
		this.fileData = "";
		this.letterCount = new int[26];
		this.letters = new char[26];
		this.totalLetters = 0;
		getFileData();
		countAllLetters();
		sortLetters();
	}
	
	/* Read all lines in the file and store them in a String */
	private void getFileData () throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line = "";
		while ((line = bufferedReader.readLine()) != null)
			fileData += line.toLowerCase();

		bufferedReader.close();
		fileReader.close();
	}
	
	/* Return the number of occurrences of a character in the file */
	public int getCountOf (char c) {
		int count = 0;
		for (int i = 0; i < fileData.length(); i++) {
			if (fileData.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}
	
	/* Compile the counts of all letters in the file */
	public void countAllLetters () {
		for (char c = 'a'; c <= 'z'; c++) {
			letters[c - 'a'] = c;
			letterCount[c - 'a'] = getCountOf(c);
			totalLetters += letterCount[c - 'a'];
		}
	}
	
	/* Sort the entries by frequency (bubble sort) */
	private void sortLetters () {
		for (int right = 26; right > 0; right--)
			for (int i = 1; i < right; i++)
				if (letterCount[i] > letterCount[i-1])
					swap(i, i-1);
	}

	/* Utility swapping method */
	private void swap (int i, int j) {
		char tmpChar = letters[i];
		int tmpCount = letterCount[i];
		letters[i] = letters[i-1];
		letterCount[i] = letterCount[i-1];
		letters[i-1] = tmpChar;
		letterCount[i-1] = tmpCount;
	}
	
	/* Create and write the final report to a file */
	public void writeReportToFile (String toFilename) throws IOException {
		FileWriter fileWriter = new FileWriter(toFilename);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(bufferedWriter);
		
		/* Make sure the frequencies all fit, aligned in the same column */
		int l = (totalLetters + "").length();
		String unusedLetters = "";
		for (int i = 0; i < 26; i++) {
			/* Show the letter, frequency and percentage out of the total */
			char c = letters[i];
			int count = letterCount[i];
			double percent = (count * 100.0) / totalLetters;
			if (count > 0) {
				printWriter.printf("%c : %5.2f%% (%" + l + "d) %n", 
							c, percent, count);
			} else {
				/* Separate unused letters */
				unusedLetters += c + " ";
			}
		}
		printWriter.printf("Total letters  : %d%n", totalLetters);
		if (unusedLetters.length() == 0)
			unusedLetters = "(none)";
		printWriter.printf("Unused letters : %s%n", unusedLetters);

		printWriter.close();
		bufferedWriter.close();
		fileWriter.close();
	}
}
