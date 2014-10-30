<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="WEB-INF/ErrorMessageHelper.jsp" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./CSS/FlightStyles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>


</head>
<body>

	
	<div class='main' style="width:750px">
		<p class='PageTitle'>Registration</p>
				
		<form action="Registration" method="post" onsubmit="return formSubmit();">
			<table class="center">
			
				<tr>
					<td colspan="2">
						
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><p class="TableHeader">Please fill out the form to register</p></td>
		
				</tr>
				<tr>
					<td align="right">User Name:</td>
					<td><input type="text" id="txtUserName" name="UserName"></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td><input type="password" id="txtPassword" name="Password"></td>
				</tr>
				<tr>
					<td align="right">Confirm Password:</td>
					<td><input type="password" id="txtConfirmPassword"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><label id="lblErrorMessage" style="visibility:hidden" ><font color="red" >Your Passwords do not match, Please Re enter them</font></label></td>	
				</tr>
				<tr>
					
					<td></td>
	
					<td align="left">
						
							<input type="submit" id="btnSubmitButton" name="btnSubmitButton" value="Submit" style="display:hidden"  />
						
					</td>
				</tr>
			
			</table>
		</form>
	</div>	
</body>

<script type="text/javascript">
		var typingTimer;
		var doneTypingInterval = 500;
	
		$("#btnSubmitButton").hide();
	
	
	function checkEquality(){
		var password = document.getElementById('txtPassword').value;
		var confirmpassword = document.getElementById('txtConfirmPassword').value;
		var submitButton = document.getElementById('btnSubmitButton');
		var errorLabel = document.getElementById('lblErrorMessage');
		
		
		
		if (!(confirmpassword.toLowerCase()=== password.toLowerCase())){
			errorLabel.style.visibility = "visible";
			$("#btnSubmitButton").hide();
			
		}
		else{
			errorLabel.style.visibility = "hidden";
			$("#btnSubmitButton").show();
		}
		
	}//end checkEquality
	
		
	$('#txtConfirmPassword').keyup(function(){
	    clearTimeout(typingTimer);
	    typingTimer = setTimeout(checkEquality, doneTypingInterval);
	});
	
	$('#txtPassword').keyup(function(){
	    clearTimeout(typingTimer);
	    typingTimer = setTimeout(checkEquality, doneTypingInterval);
	});
	

	function formSubmit(){
		var password = document.getElementById('txtPassword').value;
		var confirmpassword = document.getElementById('txtConfirmPassword').value;
		var userName = document.getElementById('txtUserName').value;
		if (!(/\S/.test(password)) || !(/\S/.test(confirmpassword)) || !(/\S/.test(userName))){
			alert("The Form is not correct, please make sure you have a valid user name , and matching passwords");	
			return false;
		}else return true;
		
	}
	
</script>

</html>