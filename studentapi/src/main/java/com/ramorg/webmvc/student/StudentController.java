package com.ramorg.webmvc.student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	private StudentService studentServiceImpl;
	
	@Autowired(required=true)
	@Qualifier(value="studentServiceImpl")
	public void setStudentServiceImpl(StudentService ssi){
		this.studentServiceImpl = ssi;
	}

	@RequestMapping(value="/students", method=RequestMethod.GET)
	public List<Student> listStudents() {
		
		List<Student> students = this.studentServiceImpl.listStudents();
		return students;
		
	}
	
	@RequestMapping(value= "/student/add", method = RequestMethod.POST)
	public String addStudent(@RequestBody Student s){
		
		System.out.println("Student Name from Controller"+s.getStudentName());
		if(s.getStudentId()>0){
			//new person, add it
			this.studentServiceImpl.addStudent(s);
		}else{
			//existing person, call update
			//this.studentServiceImpl.updatePerson(s);
		}
		
		return "Student Added Successfully";
		
	}
	
	@RequestMapping(value="/student/edit/{studentId}", method = RequestMethod.PUT)
	public void editStudent(@PathVariable("studentId") int studentId, @RequestBody Student s) {
		System.out.println("Student Updated Name "+s.getStudentName());
		this.studentServiceImpl.updateStudent(s);
	}
	
	@RequestMapping(value="/students/{studentId}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("studentId") int studentId) {
		Student student = this.studentServiceImpl.getStudentById(studentId);
		System.out.println("Student Name From Controller "+student.getStudentName());
		return student;
		
	}
	
	@RequestMapping(value="/students/{studentId}", method = RequestMethod.DELETE)
	public void removeStudent(@PathVariable("studentId") int studentId) {
		
		this.studentServiceImpl.removeStudent(studentId);
		
	}
	
}
