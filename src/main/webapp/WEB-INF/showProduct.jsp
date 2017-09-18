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
<title>${ product.name }</title>
</head>
<body>

   	<div id="container">
   	
   	<h1>${ product.name }</h1>
   	

   	<h3>Add Category:</h3>
   	<form method="post" action="/products/${product.id}">
		<select name="category">
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}"> ${category.name}</option>
			</c:forEach>
		</select>
		
		<input type="submit" value="Add"></input>
	</form>
	
	<h2>Categories:</h2>
   	
 	<c:forEach items="${product.categories}" var="category" varStatus="loop">
	  <h4>- <c:out value="${category.name}"/></h4>
	</c:forEach>



	</div>

</body>
</html>