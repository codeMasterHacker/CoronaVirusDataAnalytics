<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Results Page</title>
</head>
<body>

	<h1>Results</h1>

	<form action="SearchOperationsPage" method="get"> 
		<button>Return to Search Operations Page</button>
	</form>
	
	<form action="editFilesPage.jsp">
		<button>Go to Edit(Insert, Update, Delete) Files Page</button>
	</form>
	
	<c:set var="colNames" value="${sessionScope.columnNames}"/> 
	<c:set var="table" value="${sessionScope.table}"/> 
	
		<c:if test="${table != null}">
		
			<table>
    			<thead>
        			<tr>
        				<c:forEach var="colName" items="${colNames}">
        					<c:if test="${colNames != null}">
            					<th>${colName}</th>
            				</c:if>
        				</c:forEach>
        			</tr>
    			</thead>
    			<tbody>
        			<c:forEach var="row" items="${table}">
        				<tr>
            				<c:forEach var="column" items="${row}">
                				<td>
                    				<c:if test="${column != null}">
										${column}
									</c:if>
                				</td>
                			</c:forEach>
        				</tr>
        			</c:forEach>
    			</tbody>
			</table>
		
		</c:if>
		
		<c:if test="${table == null}">
			<b>Table is empty</b>
		</c:if>
	
</body>
</html>