package thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="thymeleaf")
public class WebConfig implements WebMvcConfigurer {
	
/*	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}*/
	
	
/*	@Bean
	public ClassLoaderTemplateResolver templateResolver2() {
		ClassLoaderTemplateResolver classLoaderTemplate = new ClassLoaderTemplateResolver();
		classLoaderTemplate.setPrefix("/WEB-INF/thymeleaf/");
		classLoaderTemplate.setSuffix(".html");
		classLoaderTemplate.setTemplateMode("HTML5");
		classLoaderTemplate.setCacheable(false);
		classLoaderTemplate.setCharacterEncoding("UTF-8");
		return classLoaderTemplate;
	}*/
	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver classLoaderTemplate = new SpringResourceTemplateResolver();
		classLoaderTemplate.setPrefix("/WEB-INF/thymeleaf/");
		classLoaderTemplate.setSuffix(".html");
		classLoaderTemplate.setTemplateMode("HTML5");
		classLoaderTemplate.setCacheable(false);
		classLoaderTemplate.setCharacterEncoding("UTF-8");
		return classLoaderTemplate;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine =  new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		return engine;
	}
	
	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver tvr = new ThymeleafViewResolver();
		tvr.setTemplateEngine(templateEngine());
		tvr.setCharacterEncoding("UTF-8");
		return tvr;
	}

}
