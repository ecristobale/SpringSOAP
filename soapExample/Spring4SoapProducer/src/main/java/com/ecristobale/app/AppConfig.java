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
	
	// WSDL: http://localhost:8080/springbootsoap/urisoapws/studentsWsdl.wsdl
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
	
	// WSDL: http://localhost:8080/springbootsoap/articlesUriWS/articlesWsdl.wsdl
	@Bean(name = "articlesWsdl")
	public DefaultWsdl11Definition defaultWsdl11DefinitionArticles(XsdSchema articlesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		// PortTypeName no influye
		wsdl11Definition.setPortTypeName("ArticlesPortType"); 
		// indica que el WS va a estar en localhost:8080/{artifactId}/-> URI <-
		// será leído por SOAP UI cuando lea el WSDL y apuntará ahí, debe estar dentro del
		// rango de mapeo del servlet dispatcher configurado en: WebAppInitializer
		wsdl11Definition.setLocationUri("/articlesUriWS");
		wsdl11Definition.setTargetNamespace("http://ecristobal.com/article");
		wsdl11Definition.setSchema(articlesSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema articlesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("articles.xsd"));
	}
}
