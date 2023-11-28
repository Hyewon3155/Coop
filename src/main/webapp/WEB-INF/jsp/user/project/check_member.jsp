<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="프로젝트 생성" />
<%@ include file="../common/head.jsp" %>


 <style>
    nav {
       height: 100vh;
       width: 100%:
    }
 </style>
<nav class="bg-gray-200 py-10">
    <div class="max-w-2xl mx-auto bg-white p-8 rounded-lg shadow-md">
         <div class="table-box-type-1">
				<table class="table w-full">
					<colgroup>
						<col width="60"/>
						<col width="200"/>
						<col width="50"/>
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>부서</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach  items="${members}" var="member">
							<tr>
								<td>${member.id}</td>
								<td>${member.name}</td>
								<td>${member.depart}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

      </div>
</nav>
<%@ include file="../common/foot.jsp" %>