<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="styles.css" media="screen"/>

<title>Results</title>
</head>
<body>

	<h1>Results</h1>
	
	<div class="wrapper">
			<div class="row">
				<div class="column">
					<div class="column1">
						<form action="SearchOperationsPage" method="get"> 
							<input type="submit" name="SearchOperationsPage" value="Go back to homepage" class="gobutton"/>
						</form>
					</div>
				</div>
				
				<div class="column">
					<div class="column2">
						<form action="editFilesPage.jsp" method="post">
							<input type="submit" name="editFiles" value="Go to Edit(Insert, Update, Delete) Files Page" class="gobutton"/>
						</form>
					</div>
				</div>
			</div>
		</div>
		<br><br>
	<div class="wrapper">
			<div class="row">
				<div class="column" style="font-size:12px;">
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
					</div>
				</div>
			</div>

</body>
</html>