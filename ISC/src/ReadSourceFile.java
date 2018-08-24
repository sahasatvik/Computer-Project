import java.io.IOException;
import java.io.FileReader;

public class ReadSourceFile {
	protected String filename;
	protected int[] buffer;
	protected int top;

	protected FileReader fileReader;

	public ReadSourceFile (String filename, int bufferSize) throws IOException {
		this.filename = filename;
		this.buffer = new int[bufferSize];
		this.top = -1;
		this.fileReader = new FileReader(filename);
	}

	public boolean hasNextChar () throws IOException {
		int c = fileReader.read();
		if (c == -1)
			return false;
		putChar(c);
		return true;
	}

	public int getChar () throws IOException {
		if (top >= 0)
			return buffer[top--];
		return fileReader.read();
	}

	public boolean putChar (int c) {
		if (top == (buffer.length - 1))
			return false;
		buffer[++top] = c;
		return true;
	}

	public void close () throws IOException {
		fileReader.close();
	}
}
