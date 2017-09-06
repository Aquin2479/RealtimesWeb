package realtimes.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import realtimes.model.RealtimesService;
import realtimes.model.dto.MemberDTO;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if (command.equals("login")) {
			login(request, response);
		} else if (command.equals("logout")) {
			logout(request, response);
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String username = request.getParameter("user").trim();
		String password = request.getParameter("pass").trim();
		
		JSONObject resultOb = new JSONObject();
		
		try {
			MemberDTO member = RealtimesService.getMember(username, password);
			if (member != null) {
				HttpSession session = request.getSession();
				session.setAttribute("login", member.getUsername());
				resultOb.put("result", 0);
			} else {
				request.setAttribute("errorMsg", "로그인 실패! 다시 시도해주세요(No User)");
				System.out.println("login: " + username + " >> NO USER OR WRONG PASSWORD");
				resultOb.put("result", 1);
				resultOb.put("content", "login fail!(no user or wrong password)");
			}
		} catch(Exception e) {
			request.setAttribute("errorMsg", "로그인 실패! 다시 시도해주세요(DB Error)");
			e.printStackTrace();
			resultOb.put("result", 2);
			resultOb.put("content", "login fail!(DB Error)");
		}
		writer.print(resultOb);
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        session.invalidate();
        session = null;
        response.sendRedirect("index.jsp");
	}
}
