//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.01.13 a las 04:21:42 PM CET 
//


package com.ecristobal.article;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ecristobal.article package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ecristobal.article
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetArticleByIdResponse }
     * 
     */
    public GetArticleByIdResponse createGetArticleByIdResponse() {
        return new GetArticleByIdResponse();
    }

    /**
     * Create an instance of {@link ArticleInfo }
     * 
     */
    public ArticleInfo createArticleInfo() {
        return new ArticleInfo();
    }

    /**
     * Create an instance of {@link GetArticleByIdRequest }
     * 
     */
    public GetArticleByIdRequest createGetArticleByIdRequest() {
        return new GetArticleByIdRequest();
    }

}
