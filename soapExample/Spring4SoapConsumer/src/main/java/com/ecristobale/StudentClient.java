package com.ecristobale;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.ecristobale.wsdl.AddStudentRequest;
import com.ecristobale.wsdl.AddStudentResponse;
import com.ecristobale.wsdl.GetStudentRequest;
import com.ecristobale.wsdl.GetStudentResponse;
import com.ecristobale.wsdl.Student;

public class StudentClient extends WebServiceGatewaySupport  {
	
	public GetStudentResponse getStudentById(int studentId) {
		GetStudentRequest request = new GetStudentRequest();
		request.setStudentId(studentId);
		// calling to WS
		GetStudentResponse response = (GetStudentResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/springbootsoap/locationUriWS/getStudentResponse"));
		return response;
	}
	
	public AddStudentResponse addStudent(Student student) {
		AddStudentRequest request = new AddStudentRequest();
		request.setStudent(student);
		// calling to WS
		AddStudentResponse response = (AddStudentResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/springbootsoap/locationUriWS/addStudentResponse"));
		return response;
	}
}
