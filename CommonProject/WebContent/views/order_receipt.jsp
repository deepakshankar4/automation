<%@ page import="java.math.BigDecimal"%>
<%@ page import="java.util.Map"%>
<%@ page import="net.authorize.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
    </h2>
</head>
<body>
	<h1>Your Receipt Page</h1>
	<%
		Map<String, String[]> requestParameterMap = request
				.getParameterMap();
		if (requestParameterMap != null
				&& requestParameterMap
						.containsKey(ResponseField.RESPONSE_CODE
								.getFieldName())) {

			String transactionId = "";
			if (requestParameterMap
					.containsKey(ResponseField.TRANSACTION_ID
							.getFieldName())) {
				transactionId = requestParameterMap
						.get(ResponseField.TRANSACTION_ID.getFieldName())[0];
			}

			// 1 means we have a successful transaction
			if ("1".equals(requestParameterMap
					.get(ResponseField.RESPONSE_CODE.getFieldName())[0])) {
	%>
	   
	<h2>Success!</h2>
	   
	<h3>Your transaction ID:</h3>
	   
	<div><%=net.authorize.util.StringUtils
							.sanitizeString(transactionId)%></div>
	<%
		} else {
	%>
	   
	<h2>Error!</h2>
	   
	<h3><%=net.authorize.util.StringUtils
							.sanitizeString(requestParameterMap
									.get(ResponseField.RESPONSE_REASON_TEXT
											.getFieldName())[0])%></h3>
	     
	<table>
		<tr>
			<td>response code</td>
			<td><%=net.authorize.util.StringUtils
							.sanitizeString(requestParameterMap
									.get(ResponseField.RESPONSE_CODE
											.getFieldName())[0])%></td>
		</tr>
		<tr>
			<td>response reason code</td>
			<td><%=net.authorize.util.StringUtils
							.sanitizeString(requestParameterMap
									.get(ResponseField.RESPONSE_REASON_CODE
											.getFieldName())[0])%></td>
		</tr>
	</table>
	</div>
	<%
		}
		}
	%>
	 
</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>