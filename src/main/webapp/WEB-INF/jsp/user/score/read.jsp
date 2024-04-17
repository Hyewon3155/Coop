<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="성적 조회" />
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
  height: 100%;
  width: 100%;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 1fr; /* 2개의 행 */
  gap: 10px;
}

.item1 {
  grid-row: 1; /* 1행 전체 차지 */
}

.item2 {
  grid-row: 2; /* 2행 전체 차지 */
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
					</colgroup>
    <!-- head -->
    <thead>
      <tr>
       <th class="bg-blue-300 text-lg text-white">순번</th>
       <th class="bg-blue-300 text-lg text-white">학년도</th>
       <th class="bg-blue-300 text-lg text-white">학기</th>
      <th class="bg-blue-300 text-lg text-white">이수학년</th>
        <th class="bg-blue-300 text-lg text-white">취득학점</th>
        <th class="bg-blue-300 text-lg text-white">평균평점</th>
      </tr>
    </thead>
        <tbody  id="tableBodyId">
            <c:forEach items="${totalScroes}" var="totalScore" varStatus="status" >          
      <!-- row 1 -->
      <tr>
        <td class="bg-gray-100 font-normal">${status.index + 1}</td>
        <td class="bg-gray-100 font-normal">${totalScore.year }</td>
        <td class="bg-gray-100 font-normal">${totalScore.semester }</td>
        <td class="bg-gray-100 font-normal">${totalScore.year } - 2020</td>
        <td class="bg-gray-100 font-normal">${totalScore.total_credit }</td>
        <td class="bg-gray-100 font-normal">${sum}</td>
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
						<col width="20"/>
						<col width="20"/>
						<col width="20"/>
					</colgroup>
    <thead>
      <tr>
      <th class="bg-blue-300 text-lg text-white">순번</th>
      <th class="bg-blue-300 text-lg text-white">학년도</th>
      <th class="bg-blue-300 text-lg text-white">학기</th>
      <th class="bg-blue-300 text-lg text-white">이수구분</th>
      <th class="bg-blue-300 text-lg text-white">교과목명</th>
      <th class="bg-blue-300 text-lg text-white">학점</th>
        <th class="bg-blue-300 text-lg text-white">등급</th>
        <th class="bg-blue-300 text-lg text-white">평점</th>
        <th class="bg-blue-300 text-lg text-white">수정</th>
        <th class="bg-blue-300 text-lg text-white">삭제</th>
        
        
      </tr>
    </thead>
    <tbody  id="tableBodyId">      <!-- row 1 -->
      <tr>
        <td class="bg-gray-100 font-normal">1</td>
        <td class="bg-gray-100 font-normal">2021</td>
        <td class="bg-gray-100 font-normal">1학기</td>
        <td class="bg-gray-100 font-normal">교양필수</td>
        <td class="bg-gray-100 font-normal">사회봉사 I</td>
        <td class="bg-gray-100 font-normal">1</td>
        <td class="bg-gray-100 font-normal">P</td>
        <td class="bg-gray-100 font-normal">0</td>
        <td  class="bg-yellow-300 font-bold"><button>수정</button></td>
        <td  class="bg-red-300 font-bold"><button>삭제</button></td>
     </tr>
    </tbody>
  </table>
</div>
      </div>
    </div>

  </div>

</div>
<%@ include file="../common/foot.jsp" %>
