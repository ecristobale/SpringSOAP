package com.ecristobale.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@ComponentScan("com.ecristobale")
public class SoapServiceConfiguration extends WsConfigurerAdapter {

	@Bean(name = "users")
	public DefaultWsdl11Definition user(XsdSchema usersSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setSchema(usersSchema);
		definition.setPortTypeName("UsersPort");
		definition.setLocationUri("/soapws");
		definition.setTargetNamespace("http://ecristobale.com/soap");
		return definition;
	}
	
	@Bean
	public XsdSchema usersSchema(){
		System.out.println("CONFIG");
		return new SimpleXsdSchema(new ClassPathResource("/resources/users.xsd"));
	}
}
