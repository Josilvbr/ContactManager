package cl.silvabravo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Defaultview implements WebMvcConfigurer{
	
	//Permite Redireccionar a una pagina cuando se ejecuta
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/").setViewName("forward:/contactManager/");
	}
	
}
