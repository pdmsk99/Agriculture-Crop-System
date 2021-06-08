package com.example.user.user;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
	    
    public List<UserDTO> add(UserDTO userDto);
    
    public List<UserDTO> getAllUsers();
	
	public List<UserDTO> delete(String emailId);
	
	public List<UserDTO> update(UserDTO userDto);
	
	public UserDTO findByLogin(String login);

	public UserDTO signIn(String emailId, String password);
}