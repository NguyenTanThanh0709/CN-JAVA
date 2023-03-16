package tdtu.edu;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class pdfTextWriter implements TextWriter{

	public void write(String text, String filename) throws IOException{
		// TODO Auto-generated method stub
		PrintWriter printt = new PrintWriter(new FileWriter(filename));
		printt.print("pdf text");
		printt.print(text);
		printt.close();
	}

}
