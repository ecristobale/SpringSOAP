package com.ecristobale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecristobale.wsdl.AddStudentResponse;
import com.ecristobale.wsdl.GetStudentResponse;
import com.ecristobale.wsdl.Student;

public class RunSoapClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	    ctx.register(ClientAppConfig.class);
	    ctx.refresh();
		StudentClient studentClient = ctx.getBean(StudentClient.class);
	    Student student = new Student();
	    student.setStudentId(3);
	    student.setAge(24);
	    student.setClazz("asd");
	    student.setName("Eduardo");
	    System.out.println("Añadiendo un nuevo student: " + studentToString(student));
	    AddStudentResponse responseAdd = studentClient.addStudent(student);
	    
		System.out.println("Calling WS to get Student with Id: 3");
		GetStudentResponse response = studentClient.getStudentById(3);
		System.out.println("Name:"+response.getStudent().getName());
		System.out.println("Age:"+response.getStudent().getAge());
		System.out.println("Class:"+response.getStudent().getClazz());
	}
	
	public static String studentToString(Student student) {
		return "Estudiante: [nombre: " + student.getName() + ", edad: " + student.getAge()
				+ ", clase: " + student.getClazz() + ", id: " + student.getStudentId();
	}
}
