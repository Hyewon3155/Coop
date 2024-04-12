<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="작업 조회" />
<%@ include file="../common/head.jsp" %>
<script>
</script>
<style>
html, body {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
   
}
.work-grid-container {
  height:100%;
  width:100%;
  display: grid;
  grid-template-columns: 1fr 1fr; 
  grid-template-rows: 1fr 1fr; 
  gap: 10px;
}

.item1 {
  grid-column: 1; /* 1열 전체 차지 */
  grid-row: 1 / span 2; /* 1행부터 시작하여 2행까지 차지 */
}

.item2 {
  grid-column: 2; /* 2열 전체 차지 */
  grid-row: 1 / span 2; /* 1행부터 시작하여 2행까지 차지 */
}

    table, th, td {
        border: none;
        border-collapse: collapse;
        text-align: center;
    }
  

</style>
<div class="work-grid-container">
  <div class="item1">
    <div class="card w-full h-full bg-base-100 shadow-xl">
      <div class="card-body">
        <h2 class="text-3xl font-bold">성적집계내역</h2>
        <div class="overflow-x-auto shadow-xl">
  <table class="table w-full horizontal-border-only">
  <colgroup>
  						<col width="20"/>
						<col width="20"/>
						<col width="20"/>
						<col width="20"/>
						<col width="20"/>
						<col width="20"/>
						<col width="20"/>
						<col width="20"/>
					</colgroup>
    <!-- head -->
    <thead>
      <tr>
       <th class="bg-blue-300 text-lg text-white">순번</th>
       <th class="bg-blue-300 text-lg text-white">학년도</th>
       <th class="bg-blue-300 text-lg text-white">학기</th>
      <th class="bg-blue-300 text-lg text-white">이수학년</th>
        <th class="bg-blue-300 text-lg text-white">신청학점</th>
        <th class="bg-blue-300 text-lg text-white">취득학점</th>
        <th class="bg-blue-300 text-lg text-white">평점계</th>
        <th class="bg-blue-300 text-lg text-white">백분위점수</th>
      </tr>
    </thead>
    <tbody  id="tableBodyId">
            <c:forEach items="${toDos}" var="toDo" varStatus="status" >          
    <input type="hidden" value="${toDo.title }" id="toDoId"/>
      <!-- row 1 -->
      <tr>
        <td class="bg-gray-100 font-normal">${status.index + 1}</td>
        <td class="bg-gray-100 font-normal">${toDo.startDate.substring(0, 10) }</td>
        <td class="bg-gray-100 font-normal">${toDo.endDate.substring(0, 10) }</td>
        <td class="bg-gray-100 font-normal">${toDo.projectName }</td>
        <td class="bg-gray-100">${toDo.title }</td>
        <c:choose>
    		<c:when test="${toDo.status == 1}">
    			<td class="bg-yellow-200">
    			   <button class="statusChangeBtn" data-id="${toDo.id}" data-new-status="2">생성 완료</button>
    			</td>
    		</c:when>
    		<c:when test="${toDo.status == 2}">
    		    <td class="bg-red-200">
    		      <button class="statusChangeBtn" data-id="${toDo.id}" data-new-status="3">작업중</button>
    		    </td>
    		</c:when>
		    <c:otherwise>
		    </c:otherwise>
		</c:choose>
		      </tr>
		    </c:forEach>
    </tbody>
  </table>
</div>
      </div>
    </div>
  </div>
    <div class="item2">
    <div class="card w-full h-full bg-base-100 shadow-xl">
      <div class="card-body">
        <h2 class="text-3xl font-bold">학기별 성적</h2>
           <div class="overflow-x-auto shadow-xl text-xl">
  <table class="table w-full horizontal-border-only">
    <colgroup>
    					<col width="20"/>
    					<col width="20"/>
    					<col width="20"/>
						<col width="50"/>
						<col width="20"/>
						<col width="20"/>
						<col width="20"/>
					</colgroup>
    <thead>
      <tr>
      <th class="bg-blue-300 text-lg text-white">순번</th>
      <th class="bg-blue-300 text-lg text-white">학년도</th>
      <th class="bg-blue-300 text-lg text-white">이수구분</th>
      <th class="bg-blue-300 text-lg text-white">교과목명</th>
      <th class="bg-blue-300 text-lg text-white">학점</th>
        <th class="bg-blue-300 text-lg text-white">등급</th>
        <th class="bg-blue-300 text-lg text-white">평점</th>
      </tr>
    </thead>
   <c:forEach items="${Dones}" var="Done" varStatus="status">
    <tbody>
      <!-- row 1 -->
      <tr>
        <th>${status.index + 1 }</th>
        <th>${Done.projectName }</th>
        <td>${Done.title }</td>
        <td class="bg-green-200">작업 완료</td>
      </tr>
    </tbody>
    </c:forEach>
  </table>
</div>
      </div>
    </div>
  </div>

</div>
<%@ include file="../common/foot.jsp" %>
