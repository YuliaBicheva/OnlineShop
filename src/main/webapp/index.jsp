<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>

<%@ include file="/WEB-INF/jspf/nav.jspf" %>

<form action="${pageContext.servletContext.contextPath}/login" method="POST">
	<input type="submit" value="Check login">
</form>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>