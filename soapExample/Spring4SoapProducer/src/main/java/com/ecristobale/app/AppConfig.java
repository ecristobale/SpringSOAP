package com.ecristobale.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
@ComponentScan("com.ecristobale")
public class AppConfig extends WsConfigurerAdapter {
	// nombre del WSDL: localhost:8080/{artifactId}/{URI}/ NOMBRE .wsdl
	// también es el nombre del proyecto en SOAP UI cuando importas por el WSDL
	@Bean(name = "studentsWsdl")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentsSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		// PortTypeName no influye
		wsdl11Definition.setPortTypeName("StudentsPortType"); 
		// indica que el WS va a estar en localhost:8080/{artifactId}/-> URI <-
		// será leído por SOAP UI cuando lea el WSDL y apuntará ahí, debe estar dentro del
		// rango de mapeo del servlet dispatcher configurado en: WebAppInitializer
		wsdl11Definition.setLocationUri("/locationUriWS");
		wsdl11Definition.setTargetNamespace("http://ecristobale.com/soap");
		wsdl11Definition.setSchema(studentsSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema studentsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("students.xsd"));
	}
}
