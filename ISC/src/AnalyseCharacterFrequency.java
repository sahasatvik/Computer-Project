import java.io.IOException;
import java.io.FileNotFoundException;

public class AnalyseCharacterFrequency {
        public static void main (String[] args) {
                try {
                        /* Parse the commnd line arguments as the file to analyse and the
                           file to pipe the results into */
                        String fromFile = args[0];
                        String toFile   = args[1];

                        /* Create and write the report */
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
