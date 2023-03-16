package tdtu.edu;

import org.springframework.context.annotation.Bean;

public class AppConfig {

	@Bean
	public TextWriter PlainTextWriter() {
		return new PlainTextWriter();
	}
	
	@Bean
	public TextWriter pdfTextWriter() {
		return new PlainTextWriter();
	}
	
	@Bean
	public TextEditor TextEditor() {
		return new TextEditor();
	}
}
