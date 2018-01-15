import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class CodeSubstituter {
 	protected String filename;
 	
	protected int numberOfLines;
	protected String[][] wordMap; 

 	public CodeSubstituter (String filename) throws IOException {
		this.filename = filename;
		countNumberOfLines();
		initWordMap();
	}

	private void countNumberOfLines () throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		numberOfLines = 0;
		while (bufferedReader.readLine() != null)
			numberOfLines++;

		bufferedReader.close();
		fileReader.close();
		
		wordMap = new String[numberOfLines][2];
	}

	private void initWordMap () throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String line;
		for (int i = 0; i < numberOfLines; i++) {
			line = bufferedReader.readLine();
			wordMap[i][0] = line.substring(0, line.indexOf(" ")).trim();
			wordMap[i][1] = line.substring(line.indexOf(" ")).trim();
		}

		bufferedReader.close();
		fileReader.close();
	}

	public String getEncodedText (String word) {
		for (int i = 0; i < numberOfLines; i++) {
			if (wordMap[i][0].equalsIgnoreCase(word)) {
				return wordMap[i][1];
			}	
		}
		return word;
	}
 }
