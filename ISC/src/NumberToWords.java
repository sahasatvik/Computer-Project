public class NumberToWords {
	/* Map of single digits to words */
	public static final String[] singleDigits = {
		" zero",
		" one",
		" two",
		" three",
		" four",
		" five",
		" six",
		" seven",
		" eight",
		" nine"
	};

	/* Map of numbers in the 'teens' to words */
	public static final String[] twoDigits = {
		" ten",
		" eleven",
		" twelve",
		" thirteen",
		" fourteen",
		" fifteen",
		" sixteen",
		" seventeen",
		" eighteen",
		" nineteen"
	};

	/* Map of multiples of tens into words */
	public static final String[] tenMultiples = {
		"",
		"",
		" twenty",
		" thirty",
		" forty",
		" fifty",
		" sixty",
		" seventy",
		" eighty",
		" ninety"
	};

	/* Map of suffixes of powers of thousand into words */
	public static final String[] thousandPowerGroups = {
		"",
		" thousand",
		" million",
		" billion",
		" trillion",
		" quadrillion",
		" quintillion",
		" sextillion",
		" septillion",
		" octillion",
		" nonillion",
		" decillion"
	};

	public static void main (String[] args) {
		try {
			/* Parse the first command line argument as the number
			   to be spelt out */
			Double.parseDouble(args[0]);
			System.out.println(numberToWords(args[0]));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Enter 1 argument! ([number])");
		} catch (NumberFormatException e) {
			System.out.println("Invalid number!");
		}
	}

	/* Convert a string of digits into words */
	public static String numberToWords (String n) {
		/* Deal with the integral and fractional parts separately */
		String parts[] = n.split("\\.");
		String integerPart = stringToWords(parts[0]);
		/* Check for the fractional part */
		if (parts.length == 1)
			return integerPart.trim();
		String decimalPart = stringToDigits(parts[1]);
		return (integerPart + " point" + decimalPart).trim();
	}

	/* Convert the digits of the fractional part into words */
	public static String stringToDigits (String digits) {
		String s = "";
		for (int i = 0; i < digits.length(); i++) {
			/* Map digits to their corresponding words */
			int d = digits.charAt(i) - '0';
			s += singleDigits[d];
		}
		return s;
	}
	
	/* Convert the digits of the integral part into words */
	public static String stringToWords (String n) {
		/* Negative sign is simply read off as 'minus' */
		if (n.charAt(0) == '-')
			return "minus" + stringToWords(n.substring(1));
		String s = "";
		int left = Math.max(0, n.length() - 3);
		int blockNumber = 0;
		/* Loop through blocks of three */
		while (n.length() > 0) {
			String temp = n.substring(left);
			int blockOfThree = Integer.parseInt(temp);
			if (blockOfThree != 0) {
				s = threeDigitsToWords(blockOfThree)
					+ thousandPowerGroups[blockNumber]
					+ "," + s;
			}
			blockNumber++;
			/* Cut off evaluated part */
			n = n.substring(0, left);
			left = Math.max(0, left - 3);
		}
		/* Special case */
		if (s.equals(""))
			return "zero";
		return s.substring(0, s.length() - 1);
	}
	
	/* Convert a block of three digits into words */
	public static String threeDigitsToWords (int n) {
		/* Extract each digit */
		int h = n / 100;
		int t = (n / 10) % 10;
		int o = n % 10;
		String s = "";
		/* Only convert the 'hundreds' if it is non-zero */
		if (h > 0) {
			s += singleDigits[h] + " hundred";
		}
		/* Special case of 'teens' */
		if (t == 1) {
			s += twoDigits[o];
			return s;
		}
		s += tenMultiples[t];
		/* Only convert 'ones' if it is non-zero */
		if (o > 0) {
			s += singleDigits[o];
		}
		return s;
	}
}
