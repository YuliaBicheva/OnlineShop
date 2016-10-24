<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Test heroku AJAX</title>
	<script type="text/javascript" src="<c:url value="js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript">
		$(document).ready(function(){
				$('#btnSum').click(function(){
					var number1 = $('#number1').val();
					var number2 = $('#number2').val();
					var url = 'summarizing';
					
					$.ajax({
						type : 'POST',
						url : url,
						data : {
							number1 : number1,
							number2 : number2
						},
						success : function(result){
							$('#result1').html(result);
							$('#errorMsg').html('');
						},
						error: function(){
							$('#errorMsg').html("Please, enter only integer number");
							$('#result1').html('');
						}
					});
				});
			}
		);
	</script>
</head>
<body>
<h2>Deploy Heroku app using github</h2>

<form>
	Number1 <input type="text" id="number1">
	<br/>
	Number2 <input type="text" id="number2">
	<br/>
	Result: <span id="result1"></span>
	<br/>
	<span id="errorMsg" style="color: red;"></span>
	<br/>
	<input type="button" id="btnSum" value="Get sum"/>
</form>
</body>
</html>
