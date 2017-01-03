<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<!DOCTYPE html>
<html>
<c:set var="title" value="Catalog"/>

<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

<%@ include file="/WEB-INF/jspf/nav.jspf" %>

<h1>Catalog Page</h1>

<table>
	<tr>
		<th>Serial No</th>
		<th>Name</th>
		<th>Description</th>
		<th>Quantity</th>
		<th>Price</th>
	</tr>
	<c:forEach items="${catalog }" var="goods">
		<tr>
			<td>${goods.serialNo }</td>
			<td>${goods.name }</td>
			<td>${goods.description }</td>
			<td>${goods.quantity }</td>
			<td>${goods.price.integralPart }.${goods.price.fractionalPart } UAH</td>
		</tr>
	</c:forEach>
</table>

<form action="${pageContext.servletContext.contextPath}/application/addGoods" method="POST">
	<fieldset>
		<label>SerialNo</label>
		<input type="text" name="serialNo"/>
	</fieldset>
	<fieldset>
		<label>Name</label>
		<input type="text" name="name"/>
	</fieldset>
	<fieldset>
		<label>Description</label>
		<input type="text" name="description"/>
	</fieldset>
	<fieldset>
		<label>Quantity</label>
		<input type="text" name="quantity"/>
	</fieldset>
	<fieldset>
		<label>Price</label>
		<input type="text" name="integralPart"/>.<input type="text" name="fractionalPart"/>
	</fieldset>
	<input type="submit" value="Add new goods">
</form>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>