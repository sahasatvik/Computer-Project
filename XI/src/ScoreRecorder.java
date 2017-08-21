import java.util.Scanner;
import java.util.InputMismatchException;

public class ScoreRecorder {
	public static void main (String[] args) {
		Scanner inp = new Scanner(System.in);
		double maxMarks = 0.0;
		int numberOfStudents = 0;
		try {
			System.out.print("Enter the maximum marks alotted for each student : ");
			maxMarks = inp.nextDouble();
			System.out.print("Enter the total number of students : ");
			numberOfStudents = inp.nextInt();
			if (maxMarks <= 0) {
				System.out.println("Maximum marks must be positive!");
				System.exit(0);
			}
			if (numberOfStudents <= 0) {
				System.out.println("Number of students must be positive!");
				System.exit(0);
			}
			Marksheet sheet = new Marksheet(maxMarks, numberOfStudents);
			System.out.println("Enter " + numberOfStudents + " students' names and marks : ");
			for (int i = 0; i < numberOfStudents; i++) {
				String name = "";
				while (!inp.hasNextDouble()) {
					name += inp.next() + " ";
				}
				double marks = inp.nextDouble();
				if (marks <= 0 || marks > maxMarks) {
					System.out.println("Marks must be within 0.0 and " + maxMarks + "!");
					System.exit(0);
				}
				sheet.addMarks(name.trim(), marks);
			}
			sheet.sortByName();
			sheet.displayChart();
			sheet.displayMaxScorers();
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input!");
			System.exit(0);
		}
	}
} 
