package by.htp.project1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project1.controller.command.Command;
import by.htp.project1.controller.command.CommandProvider;
import by.htp.project1.controller.command.impl.Logination;
import by.htp.project1.controller.command.impl.RegistrationNewUser;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CommandProvider provider = new CommandProvider();
 
    public Controller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
		

	//	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
	//	requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("command");
		Command command;
		command = provider.takeCommand(name);
		
		command.execute(request, response);
		
	}

}
