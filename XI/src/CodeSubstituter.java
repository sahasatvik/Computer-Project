import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class CodeSubstituter {
 	protected String filename;
 	
	protected int numberOfLines;
	protected String[][] wordMap; 
	
	/* Create a codebook from a supplied file */
 	public CodeSubstituter (String filename) throws IOException {
		this.filename = filename;
		countNumberOfLines();
		initWordMap();
	}
	
	/* Calculate the number of lines to store on the first pass */
	private void countNumberOfLines () throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		numberOfLines = 0;
		/* Keep incrementing the accumulator while lines are available */
		while (bufferedReader.readLine() != null)
			numberOfLines++;

		bufferedReader.close();
		fileReader.close();
	}
	
	/* Initialize the map/dictionary by reading the file on the second pass */
	private void initWordMap () throws IOException {
		wordMap = new String[numberOfLines][2];
		
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		for (int i = 0; i < numberOfLines; i++) {
			/* Split a line along whitespace */
			String[] words = bufferedReader.readLine().split("\\s+");
			if (words.length >= 2) {
				wordMap[i][0] = words[0];
				wordMap[i][1] = words[1];
			} else {
				/* Ignore empty lines */
				wordMap[i][0] = wordMap[i][1] = "";
			}
		}

		bufferedReader.close();
		fileReader.close();
	}
	
	/* Returns the codeword, given a plain word */
	public String getEncodedText (String word) {
		/* Iterate through all entries */
		for (int i = 0; i < numberOfLines; i++) {
			if (wordMap[i][0].equalsIgnoreCase(word)) {
				return wordMap[i][1];
			}	
		}
		/* Reflect the original back if not found in the codebook */
		return word;
	}
 }
