
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet(description = "Logs users in", urlPatterns = { "/LoginServ" })
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties env = new Properties();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String user = request.getParameter("txtName");
		String pass = request.getParameter("txtPwd");
		
		
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://localhost:389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, String.format("cn=%s,dc=ossec,dc=com",user));
		env.put(Context.SECURITY_CREDENTIALS, pass);
	
		try {
			DirContext connection = new InitialDirContext(env);
			System.out.println("Brooo"+ connection);
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		} catch (NamingException e) {
			pw.println("<font color=\"red\" size=18>Login Failed!!<br>");
			pw.println("<a href=login.jsp>Try AGAIN</a>");
		}
		
	}
	
}
