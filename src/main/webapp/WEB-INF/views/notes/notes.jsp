<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:forEach var="note" items="${notes}">
    <tr class="canRemove">
        <td><button class="btn delete"><i class="fa fa-trash" aria-hidden="true"></i></button><button class="btn edit"><i class="fa fa-pencil" aria-hidden="true"></i></button></td>
        <td colspan="2"><c:out value="${note.id}" />. <c:out value="${note.text}" /></td>
    </tr>
</c:forEach>