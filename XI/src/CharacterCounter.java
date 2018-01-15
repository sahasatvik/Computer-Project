import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class CharacterCounter {
	protected String filename;
	
	protected String fileData;
	protected int[] letterCount;
	protected char[] letters;
	protected int totalLetters;

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

	private void getFileData () throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line = "";
		while ((line = bufferedReader.readLine()) != null)
			fileData += line.toLowerCase();

		bufferedReader.close();
		fileReader.close();
	}

	public int getCountOf (char c) {
		int count = 0;
		for (int i = 0; i < fileData.length(); i++) {
			if (fileData.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

	public void countAllLetters () {
		for (char c = 'a'; c <= 'z'; c++) {
			letterCount[c - 'a'] = getCountOf(c);
			letters[c - 'a'] = c;
			totalLetters += letterCount[c - 'a'];
		}
	}

	private void sortLetters () {
		for (int right = 26; right > 0; right--)
			for (int i = 1; i < right; i++)
				if (letterCount[i] > letterCount[i-1])
					swap(i, i-1);
	}

	private void swap (int i, int j) {
		int tmpCount = letterCount[i];
		char tmpChar = letters[i];
		letterCount[i] = letterCount[i-1];
		letters[i] = letters[i-1];
		letterCount[i-1] = tmpCount;
		letters[i-1] = tmpChar;
	}

	public void writeReportToFile (String toFilename) throws IOException {
		FileWriter fileWriter = new FileWriter(toFilename);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(bufferedWriter);

		int l = (totalLetters + "").length();
		String unusedLetters = "";
		for (int i = 0; i < 26; i++) {
			char c = letters[i];
			int count = letterCount[i];
			double percent = (count * 100.0) / totalLetters;
			if (count > 0) {
				printWriter.printf("%c : %5.2f%% (%" + l + "d) %n", 
							c, percent, count);
			} else {
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
