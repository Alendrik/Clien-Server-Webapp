

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListFiles
 */
@WebServlet("/ListFiles")
public class ListFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Getting file paths and hard-coding our "working" folder where file upload and download happen. 
		 */

		File jsp = new File(request.getSession().getServletContext().getRealPath(request.getServletPath())); 
		File dir = new File(jsp.getParentFile()+"/Working/");
		File[] list = dir.listFiles();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		

		pw.println("<div align=\"center\" style=\"font-size:15px\" style=\"font-family:verdana\">");		
		for(File f : list) { 
			String[] filePath = f.toString().split("/", 0);
			String filename = filePath[filePath.length - 1];
			pw.println("<br>" + filename + "</br>");
			
		}
		pw.println("</div>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
