import java.io.IOException;
import java.io.FileNotFoundException;
public class AnalyseCharacterFrequency {
	public static void main (String[] args) {
		try {
			String fromFile = args[0];
			String toFile   = args[1];

			CharacterCounter cc = new CharacterCounter(fromFile);
			cc.writeReportToFile(toFile);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Enter 2 arguments! ([filename_from] [filename_to])");
		} catch (FileNotFoundException e) {
			System.out.println("Enter a valid filename!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
