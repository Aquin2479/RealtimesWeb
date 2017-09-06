package realtimes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import realtimes.model.RealtimesService;
import realtimes.model.dto.TestDTO;

/**
 * Servlet implementation class TestController
 */
@WebServlet("/TestController")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			getTest(request, response);
		} catch (Exception e) {
//			request.setAttribute("errorMsg", e.getMessage());
//			request.getRequestDispatcher("showError.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	public void getTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			TestDTO test = RealtimesService.getTest();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("RealTimes Test " + "code: " + test.getTestCode() + "detail: " + test.getDetail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
