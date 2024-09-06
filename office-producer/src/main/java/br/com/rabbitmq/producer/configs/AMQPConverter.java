package br.com.rabbitmq.producer.configs;

import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AMQPConverter {
	
//	@Bean
//	public Jackson2JsonMessageConverter jsonToMapMessageConverter() {
//		Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
//        DefaultJackson2JavaTypeMapper javaTypeMapper = new DefaultJackson2JavaTypeMapper();
//        javaTypeMapper.setTrustedPackages("*"); // Confiar em todas as classes
//        converter.setJavaTypeMapper(javaTypeMapper);
//        return converter;
//	}
}
