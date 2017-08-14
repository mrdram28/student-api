package com.ramorg.webmvc.student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class StudentDAOImpl implements StudentDAO{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addStudent(Student p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("Person Name "+p.getStudentName());
		session.persist(p);
		System.out.println("Person Added Successfully.........");
		
	}

	@Override
	public void updateStudent(Student p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("Student Name "+p.getStudentName());
		session.update(p);
		System.out.println("Student Updated Successfully");
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentsList = session.createQuery("from Student").list();
		return studentsList;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("Student Id is "+id);
		Student student = (Student) session.get(Student.class, new Integer(id));
		return student;
	}

	@Override
	public void removeStudent(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Student p = (Student) session.load(Student.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		
	}
	
}
