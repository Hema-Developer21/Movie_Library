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

@WebServlet("/adminsignup")
public class SaveAdmin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("AdminId"));
		String name=req.getParameter("AdminName");
		long contact=Long.parseLong(req.getParameter("AdminContact"));
		String email=req.getParameter("AdminEmail");
		String password=req.getParameter("AdminPassword");
		
		Admin admin=new Admin();
		
		admin.setAdminId(id);
		admin.setAdminName(name);
		admin.setAdminContact(contact);
		admin.setAdminEmail(email);
		admin.setAdminPassword(password);
		
		Dao1 dao1=new Dao1();
		
		try 
		{
			dao1.SaveAdmin(admin);
			int res = dao1.SaveAdmin(admin);
			if(res>0) {
				RequestDispatcher rd = req.getRequestDispatcher("ALogin.jsp");
				rd.include(req, resp);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("Asignup.jsp");
				rd.include(req, resp);
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
