package ma.theprofs;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApp extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[0];
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebAppConfig.class };
	}

	// FIXME UTF-8 encoddiin
	// @Bean
	// protected Filter t(){
	// CharacterEncodingFilter characterEncodingFilter = new
	// CharacterEncodingFilter();
	// characterEncodingFilter.setEncoding("UTF-8");
	// characterEncodingFilter.setForceEncoding(true);
	// return characterEncodingFilter;
	// }

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages = { "ma.theprofs.service",
			"ma.theprofs.service.rest" })
	@PropertySource(value = { "classpath:services.properties" })
	@Import({ DaoConfiguration.class })
	public static class WebAppConfig {
	}
}
