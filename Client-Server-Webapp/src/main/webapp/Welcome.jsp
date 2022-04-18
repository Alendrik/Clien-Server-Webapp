<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File,java.io.IOException,java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center"> Login Success!</h1>
	<table style="width:100%">
		<tr style="height:200px">
			<td><h1 align="center">User Menu</h1>
			<div align="center">
		<form action="FileUpload" method="post" enctype="multipart/form-data">
				<input type="file" name="file" value="file">
			<table>
				<tr><td>Upload File</td><td><input type="submit" value="Upload"></td></tr>
			</table>	
		</form>
		<form action="FileDownload" method="get" enctype="multipart/form-data">
				<input type="file" name="file" value="file">
			<table>
				<tr><td>Download File</td><td><input type="submit" value="Download"></td></tr>
				<tr><td>Download File</td><td><input type="submit" value="Download"></td></tr>
			</table>	
		</form>
	</div></td>
	<td>
		<!-- This column is supposed to display the files in the directory. -->
		<table>	
		<%
		File jsp = new File(request.getSession().getServletContext().getRealPath(request.getServletPath())); 
		File dir = new File(jsp.getParentFile()+"/Working/");
		File[] list = dir.listFiles();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<h1>Available Files</h1>");
		out.println("<div  style=\"font-size:15px\" style=\"font-family:verdana\">");	
		for(File f : list) { 
			String[] filePath = f.toString().split("/", 0);
			String filename = filePath[filePath.length - 1];
			out.println("<p> - "+filename+"</p>");
			
		}
		out.println("</div>");
		%>
		</table>
	</tr>
	</table>
</body>
</html>