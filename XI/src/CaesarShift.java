class CaesarShift {
	public static void main (String[] args) {
		try {
			int shift = Integer.parseInt(args[0]) % 26;
			String plaintext = args[1].toUpperCase();
			String ciphertext = "";
			
			for (int i = 0; i < plaintext.length(); i++) {
				char plain = plaintext.charAt(i);
				char crypt = ' ';
				if ('A' <= plain && plain <= 'Z') {
					crypt = numToChar(charToNum(plain) + shift);
				} else {
					crypt = plain;
				}
				ciphertext += crypt;
			}
			System.out.println(ciphertext);
		} catch (NumberFormatException e) {
			System.out.println("Enter an integer "
					   + "as the first argument!");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Enter 2 arguments "
					   + "(shift, plaintext)!");
		}
	}

	public static int charToNum (char letter) {
		return Character.toUpperCase(letter) - 'A';
	}

	public static char numToChar (int number) {
		return (char) ('A' + Math.floorMod(number, 26));
	}
} 
