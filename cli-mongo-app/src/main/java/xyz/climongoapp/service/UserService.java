package xyz.climongoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import xyz.climongoapp.entity.User;
import xyz.climongoapp.repository.GroupsRepository;
import xyz.climongoapp.repository.UserRepository;
import xyz.climongoapp.repository.CarRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GroupsRepository groupsRepository;
	
	@Autowired
	CarRepository carRepository;

	public User createUser (User User) {
		if (User.getGroups() != null) {
			groupsRepository.save(User.getGroups());
		}
		if (User.getCars() != null && User.getCars().size() > 0) {
			carRepository.saveAll(User.getCars());
		}
		return userRepository.save(User);
	}
	
	public User getUserbyId(String id) {
		return userRepository.findById(id).get();
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User updateUser (User User) {
		return userRepository.save(User);
	}
	
	public String deleteUser (String id) {
		userRepository.deleteById(id);
		return "User has been deleted.";
	}
	
	public List<User> getUsersByUserName (String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public User usersByUserNameAndMail (String userName, String email) {
		return userRepository.findByEmailAndUserName(email, userName);
	}
	
	public User usersByUserNameOrMail (String userName, String email) {
		return userRepository.findByUserNameOrEmail(userName, email);
	}
	
	public List<User> getAllWithPagination (int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return userRepository.findAll(pageable).getContent();
	}
	
	public List<User> allWithSorting () {
		Sort sort = Sort.by(Sort.Direction.ASC, "userName", "email");
		
		return userRepository.findAll(sort);		
	}
	
	public List<User> byGroupsName (String groupsName) {
		return userRepository.findByGroupsGroupsName(groupsName);
	}
	
	public List<User> byCarName (String subName) {
		return userRepository.findByCarsCarName(subName);
	}
	
	public List<User> emailLike (String email) {
		return userRepository.findByEmailIsLike(email);
	}
	
	public List<User> userNameStartsWith (String userName) {
		return userRepository.findByUserNameStartsWith(userName);
	}
	
	public List<User> byGroupsId (String deptId) {
		return userRepository.findByGroupsId(deptId);
	}

	public User userByUserNameAndPassword(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password );
	}


	// VARIOUS USER SERVICES

}
