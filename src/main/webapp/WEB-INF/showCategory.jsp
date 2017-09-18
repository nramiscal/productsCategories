<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>${ category.name }</title>
</head>
<body>

   	<div id="container">
   	
   	<h1>${ category.name }</h1>
   	

   	<h3>Add Product:</h3>
   	<form method="post" action="/categories/${category.id}">
		<select name="product">
			<c:forEach items="${products}" var="product">
				<option value="${product.id}"> ${product.name}</option>
			</c:forEach>
		</select>
		
		<input type="submit" value="Add"></input>
	</form>
	
	<h3>Products:</h3>
   	
 	<c:forEach items="${category.products}" var="product" varStatus="loop">
	  <h4>- <c:out value="${product.name}"/></h4>
	</c:forEach>



	</div>

</body>
</html>