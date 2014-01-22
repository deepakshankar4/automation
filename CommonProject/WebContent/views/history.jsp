<%@page import="java.io.PrintWriter"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="org.hibernate.*"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Transaction"%>
<%@ page import="org.hibernate.cfg.Configuration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
    </h2>
</head>
<body>
	<%
		String user = (String) session.getAttribute("user");

		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();

		} catch (Throwable ex) {
			System.out
					.println("unable to create session factory object!!!");
			throw new ExceptionInInitializerError(ex);
		}
		Session hibersession = factory.openSession();

		try {
			String QUERY = "select ii.invenList, ii.referredUser from org.ecomm.source.POJO.InvenInfo as ii where ii.user='"
					+ user + "'";
			org.hibernate.Query query = hibersession.createQuery(QUERY);
			@SuppressWarnings("unchecked")
			List<String> history = query.list();
			PrintWriter pout = response.getWriter();
			pout.println(history);

		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
	%>

</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>