package com.ecristobale.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ecristobal.article.GetArticleByIdRequest;
import com.ecristobal.article.GetArticleByIdResponse;

@Endpoint
public class ArticleEndpoint {
	private static final String NAMESPACE_URI = "http://ecristobal.com/article";
	@Autowired
	private ArticleUtility articleUtility;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getArticleByIdRequest")
	@ResponsePayload
	public GetArticleByIdResponse getStudent(@RequestPayload GetArticleByIdRequest request) {
		GetArticleByIdResponse response = new GetArticleByIdResponse();
		response.setArticleInfo((articleUtility.getArticle(request.getArticleId())));
		return response;
	}
}
