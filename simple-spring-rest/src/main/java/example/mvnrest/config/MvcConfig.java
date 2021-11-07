package example.mvnrest.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
@EnableWebMvc
@ComponentScan("example.mvnrest.controller")
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		WebMvcConfigurer.super.configureMessageConverters(converters);
		MappingJackson2HttpMessageConverter jacksonMapper = new MappingJackson2HttpMessageConverter();
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.modulesToInstall(new Jdk8Module(), new JavaTimeModule())
		//.featuresToEnable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
		//.featuresToDisable(DeserializationFeature.WRITE_DATES_AS_TIMESTAMPS)
		.serializationInclusion(Include.NON_NULL)
		.propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);		
		jacksonMapper.setObjectMapper(builder.build());
		jacksonMapper.setPrettyPrint(true);
		converters.add(jacksonMapper);
		converters.add(new ResourceHttpMessageConverter());
		converters.add(new ByteArrayHttpMessageConverter());
	}
	
}
