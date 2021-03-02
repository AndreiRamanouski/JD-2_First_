package by.htp.project1.controller.command.impl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project1.bean.News;
import by.htp.project1.controller.command.Command;
import by.htp.project1.service.NewsService;
import by.htp.project1.service.ServiceProvider;
import by.htp.project1.service.impl.ServiceException;

public class NewsUpdate implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService =  provider.getNewsService();
		Boolean result = false;
		
		String newsId = request.getParameter("newsaction");
		String title  = request.getParameter("title");
		String brief  = request.getParameter("brief");
		String content  = request.getParameter("content");
		
		
		try {
			result = newsService.newsUpdate(new News(Integer.parseInt(newsId),title,brief,content, new Date()));
		} catch (ServiceException e) {
			
			response.sendRedirect("Controller?command=gotomainpage&message=Exception!!");
		}
		
		if (result) {
			response.sendRedirect("Controller?command=gotomainpage&massage=The news was updated");
		} else {
			response.sendRedirect("Controller?command=gotomainpage&message=Could not update the news");
		}
	}

}
