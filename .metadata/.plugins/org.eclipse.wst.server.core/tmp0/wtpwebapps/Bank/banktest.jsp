<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script>
	function test(){
		$.ajax
		({
		    type: "POST",
		    url: 'PostTransaction',
		    dataType: 'json',
		    data:{ 	
			"nAccountNumber":"13",
			"nRoutingNumber":"13",
			"dCost":"1234"
					},
		    success: function (data) {
				alert(JSON.stringify(data));
		    },
		    error: function (data){
		    	alert("ERROR");
		    }
		});
	}

</script>

<body onload="test()">

</body>
</html>