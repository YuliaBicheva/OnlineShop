<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
	<script type="text/javascript" src="<c:url value="js/jquery-1.12.3.js"/>"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#loginForm").click(function(){
				var login = $("#login").val();
				var password = $("#password").val();
				$.ajax({
					url : "controller?action=login",
					type : 'POST',
					data : {
						login : login,
						password : password
					},
					
					success : function(data){
						var response = $.parseJSON(data);
						if(response.status == 'SUCCESS'){
							$("#info").html("<bold>" + response.result + "</bold>");
							$("#login").val('');
							$("#password").val('');
							$("#info").show('slow');
							$("#error").hide('slow');
						}else{
							$("#error").html(response.result);
							$("#info").hide('slow');
							$("#error").show('slow');
						}
					},
					error : function(e){
						alert("ERROR " + e);
					}
				});
			});
		});
	</script>
</head>
<body>
	
	<div id="error"></div>
	<div id="info"></div>

	<form>
		<fieldset>
			Login: <input type="text" id="login"/>
		</fieldset>
		<span id="error"></span>
		<fieldset>
			Password: <input type="text" id="password"/>
		</fieldset>
		
		<input type="button" value="LogIn" id="loginForm"/>
	</form>
	
</body>	
</html>