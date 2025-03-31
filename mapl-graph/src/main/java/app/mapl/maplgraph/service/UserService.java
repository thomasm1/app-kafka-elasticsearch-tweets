package app.mapl.maplgraph.service;

import java.util.ArrayList;
import java.util.List;
import app.mapl.maplgraph.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import app.mapl.maplgraph.entity.Department;
import app.mapl.maplgraph.entity.IsLearningRelation;
import app.mapl.maplgraph.entity.User;
import app.mapl.maplgraph.entity.Subject;
import app.mapl.maplgraph.repository.DepartmentRepository;
import app.mapl.maplgraph.repository.UserRepository;
import app.mapl.maplgraph.repository.SubjectRepository;
import app.mapl.maplgraph.request.CreateUserRequest;
import app.mapl.maplgraph.request.GetUsersByUserTypeRequest;

@Service
public class UserService {

	UserRepository userRepository;

	SubjectRepository subjectRepository;

	DepartmentRepository departmentRepository;

	public User createUser(CreateUserRequest createUserRequest) {
		
		Department department = new Department();
		department.setDepName(createUserRequest.getDepartment().getDepName());
		
		departmentRepository.save(department);
		
		List<IsLearningRelation> isLearningRelationList = 
				new ArrayList<IsLearningRelation>();
		
		if (createUserRequest.getSubjectList() != null) {
			
			for ( CreateSubjectRequest createSub :
				createUserRequest.getSubjectList()) {
				
				Subject subject = new Subject();
				subject.setSubName(createSub.getSubjectName());
				
				subjectRepository.save(subject);
				
				IsLearningRelation relation = new IsLearningRelation();
				relation.setMarks(createSub.getMarks());
				relation.setSubject(subject);
				isLearningRelationList.add(relation);
			}
			
		}
		
		User user = new User();
		user.setName(createUserRequest.getName());
		user.setCountry(createUserRequest.getCountry());
		user.setUserType(createUserRequest.getUserType());
		
		user.setDepartment(department);
		user.setIsLearningRelationList(isLearningRelationList);
		
		userRepository.save(user);
		
		return user;
	}
	
	public User getUserById(long id) {
		return userRepository.findById(id).get();
	}
	
	public List<User> getUsersByName(String name) {
		return userRepository.findByName(name);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User updateUser (UpdateUserRequest updateUserRequest) {
		User user = 
				userRepository.findById(updateUserRequest.getId()).get();
		
		user.setName(updateUserRequest.getName());
		user.setCountry(updateUserRequest.getCountry());
		user.setUserType(updateUserRequest.getUserType());
		
		userRepository.save(user);
		
		return user;
	}
	
	public String deleteUser(long id) {
		userRepository.deleteById(id);
		
		return "User Deleted";
	}
	
	public List<User> getUserByNameAndUserType(String name, Integer userType) {
		//return userRepository.findByNameAndUserType(name, userType);
		return userRepository.getByNameAndUserType(name, userType);
	}
	
	public List<User> getUserByNameOrUserType(String name, Integer userType) {
		return userRepository.findByNameOrUserType(name, userType);
	}
	
	public List<User> getUserByNameOrUserType(GetUsersByUserTypeRequest req) {
		return userRepository.findByUserTypeIn(req.getUserTypeList());
	}
	
	public List<User> getUsersWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return userRepository.findAll(pageable).getContent();
	}
	
	public List<User> getUsersWithSorting() {
		Sort sort = Sort.by(Direction.ASC, "name");
		
		return userRepository.findAll(sort);
	}
	
	public List<User> getUsersByNameLike(String name) {
		return userRepository.findByNameLike(name);
	}
	
	public List<User> getUsersByNameStartsWith(String name) {
		return userRepository.findByNameStartsWith(name);
	}
	
}
