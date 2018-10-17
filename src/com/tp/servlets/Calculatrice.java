package com.tp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tp
 */
@WebServlet("/Tp")
public class Calculatrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int param1, param2, resultat = 0;

	public Calculatrice() {
		super();
		param1 = param2 = resultat = 0;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("param1", request.getParameter("param1"));
		request.setAttribute("param2", request.getParameter("param2"));
		request.setAttribute("resultat", resultat);

		this.getServletContext().getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("param1");
		param1 = param == "" ? 0 : Integer.parseInt(request.getParameter("param1"));
		param = request.getParameter("param2");
		param2 = param == "" ? 0 : Integer.parseInt(request.getParameter("param2"));
		String operation = request.getParameter("operation");
		resultat = gereoperation(param1, param2,operation) ;
		doGet(request, response);
	}

	protected int gereoperation(int param1, int param2, String operation) {
		switch (operation) {
		case "+":
			return param1 + param2;
		case "-":
			return param1 - param2;
		case "*":
			return param1 * param2;
		case "/":
			if (param2 !=0) return param1 / param2;
		case "%":
			if (param2 !=0) return param1 % param2;
		}
		return 0;

	}

}
