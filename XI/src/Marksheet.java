public class Marksheet {
	public static final int SCREEN_WIDTH = 100;
	private final double maxMarks;
	private final int numberOfStudents;
	private int lastStudent;
	private String[] names;
	private double[] marks;

	/* Initialize some final data */
	public Marksheet (double maxMarks, int numberOfStudents) {
		this.maxMarks = maxMarks;
		this.numberOfStudents = numberOfStudents;
		this.names = new String[numberOfStudents];
		this.marks = new double[numberOfStudents];
		this.lastStudent = -1;
	}
	
	/* Add names and marks to the stack */
	public boolean addMarks (String name, double score) {
		try {
			names[++lastStudent] = name;
			marks[lastStudent] = score;
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	/* Display the names and percentages in a bar chart */
	public void displayChart () {
		System.out.println(Marksheet.multiplyString("-", Marksheet.SCREEN_WIDTH));
		for (int i = 0; i <= lastStudent; i++) {
			/* Calculate the fraction of marks earned */
			double fraction = marks[i] / maxMarks;
			String name = (names[i].length() < 16)
					? names[i] 
					: (names[i].substring(0,13) + "...");
			int points = (int) (fraction * (SCREEN_WIDTH - 34));
			/* Generate and pad the bar to display */
			String bar = multiplyString("*", points) 
				+ multiplyString(" ", SCREEN_WIDTH - 34 - points);
			System.out.printf("| %16s | %s | %6.2f %% |%n"
							, name
							, bar
							, fraction * 100);
		}
		System.out.println(Marksheet.multiplyString("-", Marksheet.SCREEN_WIDTH));
	}

	/* Display the name of students with the highest score */
	public void displayMaxScorers () {
		String maxScorers = "";
		double maxScore = getMaxScore();
		for (int i = 0; i <= lastStudent; i++) {
			if (marks[i] == maxScore) {
				maxScorers += ", " + names[i];
			}
		}
		System.out.println(maxScorers.substring(1) 
					+ " scored the highest ("
					+ maxScore + "/" 
					+ maxMarks +  ")");
	}

	/* Sort the names and associated marks lexographically */
	public void sortByName () {
		for (int right = lastStudent; right > 0; right--)
			for (int i = 1; i <= right; i++)
				if (names[i-1].compareToIgnoreCase(names[i]) > 0)
					swapRecords(i, i - 1);
				
	}

	/* Get the value of the highest score */
	public double getMaxScore () {
		double max = Integer.MIN_VALUE;
		for (int i = 0; i <= lastStudent; i++) {
			max = Math.max(max, marks[i]);
		}
		return max;
	}

	/* Utility function to swap student records */
	private void swapRecords (int x, int y) {
		String tempName = names[x];
		double tempMark = marks[x];
		names[x] = names[y];
		marks[x] = marks[y];
		names[y] = tempName;
		marks[y] = tempMark;
	}

	/* Utility funtion for repeating strings */	
	public static String multiplyString (String s, int n) {
		String out = "";
		while (n --> 0)
			out += s;
		return out;
	}
} 
