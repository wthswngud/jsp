<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ attribute name="size" type="java.lang.Integer" required="false"%>
<font color="${color}">
<%-- 	<c:if test="${size==null}"> --%>
<%-- 		<c:set value="5" var="size"/> --%>
<%-- 	</c:if> --%>
	<c:forEach begin="1" end="${size == null ? 5 : size}">=</c:forEach>
</font><br>
color : ${color}