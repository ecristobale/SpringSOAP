package com.ecristobale;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IOperations {
	
	@WebMethod
	public int add(int a, int b);
}
