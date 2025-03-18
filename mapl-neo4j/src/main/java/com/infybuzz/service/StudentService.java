package com.infybuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.infybuzz.entity.Department;
import com.infybuzz.entity.IsLearningRelation;
import com.infybuzz.entity.Student;
import com.infybuzz.entity.Subject;
import com.infybuzz.repository.DepartmentRepository;
import com.infybuzz.repository.StudentRepository;
import com.infybuzz.repository.SubjectRepository;
import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.request.CreateSubjectRequest;
import com.infybuzz.request.GetStudentsByBirthYearRequest;
import com.infybuzz.request.UpdateStudentRequest;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public Student createStudent(CreateStudentRequest createStudentRequest) {
		
		Department department = new Department();
		department.setDepName(createStudentRequest.getDepartment().getDepName());
		
		departmentRepository.save(department);
		
		List<IsLearningRelation> isLearningRelationList = 
				new ArrayList<IsLearningRelation>();
		
		if (createStudentRequest.getSubjectList() != null) {
			
			for (CreateSubjectRequest createSub : 
				createStudentRequest.getSubjectList()) {
				
				Subject subject = new Subject();
				subject.setSubName(createSub.getSubjectName());
				
				subjectRepository.save(subject);
				
				IsLearningRelation relation = new IsLearningRelation();
				relation.setMarks(createSub.getMarks());
				relation.setSubject(subject);
				isLearningRelationList.add(relation);
			}
			
		}
		
		Student student = new Student();
		student.setName(createStudentRequest.getName());
		student.setCountry(createStudentRequest.getCountry());
		student.setBirthYear(createStudentRequest.getBirthYear());
		
		student.setDepartment(department);
		student.setIsLearningRelationList(isLearningRelationList);
		
		studentRepository.save(student);
		
		return student;
	}
	
	public Student getStudentById(long id) {
		return studentRepository.findById(id).get();
	}
	
	public List<Student> getStudentsByName(String name) {
		return studentRepository.findByName(name);
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student updateStudent (UpdateStudentRequest updateStudentRequest) {
		Student student = 
				studentRepository.findById(updateStudentRequest.getId()).get();
		
		student.setName(updateStudentRequest.getName());
		student.setCountry(updateStudentRequest.getCountry());
		student.setBirthYear(updateStudentRequest.getBirthYear());
		
		studentRepository.save(student);
		
		return student;
	}
	
	public String deleteStudent(long id) {
		studentRepository.deleteById(id);
		
		return "Student Deleted";
	}
	
	public List<Student> getStudentByNameAndBirthYear(String name, Integer birthYear) {
		//return studentRepository.findByNameAndBirthYear(name, birthYear);
		return studentRepository.getByNameAndBirthYear(name, birthYear);
	}
	
	public List<Student> getStudentByNameOrBirthYear(String name, Integer birthYear) {
		return studentRepository.findByNameOrBirthYear(name, birthYear);
	}
	
	public List<Student> getStudentByNameOrBirthYear(GetStudentsByBirthYearRequest req) {
		return studentRepository.findByBirthYearIn(req.getBirthYearList());
	}
	
	public List<Student> getStudentsWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return studentRepository.findAll(pageable).getContent();
	}
	
	public List<Student> getStudentsWithSorting() {
		Sort sort = Sort.by(Direction.ASC, "name");
		
		return studentRepository.findAll(sort);
	}
	
	public List<Student> getStudentsByNameLike(String name) {
		return studentRepository.findByNameLike(name);
	}
	
	public List<Student> getStudentsByNameStartsWith(String name) {
		return studentRepository.findByNameStartsWith(name);
	}
	
}
