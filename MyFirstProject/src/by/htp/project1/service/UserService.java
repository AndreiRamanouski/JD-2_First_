package by.htp.project1.service;


import by.htp.project1.bean.User;
import by.htp.project1.service.impl.ServiceException;

public interface UserService {
	public User authorization(String login, String password) throws ServiceException;
	
	public boolean registration(User user)throws ServiceException;
	
	
	
}
