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
            <tbody class="parent">
                <tr>
                    <td><c:out value="${dictionary.id + 1}" /></td>
                    <td><c:out value="${dictionary.name}" /></td>
                    <td><c:out value="${dictionary.condition}" /></td>
                </tr>
            </tbody>
            <tbody class="hide" style="display:none;">
                <tr>
                    <td colspan="3"><button class="btn add" id="${dictionary.id}"><i class="fas fa-plus"></i></button></td>
                </tr>
                <c:forEach var="note" items="${notes}">
                    <c:choose><c:when test="${note.getDictionary().id == dictionary.id}">
                    <tr>
                        <td><button class="btn delete"><i class="fa fa-trash" aria-hidden="true"></i></button><button class="btn edit"><i class="fa fa-pencil" aria-hidden="true"></i></button></td>
                        <td colspan="2"><c:out value="${note.id + 1}" />. <c:out value="${note.text}" /></td>
                    </tr>
                    </c:when></c:choose></td>
                </c:forEach>
            </tbody>
        </c:forEach>
    </tbody>
</table>