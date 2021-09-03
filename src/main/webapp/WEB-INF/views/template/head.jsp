<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/" var="root"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="navbar navbar-inverse navbar-fixed-top scroll-me">
    <div class="container">
        <p class="text-white">DICTIONARY MANAGER</p>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="dictionaries?show">SHOW</a></li>
                <li><a href="#">DELETE</a></li>
                <li><a href="dictionaries?new">CREATE</a></li>
                <li><a href="${root}">HOME</a></li>
            </ul>
        </div>
    </div>
</div>