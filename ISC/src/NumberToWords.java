public class NumberToWords {
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
	public static final String[] tenPowerGroups = {
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

	public static String threeDigitsToWords (int n) {
		int h = n / 100;
		int t = (n / 10) % 10;
		int o = n % 10;
		String s = "";
		if (h > 0) {
			s += singleDigits[h] + " hundred";
		}
		if (t == 1) {
			s += twoDigits[o];
			return s;
		}
		s += tenMultiples[t];
		if (o > 0) {
			s += singleDigits[o];
		}
		return s;
	}

	public static String stringToWords (String n) {
		if (n.charAt(0) == '-')
			return "minus" + stringToWords(n.substring(1));
		String s = "";
		int left = Math.max(0, n.length() - 3);
		int blockNumber = 0;
		while (n.length() > 0) {
			String temp = n.substring(left);
			int blockOfThree = Integer.parseInt(temp);
			if (blockOfThree != 0) {
				s = threeDigitsToWords(blockOfThree)
					+ tenPowerGroups[blockNumber]
					+ "," + s;
			}
			blockNumber++;
			n = n.substring(0, left);
			left = Math.max(0, left - 3);
		}
		if (s.equals(""))
			return "zero";
		return s.substring(0, s.length() - 1);
	}

	public static String stringToDigits (String digits) {
		String s = "";
		for (int i = 0; i < digits.length(); i++) {
			int d = digits.charAt(i) - '0';
			s += singleDigits[d];
		}
		return s;
	}

	public static String numberToWords (String n) {
		String parts[] = n.split("\\.");
		String integerPart = stringToWords(parts[0]);
		if (parts.length == 1)
			return integerPart.trim();
		String decimalPart = stringToDigits(parts[1]);
		return (integerPart + " point" + decimalPart).trim();
	}

	public static void main (String[] args) {
		try {
			Double.parseDouble(args[0]);
			System.out.println(numberToWords(args[0]));
		} catch (NumberFormatException e) {
		}
	}
}
