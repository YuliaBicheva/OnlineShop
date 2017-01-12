<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<!DOCTYPE html>
<html>
<c:set var="title" value="Catalog"/>

<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

<%@ include file="/WEB-INF/jspf/nav.jspf" %>

<form id="saveGoodsForm" action="${pageContext.servletContext.contextPath}/${it.formAction}" method="POST">
	<fieldset>
		<label>SerialNo</label>
		<input type="text" name="serialNo" value="${it.goods.serialNo }"/>
	</fieldset>
	<fieldset>
		<label>Name</label>
		<input type="text" name="name" value="${it.goods.name }"/>
	</fieldset>
	<fieldset>
		<label>Description</label>
		<input type="text" name="description" value="${it.goods.description }"/>
	</fieldset>
	<fieldset>
		<label>Quantity</label>
		<input type="text" name="quantity" value="${it.goods.quantity }"/>
	</fieldset>
	<fieldset>
		<label>Price</label>
		<input type="text" name="integralPart" value="${it.goods.price.integralPart }"/>.<input type="text" name="fractionalPart" value="${it.goods.price.fractionalPart }"/>
	</fieldset>
	<input type="hidden" name="id" value="${it.goods.id }">
	<button class="btn-submit">Add new goods</button>
</form>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>