<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.ServletOutputStream"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 


int BUFSIZE = 4096;
String filePath;
{

	filePath = getServletContext().getRealPath("") + File.separator + "/Programming Language-website2.pdf";
    //A file separator is a character that is used to separate directory names that make up a path to a particular location.
    //It is operating system dependent.
    File file = new File(filePath);
    int length   = 0;
    ServletOutputStream outStream = response.getOutputStream();
   response.setContentType("text/html");
    response.setContentLength((int)file.length());
    String fileName = (new File(filePath)).getName();
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
    
    byte[] byteBuffer = new byte[BUFSIZE];
    //The FileInputStream class makes it possible to read the contents of a file as a stream of bytes
    DataInputStream in = new DataInputStream(new FileInputStream(file));
    //The DataInputStream class enables us to read Java primitives from InputStream's instead of only bytes. 
    //we wrap an InputStream in a DataInputStream and then we can read primitives from it.
    

    while ((in != null) && ((length = in.read(byteBuffer)) != -1))
    {
        outStream.write(byteBuffer,0,length);
    }
    
    in.close();
    outStream.close();
}
%>
</body>
</html>