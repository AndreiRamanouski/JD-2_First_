package by.htp.project1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project1.bean.User;
import by.htp.project1.controller.command.Command;
import by.htp.project1.service.ServiceProvider;
import by.htp.project1.service.UserService;
import by.htp.project1.service.impl.ServiceException;

public class SaveNewUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("txt/html");
		boolean res = false;
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService =  provider.getUserService();
		User user = new User();
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		
		if(user.getLogin() == null|| user.getLogin() == null ||user.getLogin().equals("") || user.getPassword().equals("") ) {
			if(user.getLogin().length() < 5 || user.getPassword().length() < 5) {
			
				response.sendRedirect("Controller?command=gotoindexpage&message=Registration is NOT OK login or password is too short!");
			} 
			
			
		} else {
			
			try {
				
			res = userService.registration(user);
			} catch (ServiceException e) {
				response.sendRedirect("Controller?command=gotoindexpage&message=Registration is NOT OK. Eception!");
			}
		} 
		if(res) {
		response.sendRedirect("Controller?command=gotoindexpage&message=Registration is OK!");
		} 
		
		//else {System.out.println("here5");
			//response.sendRedirect("Controller?command=gotoindexpage&message=Registration is NOT OK!");}
		

	}

}
