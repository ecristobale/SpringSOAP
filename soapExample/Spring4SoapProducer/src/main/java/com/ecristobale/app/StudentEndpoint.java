package com.ecristobale.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ecristobale.soap.AddStudentRequest;
import com.ecristobale.soap.AddStudentResponse;
import com.ecristobale.soap.GetStudentRequest;
import com.ecristobale.soap.GetStudentResponse;

@Endpoint
public class StudentEndpoint {
	private static final String NAMESPACE_URI = "http://ecristobale.com/soap";
	@Autowired
	private StudentUtility studentUtility;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
	@ResponsePayload
	public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
		GetStudentResponse response = new GetStudentResponse();
		response.setStudent(studentUtility.getStudent(request.getStudentId()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addStudentRequest")
	@ResponsePayload
	public AddStudentResponse addStudent(@RequestPayload AddStudentRequest request) {
		AddStudentResponse response = new AddStudentResponse();
		response.setStudentId(studentUtility.addStudent(request.getStudent()));
		return response;
	}
}
