<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/res/js" var="js"/>
<h1>EDIT NOTE</h1>
<div id="wrapper">

	<sf:form id="add" method="POST" action="${note.id}/${dictionaryId}"
	autocomplete="off" modelAttribute="note" accept-charset='UTF-8'>
		<sf:input path="text" type="text" id="text" name="text" placeholder="${note.text}" />
		<sf:input   path="translate"
                    type="text"
                    id="translate"
                    name="translate"
                    placeholder="${note.translate}" />
		<button type="submit">&#xf0da;</button>
	</sf:form>
</div>