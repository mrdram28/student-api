package com.ramorg.webmvc.student;

import java.util.List;

import javax.transaction.Transactional;

public class StudentServiceImpl implements StudentService {
	
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	@Transactional
	public void addStudent(Student p) {
		// TODO Auto-generated method stub
		this.studentDAO.addStudent(p);
		
	}

	@Override
	@Transactional
	public void updateStudent(Student p) {
		// TODO Auto-generated method stub
		this.studentDAO.updateStudent(p);
		
	}

	@Override
	@Transactional
	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		return this.studentDAO.listStudents();
		
		
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return this.studentDAO.getStudentById(id);
	}

	@Override
	@Transactional
	public void removeStudent(int id) {
		// TODO Auto-generated method stub
		this.studentDAO.removeStudent(id);
		
	}

}
