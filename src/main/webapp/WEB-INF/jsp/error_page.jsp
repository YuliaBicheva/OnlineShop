<%@ page isErrorPage="true" %>
<%@ page import="java.io.PrintWriter" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>

<%@ include file="/WEB-INF/jspf/nav.jspf" %>

<div>
	<h2 class="error">
		The following error occurred
	</h2>
				
	<%-- this way we obtain an information about an exception (if it has been occurred) --%>
	<c:set var="code" value="${requestScope['javax.servlet.error.status_code']}"/>
	<c:set var="message" value="${requestScope['javax.servlet.error.message']}"/>
	<c:set var="exception" value="${requestScope['javax.servlet.error.exception']}"/>
	
	<c:if test="${not empty code}">
		<h3>Error code: ${code}</h3>
	</c:if>			
	
	<c:if test="${not empty message}">
		<h3>${message}</h3>
	</c:if>
	
	<c:if test="${not empty exception}">
		<% exception.printStackTrace(new PrintWriter(out)); %>
	</c:if>
	
	<c:if test="${not empty it.code}">
		<h3>${it.code}</h3>
	</c:if>

	<c:if test="${not empty it.message}">
		<h3>${it.message}</h3>
	</c:if>
	
	<c:if test="${not empty it.exception}">
		<% exception.printStackTrace(new PrintWriter(out)); %>
	</c:if>
</div>


<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>