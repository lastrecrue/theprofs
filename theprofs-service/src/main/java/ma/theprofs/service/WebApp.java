package ma.theprofs.service;

import ma.theprofs.dao.DaoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//@Configuration
//@ComponentScan({ "ma.theprofs.dao" })
//@PropertySource(value = { "classpath:services.properties" })

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

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Configuration
	@EnableWebMvc
	@ComponentScan("ma.theprofs.service.rest")
	@Import({ DaoConfiguration.class })
	public static class WebAppConfig {
	}
}
