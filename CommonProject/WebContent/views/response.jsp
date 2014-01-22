<%@ page import="java.util.Map"%>
<%@ page import="net.authorize.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
    </h2>
</head>

<body>
	 
	<script type="text/javascript">
<!--
 var referrer = document.referrer;
 if (referrer.substr(0,7)=="http://") referrer = referrer.substr(7);
 if (referrer.substr(0,8)=="https://") referrer = referrer.substr(8);
if(referrer && referrer.indexOf(document.location.hostname) != 0) {
<%String apiLoginId = "76Z32SKzjqq";
			String receiptPageUrl = "http://localhost:8080/eCOMM2.0/order_receipt.jsp";

			String MD5HashKey = "76Z32SKzjqq";

			net.authorize.sim.Result result = net.authorize.sim.Result
					.createResult(apiLoginId, MD5HashKey,
							request.getParameterMap());
			StringBuffer receiptUrlBuffer = new StringBuffer(receiptPageUrl);

			if (result != null) {
				receiptUrlBuffer.append("?");
				receiptUrlBuffer.append(
						ResponseField.RESPONSE_CODE.getFieldName()).append("=");
				receiptUrlBuffer.append(result.getResponseCode().getCode());
				receiptUrlBuffer.append("&");
				receiptUrlBuffer.append(
						ResponseField.RESPONSE_REASON_CODE.getFieldName())
						.append("=");
				receiptUrlBuffer.append(result.getReasonResponseCode()
						.getResponseReasonCode());
				receiptUrlBuffer.append("&");
				receiptUrlBuffer.append(
						ResponseField.RESPONSE_REASON_TEXT.getFieldName())
						.append("=");
				receiptUrlBuffer.append(result.getResponseMap().get(
						ResponseField.RESPONSE_REASON_TEXT.getFieldName()));

				if (result.isApproved()) {
					receiptUrlBuffer
							.append("&")
							.append(ResponseField.TRANSACTION_ID.getFieldName())
							.append("=");
					receiptUrlBuffer.append(result.getResponseMap().get(
							ResponseField.TRANSACTION_ID.getFieldName()));
				}
			}%>
document.location ="<%=receiptUrlBuffer.toString()%>";
		}
	</script>
	 
	
	 
</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>