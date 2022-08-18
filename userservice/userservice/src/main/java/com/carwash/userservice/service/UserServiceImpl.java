package com.carwash.userservice.service;

import com.carwash.userservice.exception.*;
import com.carwash.userservice.model.User;
import com.carwash.userservice.model.UserDto;
import com.carwash.userservice.repository.UserRepository;
import com.carwash.userservice.util.PhoneNumberValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private SequenceGeneratorService seqService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserDto userDto){
    	User user= new User();
    	user.setUserId(seqService.getSequenceNumber(User.SEQUENCE_NAME));

    	Optional<User> user1=userRepository.findByUserName(userDto.getUserName());
    	if(user1.isPresent())
    		throw new UserNameException("username already taken, choose new username");
    	if(userDto.getUserName().length()<3)
    		throw new UserNameException("username should contain more then three charecters");
    	user.setUserName(userDto.getUserName());

    	if(userDto.getFullName().isEmpty())
    		throw new NameException("Name can't be blank");
    	user.setFullName(userDto.getFullName());

		if(userDto.getAge()<18 || userDto.getAge()>81)
			throw new InvalidAgeException("please enter valid age");
		user.setAge(userDto.getAge());

		if(userDto.getRole().name().contains("USER") || userDto.getRole().name().contains("WASHER")) {
			user.setRole(userDto.getRole());
		}else {
			throw new InvalidRoleException("choose either USER or WASHER");
		}

		user.setGender(userDto.getGender());

        if(!(userDto.getEmail().contains("@")) && (userDto.getEmail().contains(".")))
       	  throw new InvalidEmailException("please enter valid email");
    	  user.setEmail(userDto.getEmail());

    	if(!PhoneNumberValidation.isValidMobileNo(userDto.getPhoneNo()))
		    throw new PhoneNoException("invalid phone number");
			user.setPhoneNo(userDto.getPhoneNo());



		Optional<User> user2=userRepository.findByPhoneNo(userDto.getPhoneNo());
    	if(user2.isPresent())
    		throw new PhoneNoException("someone is rigistered with this number enter new");
    	user.setPhoneNo(userDto.getPhoneNo());

    	if(userDto.getPassword().length()<8)
   		throw new PasswordException("password should be more then 8 charecters");
    	user.setPassword(userDto.getPassword());

    	user.setIsActive(true);
        userRepository.save(user);
        return user;
    }

    public Optional<User> gatUserByUserName(String userName){
	   Optional<User> user=userRepository.findByUserName(userName);
       if(user.isEmpty()) {
       	throw new UserNameException("account not found with this username");
	   }
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<List<User>> getUsersByRole(String role) {
		Optional<List<User>> users = userRepository.findUserByRole(role);
		return users;
	}

	@Override
	public String updateUser(UserDto userDto) {
		Optional<User> user1=userRepository.findByUserName(userDto.getUserName());
    	if(user1.isEmpty())
    		throw new UserNameException("account not found with this username");

    	User user=userRepository.getByUserName(userDto.getUserName());
		user.setUserName(userDto.getUserName());

		if(userDto.getFullName().isEmpty())
			throw new NameException("Name can't be blank");
		user.setFullName(userDto.getFullName());

		if(userDto.getAge()<18 || userDto.getAge()>81)
			throw new InvalidAgeException("please enter valid age");
		user.setAge(userDto.getAge());

		if(userDto.getRole().name().contains("USER") || userDto.getRole().name().contains("WASHER")) {
			user.setRole(userDto.getRole());
		}else {
			throw new InvalidRoleException("choose either USER or WASHER");
		}

		user.setGender(userDto.getGender());

		if(!(userDto.getEmail().contains("@")) && (userDto.getEmail().contains(".")))
			throw new InvalidEmailException("please enter valid email");
		user.setEmail(userDto.getEmail());

		if(!PhoneNumberValidation.isValidMobileNo(userDto.getPhoneNo()))
			throw new PhoneNoException("invalid phone number");
		user.setPhoneNo(userDto.getPhoneNo());



		Optional<User> user2=userRepository.findByPhoneNo(userDto.getPhoneNo());
		if(user2.isPresent())
			throw new PhoneNoException("someone is rigistered with this number enter new");
		user.setPhoneNo(userDto.getPhoneNo());

		if(userDto.getPassword().length()<8)
			throw new PasswordException("password should be more then 8 charecters");
		user.setPassword(userDto.getPassword());

		user.setIsActive(true);
		userRepository.save(user);
		return user.getUserName();

	}

	@Override
	public void deleteUser(String userName) {
    Optional<User> user=userRepository.findByUserName(userName);
    	if(user.isEmpty()){
    		throw new UserNameException("account not found with this username");
		}
    	userRepository.deleteByUserName(userName);
	}

	@Override
	public Integer createAdmin(UserDto userDto) {
		User user= new User();
		user.setUserId(seqService.getSequenceNumber(User.SEQUENCE_NAME));

		Optional<User> user1=userRepository.findByUserName(userDto.getUserName());
		if(user1.isPresent())
			throw new UserNameException("username already taken, choose new username");
		user.setUserName(userDto.getUserName());

		if(userDto.getFullName().isEmpty())
			throw new NameException("Name can't be blank");
		user.setFullName(userDto.getFullName());

		if(userDto.getAge()<18 || userDto.getAge()>81)
			throw new InvalidAgeException("please enter valid age");
		user.setAge(userDto.getAge());

		if(userDto.getRole().name().contains("ADMIN")) {
			user.setRole(userDto.getRole());
		}else {
			throw new InvalidRoleException("choose ADMIN to create admin account");
		}

		user.setGender(userDto.getGender());

		if(!(userDto.getEmail().contains("@")) && (userDto.getEmail().contains(".")))
			throw new InvalidEmailException("please enter valid email");
		user.setEmail(userDto.getEmail());

		if(!PhoneNumberValidation.isValidMobileNo(userDto.getPhoneNo()))
			throw new PhoneNoException("invalid phone number");

		Optional<User> user2=userRepository.findByPhoneNo(userDto.getPhoneNo());
		if(user2.isPresent())
			throw new PhoneNoException("someone is rigistered with this number enter new number");
		user.setPhoneNo(userDto.getPhoneNo());

		if(userDto.getPassword().length()<8)
			throw new PasswordException("password should be more then 8 charecters");
		user.setPassword(userDto.getPassword());

		user.setIsActive(true);

		userRepository.save(user);
		return user.getUserId();
	}

}

