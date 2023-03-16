package tdtu.edu;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditor {
	private String text;
	
	@Autowired
	@Qualifier("PlainTextWriter")
	private TextWriter writer;
	
	
	
	public void input(String text) {
		this.text = text;
	}
	public void save(String filename) {
		try {
			writer.write(this.text, filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
