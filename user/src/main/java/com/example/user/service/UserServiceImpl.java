package com.example.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user.Exeception.DuplicateRecordFoundException;
import com.example.user.Exeception.RecordNotFoundException;
import com.example.user.dto.UserDTO;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userrepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	public static UserDTO convertEntityToDTO(User user) {

		UserDTO userDto = new UserDTO();
		userDto.setEmailId(user.getEmailId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setMobileNo(user.getMobileNo());
		userDto.setPassword(user.getPassword());
		userDto.setHomeAddress(user.getHomeAddress());
		userDto.setDistrict(user.getDistrict());
		userDto.setCity(user.getCity());
		userDto.setState(user.getState());
		userDto.setPincode(user.getPincode());
		userDto.setRole(user.getRole());

		return userDto;
	}

	public static User convertDTOToEntity(UserDTO userDto) {

		User user = new User();
		user.setEmailId(userDto.getEmailId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setMobileNo(userDto.getMobileNo());
		user.setPassword(userDto.getPassword());
		user.setHomeAddress(userDto.getHomeAddress());
		user.setDistrict(userDto.getDistrict());
		user.setCity(userDto.getCity());
		user.setState(userDto.getState());
		user.setPincode(userDto.getPincode());
		user.setRole(userDto.getRole());

		return user;
	}

	@Override
	public List<UserDTO> add(UserDTO userDto) throws DuplicateRecordFoundException {

		if (userDto == null) {
			return null;
		}
		log.info("Insert User Start");
		User checking = userrepository.findByEmailId(convertDTOToEntity(userDto).getEmailId());
		if (checking != null) {
			log.warn("User Already Avaliable");
			throw new DuplicateRecordFoundException("User Already Exists");
		}
		User user = convertDTOToEntity(userDto);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user = userrepository.save(user);
		userDto = convertEntityToDTO(user);
		List<UserDTO> dto = new ArrayList<>();
		dto.add(userDto);
		log.info("User addded successfully");
		return dto;

	}

	@Override
	public List<UserDTO> getAllUsers() throws RecordNotFoundException {

		log.info("Fetching Users Started");
		List<UserDTO> userDto = new ArrayList<>();
		for (User c : userrepository.findAll()) {
			userDto.add(convertEntityToDTO(c));
		}

		if (userDto.isEmpty()) {
			log.warn("No Users Available");
			throw new RecordNotFoundException("Users Not Found");
		}

		log.info("User retrived successfully");
		return userDto;

	}

	@Override
	public List<UserDTO> delete(String emailId) throws RecordNotFoundException {

		if (emailId == null) {
			return null;
		}

		Optional<User> find = userrepository.findById(emailId);
		if (!find.isPresent() || find == null) {
			log.warn("No User Available");
			throw new RecordNotFoundException("User Not Found");
		}

		userrepository.deleteById(emailId);
		List<UserDTO> userDto = new ArrayList<>();
		for (User c : userrepository.findAll()) {
			userDto.add(convertEntityToDTO(c));
		}

		log.info("Delete User Successfully");
		return userDto;

	}

	@Override
	public List<UserDTO> update(UserDTO userDto) throws RecordNotFoundException {
		if (userDto == null) {
			return null;
		}

		Optional<User> checking = userrepository.findById(convertDTOToEntity(userDto).getEmailId());
		if (!checking.isPresent() || checking == null) {
			log.warn("No User Available");
			throw new RecordNotFoundException("User Doesn't Exists");
		}

		User user = convertDTOToEntity(userDto);
		user = userrepository.save(user);
		userDto = convertEntityToDTO(user);
		List<UserDTO> dto = new ArrayList<>();
		dto.add(userDto);
		log.info("Update User Successfully");
		return dto;

	}

	@Override
	public UserDTO findByLogin(String login) throws RecordNotFoundException {
		if (login == null) {
			return null;
		}

		User user = null;
		Optional<User> find = userrepository.findById(login);
		if (!find.isPresent() || find == null) {
			log.warn("No User Available");
			throw new RecordNotFoundException("User Not Found");
		}

		user = find.get();
		UserDTO userDto = convertEntityToDTO(user);
		log.info("Retrieved User Successfully");
		return userDto;

	}

	@Override
	public UserDTO signIn(String emailId, String password) {
		if (emailId == null && password == null) {
			return null;
		}
		User user = userrepository.findByEmailId(emailId);
		String email = user.getEmailId();
		String password1 = user.getPassword();
		if (!(email.equals(emailId) && password1.equals(password))) {
			log.warn("Invalid Credentials");
			return null;
		}

		UserDTO dto = convertEntityToDTO(user);
		log.info("Login successfully");
		return dto;
	}

}
