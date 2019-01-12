package com.ecristobale.app;

import com.ecristobale.IOperations;
import com.ecristobale.OperationsImplService;

public class MainApp {

	public static void main(String[] args) {

		OperationsImplService operationsImplService = new OperationsImplService();
		IOperations operations = operationsImplService.getOperationsImplPort();
		System.out.println("Calling WS to add 4 and 5: " + (operations.add(4, 5)));
	}

}
