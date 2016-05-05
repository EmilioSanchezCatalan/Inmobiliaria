<%@ page language="java" contentType="aplication/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="tam" value="${fn:length(lalumnos)}" />
<c:out value="[" />
<c:forEach var="list" items="${lalumnos}" varStatus="estado">
	{"dni":"<c:out value="${list.dni }" />"<c:out value="," />"nombre":"<c:out
		value="${list.nombre}" />"<c:out value="," />"apellidos":"<c:out
		value="${list.apellidos}" />"<c:out value="," />"fecha_nacimiento":"<c:out
		value="${list.fecha_nacimiento }" />"<c:out value="," />"tlf":"<c:out
		value="${list.tlf }" />"<c:out value="," />"correo":"<c:out
		value="${list.correo }" />"<c:out value="," />"cod_piso":"<c:out
		value="${list.cod_piso }" />"<c:out value="," />"usuario":"<c:out
		value="${list.usuario }" />"}
	<c:if test="${estado.count < tam }">
		<c:out value="," />
	</c:if>
</c:forEach>
<c:out value="]" />