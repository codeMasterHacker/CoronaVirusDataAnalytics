<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Results Page</title>
</head>
<body>

	<c:set var="colNames" value="${sessionScope.columnNames}"/> 
	<c:set var="table" value="${sessionScope.countryByDateTable}"/> 
	
		<c:if test="${table != null}">
		
			<table>
    				<thead>
        				<tr>
        					<c:forEach var="colName" items="${colNames}">
            						<th>${colName}</th>
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
