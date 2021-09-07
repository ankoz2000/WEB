<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<h1>DICTIONARIES</h1>
<table class="iksweb">
    <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Condition</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="dictionary" items="${dictionaries}">
            <tbody class="parent">
                <tr>
                    <td><c:out value="${dictionary.id}" /></td>
                    <td><c:out value="${dictionary.name}" /></td>
                    <td><c:out value="${dictionary.condition}" /></td>
                </tr>
            </tbody>
            <tbody class="hide" style="display:none;">
                <tr>
                    <td colspan="3"><button class="btn add" id="${dictionary.id}"><i class="fas fa-plus"></i></button></td>
                </tr>
                <tiles:insertAttribute name="notes" />
            </tbody>
        </c:forEach>
    </tbody>
</table>