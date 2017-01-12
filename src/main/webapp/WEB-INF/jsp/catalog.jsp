<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<!DOCTYPE html>
<html>
<c:set var="title" value="Catalog"/>

<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

<%@ include file="/WEB-INF/jspf/nav.jspf" %>

<table id="goodsList">
	<caption>Goods catalog</caption>
	<tr>
		<th>Serial No</th>
		<th>Name</th>
		<th>Description</th>
		<th>Quantity</th>
		<th>Availability</th>
		<th>Price</th>
	</tr>
	<tfoot>
		<tr>
			<td colspan="6">Please, wait! Catalog is loading!</td>
		</tr>
	</tfoot>
</table>

<div class="pagination">
	<ul>
	</ul>
</div>

<a class="addGoodsLink" href="${pageContext.servletContext.contextPath}/application/catalog/addGoods">Add new goods</a>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>