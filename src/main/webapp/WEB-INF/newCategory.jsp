<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

#container {
	width: 1000px;
	margin: 0px auto;
}



</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Category</title>
</head>
<body>

    
   	<div id="container">
   	
   	<h1>New Category</h1>
   	
	<form:form method="POST" action="/categories/new" modelAttribute="category">
<%-- 		<form:hidden path="id"/> --%>
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label><br>
	    
	    <input type="submit" value="Create"/>
	</form:form>
	<br>



	</div>

</body>
</html>