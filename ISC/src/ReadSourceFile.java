import java.io.IOException;
import java.io.FileReader;

public class ReadSourceFile {
	protected String filename;
	
	/* Setup a simple stack as a buffer */
	protected int[] buffer;
	protected int top;

	/* Use a FileReader to collect input */
	protected FileReader fileReader;
	
	/* Sets the filename and the buffer size */
	public ReadSourceFile (String filename, int bufferSize) throws IOException {
		this.filename = filename;
		this.buffer = new int[bufferSize];
		this.top = -1;
		this.fileReader = new FileReader(filename);
	}
	
	/* Checks whether there are more characters */
	public boolean hasNextChar () throws IOException {
		/* Read a character */
		int c = fileReader.read();
		if (c == -1)
			return false;
		/* Push the character onto the buffer */
		putChar(c);
		return true;
	}
	
	/* Returns the next character in the file */
	public int getChar () throws IOException {
		/* Pop from the buffer */
		if (top >= 0)
			return buffer[top--];
		/* Read directly from file */
		return fileReader.read();
	}
	
	/* Pushes a character onto the buffer */
	public boolean putChar (int c) {
		/* Check for stackoverflow */
		if (top == (buffer.length - 1))
			return false;
		buffer[++top] = c;
		return true;
	}
	
	/* Close all resources */
	public void close () throws IOException {
		fileReader.close();
	}
}
