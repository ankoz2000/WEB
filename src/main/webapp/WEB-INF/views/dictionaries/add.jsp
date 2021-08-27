<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1>ADD DICTIONARY</h1>
<div id="wrapper">
	<form id="add" method="post" action="" autocomplete="off">
		<input type="text" id="name" name="name" placeholder="dictionary name" />
		<input type="text" id="word" name="pass" placeholder="Word: [A-Za-zА-Яа-я]{4}" />
		<input type="text" id="translate" name="translate" placeholder="Text: [A-Za-zА-Яа-я]{4}" />
		<button type="submit">&#xf0da;</button>
	</form>