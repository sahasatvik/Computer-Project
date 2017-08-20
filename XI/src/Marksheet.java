class Marksheet {

	public static final int SCREEN_WIDTH = 80;

	double maxMarks;
	int numberOfStudents;
	int lastStudent;

	String[] names;
	double[] marks;

	Marksheet (double maxMarks, int numberOfStudents) {
		this.maxMarks = maxMarks;
		this.numberOfStudents = numberOfStudents;
		names = new String[numberOfStudents];
		marks = new double[numberOfStudents];
		lastStudent = -1;
	}
	
	boolean addMarks (String name, double score) {
		try {
			names[++lastStudent] = name;
			marks[lastStudent] = score;
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	void displayChart () {
		System.out.println(Marksheet.multiplyString("-", Marksheet.SCREEN_WIDTH));
		for (int i = 0; i <= lastStudent; i++) {
			double fraction = marks[i] / maxMarks;
			String name = (names[i].length() < 16)
					? names[i] 
					: (names[i].substring(0,13) + "...");
			int points = (int) (fraction * (SCREEN_WIDTH - 32));
			String bar = multiplyString("*", points) 
				+ multiplyString(" ", SCREEN_WIDTH - 32 - points);
			System.out.printf("| %16s | %s | %5.2f %%%n"
							, name
							, bar
							, fraction * 100);
		}
		System.out.println(Marksheet.multiplyString("-", Marksheet.SCREEN_WIDTH));
	}

	void displayMaxScorers () {
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

	void sortByName () {
		for (int right = lastStudent; right > 0; right--)
			for (int i = 1; i <= right; i++)
				if (names[i-1].compareTo(names[i]) > 0)
					swapRecords(i, i - 1);
				
	}

	double getMaxScore () {
		double max = Integer.MIN_VALUE;
		for (int i = 0; i <= lastStudent; i++) {
			max = Math.max(max, marks[i]);
		}
		return max;
	}

	void swapRecords (int x, int y) {
		String tempName = names[x];
		double tempMark = marks[x];
		names[x] = names[y];
		marks[x] = marks[y];
		names[y] = tempName;
		marks[y] = tempMark;
	}

	public static String multiplyString (String s, int n) {
		String out = "";
		while (n --> 0)
			out += s;
		return out;
	}
} 
