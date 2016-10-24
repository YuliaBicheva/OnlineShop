<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GSON with JSP</title>
	<script type="text/javascript" src="<c:url value="js/jquery-1.12.3.js"/>"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#findGoods").click(function(){
				$.ajax({
					type : 'GET',
					headers : {
						Accept : 'application/json; charset=utf-8',
						'Content-Type' : 'application/json; charset=utf-8'
					},
					success : function(result){
						var good = $.parseJSON(result);
							$("table#goodsTable tbody").html("<tr>"
									+ "<td>" + good.id + "</td>"
									+ "<td>" + good.serialNo + "</td>"
									+ "<td>" + good.description + "</td>"
									+ "<td>" + good.quantity + "</td>"
									+ "<td>" + good.producer.name + "</td>"
									+ "<td>" + good.countryOfOrigin.name + "</td>"
									+ "</tr>");
					},
					url:'controller?action=find'
				});
			});
			$("#findGoodsList").click(function(){
				$.ajax({
					type : 'GET',
					headers : {
						Accept : 'application/json; charset=utf-8',
						'Content-Type' : 'application/json; charset=utf-8'
					},
					success : function(result){
						var goods = $.parseJSON(result);
						$("table#goodsTable tbody").html("");
						for (var i = 0; i < goods.length; i++) {
 						var good = goods[i];
 						
							$("table#goodsTable tbody").append("<tr>"
									+ "<td>" + good.id + "</td>"
									+ "<td>" + good.serialNo + "</td>"
									+ "<td>" + good.description + "</td>"
									+ "<td>" + good.quantity + "</td>"
									+ "<td>" + good.producer.name + "</td>"
									+ "<td>" + good.countryOfOrigin.name + "</td>"
									+ "</tr>");
						}
 				},
					url:'controller?action=findAll'
				});
			});
		});
		
	</script>
</head>
<body>
	<a href="testAjax.jsp">Check how work Ajax</a>
	
	<fieldset>
		<input type="button" id="findGoods" value="Goods" />
	</fieldset>
	<fieldset>
		<input type="button" id="findGoodsList" value="GoodsList" />
	</fieldset>
	
	<table id="goodsTable">
		<thead>
			<tr>
				<th>#</th>
				<th>Id</th>
				<th>SerialNo</th>
				<th>Description</th>
				<th>Quantity</th>
				<th>Producer</th>
				<th>Country of origin</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</body>
</html>