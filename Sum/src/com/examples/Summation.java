package com.examples;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Summation")
public class Summation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServletContext sc = getServletContext();
	String values = request.getParameter("values");
	Summ data =new Summ();
	int num = 0;
	int sum = 0;
	int count =0;
	request.setAttribute("data",data);
	data.setValues(values);
	if(values==null)
	{
		RequestDispatcher rd=sc.getRequestDispatcher("Second.jsp");
		rd.forward(request, response);
	}
	else
	{
		StringTokenizer st= new StringTokenizer(values,",");
		while(st.hasMoreElements()){
			String token = st.nextToken();
			try{
				num = Integer.parseInt(token);
			}
			catch(Exception e){
				data.setBad(token);
				RequestDispatcher rd = sc.getRequestDispatcher("/Error.jsp");
				rd.forward(request, response);
				return;
			}
			count++;
			sum = sum +num;
		}
	}
	data.setSum(sum);
	RequestDispatcher rd = sc.getRequestDispatcher("/SumResult.jsp");
	rd.forward(request, response);
	
	}

}
