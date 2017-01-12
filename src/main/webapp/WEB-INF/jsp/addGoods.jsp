<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<!DOCTYPE html>
<html>
<c:set var="title" value="Catalog"/>

<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

<%@ include file="/WEB-INF/jspf/nav.jspf" %>

<form id="saveGoodsForm" action="${pageContext.servletContext.contextPath}/application/catalog/saveGoods" method="POST">
	<fieldset>
		<label>SerialNo</label>
		<input type="text" name="serialNo" value="${it.serialNo }"/>
	</fieldset>
	<fieldset>
		<label>Name</label>
		<input type="text" name="name" value="${it.name }"/>
	</fieldset>
	<fieldset>
		<label>Description</label>
		<input type="text" name="description " value="${it.description }"/>
	</fieldset>
	<fieldset>
		<label>Quantity</label>
		<input type="text" name="quantity" value="${it.quantity }"/>
	</fieldset>
	<fieldset>
		<label>Price</label>
		<input type="text" name="integralPart" value="${it.price.integralPart }"/>.<input type="text" name="fractionalPart" value="${it.price.fractionalPart }"/>
	</fieldset>
	<button class="btn-submit">Add new goods</button>
</form>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>