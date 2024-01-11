package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao1;
import dto.Admin;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String adminmail=req.getParameter("AdminEmail");
		String adminPassword=req.getParameter("AdminPassword");
		
		Dao1 dao1=new Dao1();
		Admin admin;
		try 
		{
			admin = dao1.findByEmail(adminmail);
			if(admin!=null)
			{
				if(admin.getAdminPassword().equals(adminPassword))
				{
					req.setAttribute("movies", dao1.getAllMovies());
					RequestDispatcher dis=req.getRequestDispatcher("Home.jsp");
					dis.include(req, resp);
				}
				else
				{
					req.setAttribute("Message", "password is wrong");
					RequestDispatcher dis=req.getRequestDispatcher("ALogin.jsp");
					dis.include(req, resp);
				}
			}
			else
			{
				RequestDispatcher dis=req.getRequestDispatcher("ALogin.jsp");
				dis.include(req, resp);
			}
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	

}
