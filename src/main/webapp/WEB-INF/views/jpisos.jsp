<%@ page language="java" contentType="aplication/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="tam" value="${fn:length(lpisos)}" />
<c:out value="[" />
<c:forEach var="list" items="${lpisos}" varStatus="estado">
	{"cod_piso":"<c:out value="${list.cod_piso }" />"<c:out value="," />"imagen":"<c:out
		value="${list.imagenSalon}" />"<c:out value="," />"imagen2":"<c:out
		value="${list.imagenCocina}" />"<c:out value="," />"imagen3":"<c:out
		value="${list.imagenDormitorio}" />"<c:out value="," />"imagen4":"<c:out
		value="${list.imagenBano}" />"<c:out value="," />"direccion":"<c:out
		value="${list.direccion}" />"<c:out value="," />"descripcion":"<c:out
		value="${list.descripcion }" />"<c:out value="," />"plazas":"<c:out
		value="${list.plazas }" />"<c:out value="," />"precio":"<c:out
		value="${list.precio }" />"<c:out value="," />"cod_pisoA":"<c:out
		value="${alumno.cod_piso }" />"}
	<c:if test="${estado.count < tam }">
		<c:out value="," />
	</c:if>
</c:forEach>
<c:out value="]" />
