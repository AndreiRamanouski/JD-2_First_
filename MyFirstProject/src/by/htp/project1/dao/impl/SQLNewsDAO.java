package by.htp.project1.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.project1.bean.News;
import by.htp.project1.dao.DAOException;
import by.htp.project1.dao.NewsDAO;

public class SQLNewsDAO implements NewsDAO{

	static {
		MYSQLDriverLoader.getInstance();
	}

	@Override
	public List<News> all() throws DAOException {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		List<News> news =null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC" + 
		        "","root", "");
		
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM news");
			news = new ArrayList<News>();
			
			while (rs.next()) {
				
			int id = rs.getInt("idnews");
			String title = rs.getString("title");
			String brief = rs.getString("brief");
			String content = rs.getString("content");
			Date date = rs.getDate("date");
			News n = new News(id,title,brief,content,date);
			news.add(n);
			
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
		
		
		return news;
	}

	@Override
	public Boolean update(News news) throws DAOException {
		Boolean result = false;
		
		String update = "UPDATE news SET title='" + news.getTitle() + "', brief='" + news.getBrief() + "', content='" + news.getContent() + "' WHERE idnews=" + news.getId();
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC" + 
			        "","root", "");

			st = con.createStatement();
			st.executeUpdate(update);
			result = true;
		} catch (SQLException e) {
			throw new DAOException();
		} finally{
		
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
			
		}
	
		
		System.out.println(result);
		return result;
	}

}
