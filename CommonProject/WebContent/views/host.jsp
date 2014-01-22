<%@ page import="net.authorize.sim.*"%>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
    </h2>
<%
	 String apiLoginId = "76Z32SKzjqq";
 String transactionKey = "485b7hLSfXy8K3t9";
 String relayResponseUrl = "http://localhost:8080/eCOMM2.0/response.jsp";

 String amount = "1.99";
 Fingerprint fingerprint = Fingerprint.createFingerprint(
apiLoginId,
transactionKey,
1234567890, // random sequence used for creating the finger print
amount);

 long x_fp_sequence = fingerprint.getSequence();
long x_fp_timestamp = fingerprint.getTimeStamp();
 String x_fp_hash = fingerprint.getFingerprintHash();
%>


<FORM NAME='secure_redirect_form' ID='secure_redirect_form_id'
	 ACTION='https://test.authorize.net/gateway/transact.dll' METHOD='POST'>
	  <label>CreditCardNumber</label><input type='text' class='text'
		name='x_card_num' size='15'>     </input>   <label>Exp.</label><input
		type='text' class='text' name='x_exp_date' size='4'></input>   <label>Amount</label><input
		type='text' class='text' name='x_amount' size='9'     readonly
		value='<%=amount%>'></input>   <INPUT TYPE='HIDDEN'
		NAME='x_invoice_num' VALUE='<%=System.currentTimeMillis()%>'>
	  <INPUT TYPE='HIDDEN' NAME='x_relay_url' VALUE='<%=relayResponseUrl%>'>
	  <INPUT TYPE='HIDDEN' NAME='x_login' VALUE='<%=apiLoginId%>'>
	  <INPUT TYPE='HIDDEN' NAME='x_fp_sequence' VALUE='<%=x_fp_sequence%>'>
	  <INPUT TYPE='HIDDEN' NAME='x_fp_timestamp'
		VALUE='<%=x_fp_timestamp%>'>   <INPUT TYPE='HIDDEN'
		NAME='x_fp_hash' VALUE='<%=x_fp_hash%>'>   <INPUT
		TYPE='HIDDEN' NAME='x_version' VALUE='3.1'>   <INPUT
		TYPE='HIDDEN' NAME='x_method' VALUE='CC'>   <INPUT
		TYPE='HIDDEN' NAME='x_type' VALUE='AUTH_CAPTURE'>   <INPUT
		TYPE='HIDDEN' NAME='x_amount' VALUE='<%=amount%>'>   <INPUT
		TYPE='HIDDEN' NAME='x_test_request' VALUE='FALSE'>   <INPUT
		TYPE='HIDDEN' NAME='notes' VALUE='extra hot please'>   <INPUT
		TYPE='SUBMIT' NAME='buy_button' VALUE='BUY'>
</FORM>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>