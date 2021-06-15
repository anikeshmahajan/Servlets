package java.com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		description = "Login Servelet Testing",
		urlPatterns = {"/LoginServlet" }

 		)

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String user = request.getParameter("user");
	     String pwd = request.getParameter("pwd");
	 	 String name="^[(A-Z){1}][a-z]{3,}";
         Pattern compile =Pattern.compile( name ); 
		 Matcher match= compile.matcher(user);
		 
		 String pass="^((?=.*[A-Z])(?=.*[0-9])[@a-zA-Z0-9]{8,})";
		 Pattern compilepass =Pattern.compile( pass ); 
		 Matcher matchpass= compilepass.matcher(pwd);
		 
	     if(match.matches() && matchpass.matches()) {
	    	 request.setAttribute("user", user);
	    	 request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
	     }else {
	    	 RequestDispatcher rd= getServletContext().getRequestDispatcher("/Login.html");
	    	 PrintWriter out = response.getWriter();
	    	 out.println("<font color =red> USERNAME or PASSWORD  is wrong.</font>");
	    	 rd.include(request, response);
	     }
	
	}

}