<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.license.model.*"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="com.pro.model.*"%>
<%@ page import="java.util.*"%>


<%
	List<LicenseVO> list = (List) request.getAttribute("list");
	// 	pageContext.setAttribute("list", list);
%>

<jsp:useBean id="proSvc" scope="page" class="com.pro.model.ProService" />
<jsp:useBean id="memSvc" scope="page" class="com.mem.model.MemService" />


<html>
<head>
<title>listOnePRO.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body>
	<table>
		<tr>
			<th>license_no</th>
			<th>Pro_ID</th>
			<th>Name</th>
			<th>Lic_name</th>
			<th>no_reg</th>
			<th>l_pic</th>
			<th>?ק?</th>
			<th>?R??</th>
		</tr>

		<c:forEach var="licenseVO" items="${list}">
			<tr>
				<td>${licenseVO.license_no}</td>
				<td>${licenseVO.pro_ID}</td>
				<td>${memSvc.getOneMem(proSvc.getOnePro(licenseVO.getPro_ID()).mem_ID).mem_name}</td>
				<td>${licenseVO.lic_name}</td>
				<td>${licenseVO.no_reg}</td>
								<td><img src="<%=request.getContextPath() %>/front-end/ProAndClass/showPhotos.do?type=proPhoto&license_no=${licenseVO.license_no}" width="240" height="300"/>
				</td>
				<td>
					<FORM METHOD="post" action="license.do" style="margin-bottom: 0px;">
						<input type="submit" value="?ק?"> <input type="hidden"
							name="license_no" value="${licenseVO.license_no}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post" ACTION="license.do" style="margin-bottom: 0px;">
						<input type="submit" value="?R??"> <input type="hidden"
							name="pro_ID" value="${proVO.pro_ID}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>