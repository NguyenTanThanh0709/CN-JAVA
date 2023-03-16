package tdtu.edu;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PlainTextWriter implements TextWriter{

	public void write(String text, String filename) throws IOException {
		PrintWriter printt = new PrintWriter(new FileWriter(filename));
		printt.print("plain text");
		printt.print(text);
		printt.close();
	}

}
