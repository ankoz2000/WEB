<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1>ADD DICTIONARY</h1>
<div id="wrapper">

	<sf:form id="add" method="POST" action="" autocomplete="off" modelAttribute="dictionary">
		<sf:input path="name" type="text" id="name" name="name" placeholder="dictionary name" />
		<sf:input   path="condition"
                    type="text"
                    id="condition"
                    name="condition"
                    placeholder="[A-Za-zА-Яа-я]{4}\\s[A-Za-zА-Яа-я]{4}" />
		<button type="submit">&#xf0da;</button>
	</sf:form>