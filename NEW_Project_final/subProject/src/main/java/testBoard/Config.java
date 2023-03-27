package testBoard;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan
public class Config {
	
		
	
	@Bean
	public MessageSource messageSource() {
	 ResourceBundleMessageSource messageSource = new
	ResourceBundleMessageSource();
	 messageSource.setBasenames("messages","errors");
	 messageSource.setDefaultEncoding("utf-8");
	 return messageSource;
	}
	
	
	
}
