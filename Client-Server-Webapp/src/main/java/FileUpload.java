

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import javax.servlet.http.*;

@WebServlet("/FileUpload")
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class FileUpload extends HttpServlet {
	private static final String UPLOAD_DIR = "Working"; // Upload directory
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String applicationPath = request.getServletContext().getRealPath(""); // constructs path of the directory to save uploaded file
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR; // Upload location
		File fileSaveDir = new File(uploadFilePath); //saved file directory
		System.out.println("Upload File Directory="+ fileSaveDir.getAbsolutePath()); //test output
		String fileName = null; //Get all the parts from request and write it to the file on server
		
        for (Part part : request.getParts()) {
        	fileName = getFileName(part); //getting fileName
            part.write(uploadFilePath + File.separator + fileName); //Writing the file into the location
        }
        request.setAttribute("message", fileName + " File uploaded successfully!");
        getServletContext().getRequestDispatcher("/Welcome.jsp").forward(request, response); //redirecting back to Welcome.jsp 
	}
	
	private String getFileName(Part part) {
		/* Preparing part headers */
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= " + contentDisp);
        String[] tokens = contentDisp.split(";");
        
        /* Parsing tokens to find filename*/
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1); //returning file name
            }
        }
        return ""; //return nothing when filename is empty
    }

}
