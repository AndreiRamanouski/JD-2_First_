package by.htp.project1.dao;


import by.htp.project1.bean.User;

public interface UserDAO {

	public User authorization(String login, String password) throws DAOException;
	
	public boolean registration(User user)throws DAOException;
	
	
}
