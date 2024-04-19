<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="성적 조회" />
<%@ include file="../common/head.jsp" %>
<script>
function getYearAndSemester(event) {
	const row = event.currentTarget;
	  const year = parseInt(row.getElementsByTagName('td')[1].textContent);
	  const semester = parseInt(row.getElementsByTagName('td')[2].textContent);

	  $.get('getYearAndSemester', {
		  year: year,
		  semester: semester,
	    }, function(data) {
		 
		    if (data.success) {
		        var tableContent = "";

		        data.data1.forEach(function(score, index) {

		            tableContent += '<tr><td class="bg-gray-100 font-normal">' + (index + 1) + '</td><td class="bg-gray-100 font-normal">' + score.year + '</td><td class="bg-gray-100 font-normal">' + score.semester + '</td><td class="bg-gray-100 font-normal">' + score.subject + '</td><td class="bg-gray-100">' + score.name + '</td><td class="bg-gray-100">' + score.credit + '</td><td class="bg-gray-100">'+ score.rank + '</td><td class="bg-gray-100">' + score.grade + '<td  class="bg-yellow-300 font-bold"><a href="modify?id=' + score.id + '">수정</a></td>' + '<td  class="bg-red-300 font-bold"><a href="delete?id=' + score.id + '">삭제</a></td>' + '</tr>';
		        });

		        $("#scoreTableId").html(tableContent);
		    } else {
		        alert(data.msg);
		    }
		}, 'json');

}



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
    tr {
    cursor: pointer;
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
            <c:forEach items="${totalScores}" var="totalScore" varStatus="status">   
      <!-- row 1 -->
      <tr onclick="getYearAndSemester(event)">      
        <td class="bg-gray-100 font-normal">${status.index + 1 }</td>
        <td class="bg-gray-100 font-normal">${totalScore.year }</td>
        <td class="bg-gray-100 font-normal">${totalScore.semester }</td>
        <td class="bg-gray-100 font-normal">${totalScore.year - 2020 } </td>
        <td class="bg-gray-100 font-normal">${totalScore.total_credit }</td>
        <td class="bg-gray-100 font-normal">${totalScore.average_grade}</td>
        
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
    <tbody id="scoreTableId">      <!-- row 1 -->
    </tbody>
  </table>
</div>
      </div>
    </div>

  </div>

</div>
<%@ include file="../common/foot.jsp" %>
