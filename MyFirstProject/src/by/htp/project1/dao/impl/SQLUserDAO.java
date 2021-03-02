package by.htp.project1.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.project1.bean.User;
import by.htp.project1.dao.DAOException;
import by.htp.project1.dao.UserDAO;

public class SQLUserDAO implements UserDAO{
	
	static {
		MYSQLDriverLoader.getInstance();
	}
	

	@Override
	public User authorization(String login, String password) throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		User user = null;
		try {
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC" + 
		        "","root", "");
		
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM usertable");
			
			while (rs.next()) {
				user = new User(rs.getString("login"),rs.getString("password"),rs.getString("role"));
				if (user.getLogin().equals(login) || user.getPassword().equals(password)) {
					return user;
				} else user = null;
			} 
		}  catch (SQLException e) {
				throw new DAOException(e);
		} finally{
			
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
				
			} 
		return user;
	}

	@Override
	public boolean registration(User user) throws DAOException {
			
			boolean res = false;
			Connection con = null;
			Statement st = null;
			String NEW_USERS_CREATE_QUARY = "INSERT INTO usertable(login,password,role) VALUES('"+user.getLogin()+"','"
			+user.getPassword()+"','user')";

			try {
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC" + 
				        "","root", "");
				st = con.createStatement();
				int i = st.executeUpdate(NEW_USERS_CREATE_QUARY);
			
				if(i>0) {

					
					res = true;
					System.out.println(res);
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				} 
			}
			
			return res;
		}
	

	

	
}
