<%@ page contentType="text/html; charse=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.classType.model.*"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="com.classType.model.*"%>
<%@ page import="com.license.model.*"%>
<%@ page import="com.pro.model.*"%>
<%@ page import="java.util.*"%>

<%
MemVO memVOLogin = (MemVO) session.getAttribute("memVOLogin");
ProVO proVOLogin = (ProVO) session.getAttribute("proVOLogin");
%>

<html>
<head>

<title>�M�~���ӽ�</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

table td, table th {
	border: 1px solid #ddd;
	padding: 8px;
}
</style>

</head>

<body>

	<p align="center">�ק�g��</p>
	<form id="myForm" name="myForm" action="pro.do" method="POST" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>�m�W</td>
				<td><input type="hidden" name="mem_id" value="${ memVOLogin.mem_id}">${ memVOLogin.mem_name}
				</td>
			</tr>



			<tr>
				<td>�ҵ{���O</td>
				<td><c:forEach var="ClassTypeVO" items="${classTypeSvc.all}">
						<label> <input type="checkbox" name="c_type_no"
							value="${ClassTypeVO.c_type_no}">${ClassTypeVO.t_name}
						</label>

					</c:forEach></td>
			</tr>

			<tr>
				<td>�ҷӦW��</td>
				<td><input type="text" name="lic_name" value=""> �ҷӽs�X 
				<input type="text" name="no_reg"> <input type="file" name="l_pic">
					<!-- <div id="preview"> --></td>
			</tr>
			
			<tr>
				<td>�ҷӦW��</td>
				<td><input type="text" name="lic_name" value=""> �ҷӽs�X 
				<input type="text" name="no_reg"> <input type="file" name="l_pic">
					<!-- <div id="preview"> --></td>
			</tr>
			
			<tr>
				<td>�ҷӦW��</td>
				<td><input type="text" name="lic_name" value=""> �ҷӽs�X 
				<input type="text" name="no_reg"> <input type="file" name="l_pic">
					<!-- <div id="preview"> --></td>
			</tr>
			

			<tr>
				<td>�g��</td>
				<td><textarea cols="100" rows="10" name="expr" placeholder="�п�J�g��...">
					</textarea>
			<tr>
				<td></td>
				<td>
					<input type="hidden" name="action" value="insert"> 
					<input type="submit" value="�e�X">
				</td>
			</tr>

		</table>

	</form>
	
	
</body>
</html>