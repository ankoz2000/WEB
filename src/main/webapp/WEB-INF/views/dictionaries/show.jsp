<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1>Dictionaries</h1>
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
            <tr>
                <td><c:out value="${dictionary.id + 1}" /></td>
                <td><c:out value="${dictionary.name}" /></td>
                <td><c:out value="${dictionary.condition}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>