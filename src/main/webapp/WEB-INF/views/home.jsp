<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Web Dictionaries</title>

        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <spring:url value="/res/css" var="css"/>

        <link rel="stylesheet" href="${css}/style.css">
        <link rel="stylesheet" href="${css}/menu.css">
        <link rel="stylesheet" href="${css}/button.css">
        <link rel="stylesheet" href="${css}/nav.css">
    </head>

    <body>
        <tiles:insertAttribute name="menu"/>
        <tiles:insertAttribute name="content"/>
    </body>

</html>