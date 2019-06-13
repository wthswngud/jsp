<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="rangers" required="false" type="java.lang.String"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<select>
	
	<c:forTokens items="${rangers}" delims="," var="i">
		<option>${i}</option>
	</c:forTokens>
</select>