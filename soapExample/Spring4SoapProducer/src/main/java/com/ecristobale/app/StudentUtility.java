package com.ecristobale.app;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.ecristobale.soap.Student;

@Component
public class StudentUtility {
	private Map<Integer, Student> studentMap = new HashMap<Integer, Student>();

	public StudentUtility() {
		Student s1 = new Student();
		s1.setStudentId(1);
		s1.setName("Edu");
		s1.setAge(25);
		s1.setClazz("ABC");
		studentMap.put(1, s1);
		Student s2 = new Student();
		s2.setStudentId(2);
		s2.setName("Ale");
		s2.setAge(24);
		s2.setClazz("EFG");
		studentMap.put(2, s2);
	}

	public Student getStudent(int studentId) {
		return studentMap.get(studentId);
	}

	public int addStudent(Student student) {
		studentMap.put(student.getStudentId(), student);
		return student.getStudentId();
	}
}
