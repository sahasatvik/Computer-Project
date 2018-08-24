import java.io.IOException;

public class RemoveComments {
	// Single line comment
	public static void main (String[] args) throws IOException {
		ReadSourceFile s = new ReadSourceFile(args[0], 10);
		State currentState = State.SOURCE;
		char matchingQuotes = ' ';
		/* Multiple line comment */
		while (s.hasNextChar()) {
			char c = (char) s.getChar();
			if (c == '\\') {
				System.out.print(c + "" + ((char) s.getChar()));
				continue;
			}
			switch (currentState) {
				case SOURCE:
					switch (c) {
						case '\"':
						case '\'':
							currentState = State.QUOTES;
							matchingQuotes = c;
							System.out.print(c);
							break;
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
					if (c == '\n') {
						currentState = State.SOURCE;
						System.out.print(c);
					}
					break;
				case MULTIPLE_LINE_COMMENT:
					if (c == '*') {
						char n = (char) s.getChar();
						if (n == '/')
							currentState = State.SOURCE;
						else
							s.putChar(n);
					}
					break;
				case QUOTES:
					if (c == matchingQuotes) {
						currentState = State.SOURCE;
						matchingQuotes = ' ';
					}
					System.out.print(c);
					break;
				default:
					System.out.print(c);
			}
		}
		String notAComment = "// This is not a comment \n!";
	}
}
