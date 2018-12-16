import java.io.IOException;

public class RemoveComments {
	public static void main (String[] args) throws IOException {
		/* Parse first command line argument as the file to read from.
		   Allocate a small buffer */
		ReadSourceFile s = new ReadSourceFile(args[0], 10);
		
		/* Initialize the current state to plain source */
		State currentState = State.SOURCE;
		/* Initialize the current matching quote to empty */
		char matchingQuotes = ' ';

		/* Loop through all characters */
		while (s.hasNextChar()) {
			/* Get a character from the file */
			char c = (char) s.getChar();

			/* Escaped characters - display the backslash and the following character */
			if (c == '\\') {
				System.out.print(c + "" + ((char) s.getChar()));
				continue;
			}
			switch (currentState) {
				case SOURCE:
					switch (c) {
						/* Single and double opening quotes */
						case '\"':
						case '\'':
							/* Set the new state */
							currentState = State.QUOTES;
							/* Set the matching closing quote */
							matchingQuotes = c;
							System.out.print(c);
							break;
						/* Possible comment */
						case '/':
							char n = (char) s.getChar();
							if (n == '*')
								currentState = State.MULTIPLE_LINE_COMMENT;
							else if (n == '/')
								currentState = State.SINGLE_LINE_COMMENT;
							else {
								s.putChar(n);
								System.out.print(c);
							}
							break;
						default:
							System.out.print(c);
					}
					break;
				case SINGLE_LINE_COMMENT:
					/* Exit state to plain source on newline */
					if (c == '\n') {
						currentState = State.SOURCE;
						System.out.print(c);
					}
					break;
				case MULTIPLE_LINE_COMMENT:
					/* Exit state to plain source on closing characters */
					if (c == '*') {
						char n = (char) s.getChar();
						if (n == '/')
							currentState = State.SOURCE;
						else
							s.putChar(n);
					}
					break;
				case QUOTES:
					/* Exit state on encountering closing quote */
					if (c == matchingQuotes) {
						currentState = State.SOURCE;
						matchingQuotes = ' ';
					}
					/* Display anything in quotes verbatim */
					System.out.print(c);
					break;
				default:
					System.out.print(c);
			}
		}
		s.close();
	}
}
