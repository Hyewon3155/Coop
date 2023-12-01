<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="작업 조회" />
<%@ include file="../common/head.jsp" %>
<script>
	function handleSortChange() {
	    var selectedOption = document.getElementById('sortSelect').value;
	
	    switch (selectedOption) {
	        case 'startDateAscMember':
	            sortByStartDateAscMember();
	            break;
	        case 'startDateDescMember':
	            sortByStartDateDescMember();
	            break;
	        case 'endDateAscMember':
	            sortByEndDateAscMember();
	            break;
	        case 'endDateDescMember':
	            sortByEndDateDescMember();
	            break;
	    }
	}
	
	function sortByStartDateAscMember() {
        var member_id = document.getElementById('member_id').value;
        var project_id = document.getElementById('project_id').value;
		$.get('sortByStartDateAscMember', {
			 member_id: member_id,
		      project_id: project_id,
		}, function(data) {
	            if (data.success) {
		        // 서버 응답에 따라 이 부분이 달라질 수 있습니다.
		    	var tableContent = "";

		    	data.data1.forEach(function(toDo, index) {
		    	    var statusCellContent = "";

		    	    if (toDo.status === 1) {
		    	        statusCellContent = '<td class="bg-yellow-200">생성 완료</td>';
		    	    } else if (toDo.status === 2) {
		    	        statusCellContent = '<td class="bg-red-200">작업중</td>';
		    	    } else {
		    	        statusCellContent = '<td></td>';
		    	    }

		    	    tableContent += "<tr><td>" + (index + 1) + "</td><td class='bg-gray-100 font-normal'>" + toDo.startDate.substring(0, 10) + "</td><td class='bg-gray-100 font-normal'>" + toDo.endDate.substring(0, 10) + "</td><td class='bg-gray-100 font-normal'>" + toDo.projectName + "</td><td class='bg-gray-100'>" + toDo.title + "</td>" + statusCellContent + "</tr>";
		    	});

		    	// 이제 tableContent를 DOM에 삽입할 수 있습니다.
		    	$("#tableBodyId").html(tableContent);
		    } else {
		        alert(data.msg);
		    }
		}, 'json');

	}


	
	function sortByStartDateDescMember() {
		 var member_id = document.getElementById('member_id').value;
	     var project_id = document.getElementById('project_id').value;
		$.get('sortByStartDateDescMember', {
			member_id: member_id,
			project_id: project_id,
		},function(data) {
		    if (data.success) {
		        // 서버 응답에 따라 이 부분이 달라질 수 있습니다.
		    	var tableContent = "";

		    	data.data1.forEach(function(toDo, index) {
		    	    var statusCellContent = "";

		    	    if (toDo.status === 1) {
		    	        statusCellContent = '<td class="bg-yellow-200">생성 완료</td>';
		    	    } else if (toDo.status === 2) {
		    	        statusCellContent = '<td class="bg-red-200">작업중</td>';
		    	    } else {
		    	        statusCellContent = '<td></td>';
		    	    }

		    	    tableContent += "<tr><td>" + (index + 1) + "</td><td class='bg-gray-100 font-normal'>" + toDo.startDate.substring(0, 10) + "</td><td class='bg-gray-100 font-normal'>" + toDo.endDate.substring(0, 10) + "</td><td class='bg-gray-100 font-normal'>" + toDo.projectName + "</td><td class='bg-gray-100'>" + toDo.title + "</td>" + statusCellContent + "</tr>";
		    	});

		    	// 이제 tableContent를 DOM에 삽입할 수 있습니다.
		    	$("#tableBodyId").html(tableContent);
		    } else {
		        alert(data.msg);
		    }
		}, 'json');
	}
	
	function sortByEndDateAscMember() {
		 var member_id = document.getElementById('member_id').value;
	     var project_id = document.getElementById('project_id').value;
		$.get('sortByEndDateAscMember', {
			member_id: member_id,
			project_id: project_id,
		},function(data) {
		    if (data.success) {
		        // 서버 응답에 따라 이 부분이 달라질 수 있습니다.
		    	var tableContent = "";

		    	data.data1.forEach(function(toDo, index) {
		    	    var statusCellContent = "";

		    	    if (toDo.status === 1) {
		    	        statusCellContent = '<td class="bg-yellow-200">생성 완료</td>';
		    	    } else if (toDo.status === 2) {
		    	        statusCellContent = '<td class="bg-red-200">작업중</td>';
		    	    } else {
		    	        statusCellContent = '<td></td>';
		    	    }

		    	    tableContent += "<tr><td>" + (index + 1) + "</td><td class='bg-gray-100 font-normal'>" + toDo.startDate.substring(0, 10) + "</td><td class='bg-gray-100 font-normal'>" + toDo.endDate.substring(0, 10) + "</td><td class='bg-gray-100 font-normal'>" + toDo.projectName + "</td><td class='bg-gray-100'>" + toDo.title + "</td>" + statusCellContent + "</tr>";
		    	});

		    	// 이제 tableContent를 DOM에 삽입할 수 있습니다.
		    	$("#tableBodyId").html(tableContent);
		    } else {
		        alert(data.msg);
		    }
		}, 'json');
	}
	
	function sortByEndDateDescMember() {
		var member_id = document.getElementById('member_id').value;
	     var project_id = document.getElementById('project_id').value;
		$.get('sortByEndDateDescMember', {
			member_id: member_id,
			project_id: project_id,
		},function(data) {
		    if (data.success) {
		        // 서버 응답에 따라 이 부분이 달라질 수 있습니다.
		    	var tableContent = "";

		    	data.data1.forEach(function(toDo, index) {
		    	    var statusCellContent = "";

		    	    if (toDo.status === 1) {
		    	        statusCellContent = '<td class="bg-yellow-200">생성 완료</td>';
		    	    } else if (toDo.status === 2) {
		    	        statusCellContent = '<td class="bg-red-200">작업중</td>';
		    	    } else {
		    	        statusCellContent = '<td></td>';
		    	    }

		    	    tableContent += "<tr><td>" + (index + 1) + "</td><td class='bg-gray-100 font-normal'>" + toDo.startDate.substring(0, 10) + "</td><td class='bg-gray-100 font-normal'>" + toDo.endDate.substring(0, 10) + "</td><td class='bg-gray-100 font-normal'>" + toDo.projectName + "</td><td class='bg-gray-100'>" + toDo.title + "</td>" + statusCellContent + "</tr>";
		    	});

		    	// 이제 tableContent를 DOM에 삽입할 수 있습니다.
		    	$("#tableBodyId").html(tableContent);
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
<input type="hidden" id="member_id" value="${member_id }"/>
<input type="hidden" id="project_id" value="${project_id }"/>

    <div class="card w-full h-full bg-base-100 shadow-xl">
      <div class="card-body">
        <h2 class="text-3xl font-bold">${memberName }</h2>
		        <!-- 정렬 옵션 선택 -->
		<select class="select select-ghost w-full max-w-xs" id="sortSelect" onchange="handleSortChange()">
		     <option disabled selected>정렬</option>
		    <option value="startDateAscMember">시작 빠른순</option>
		    <option value="startDateDescMembrer">시작 느린순</option>
		    <option value="endDateAscMember">마감 빠른순</option>
		    <option value="endDateDescMember">마감 느린순</option>
		</select>
		        
        <div class="overflow-x-auto shadow-xl">
  <table class="table w-full horizontal-border-only">
  <colgroup>
  						<col width="50"/>
						<col width="50"/>
						<col width="50"/>
						<col width="50"/>
						<col width="50"/>
						<col width="50"/>
					</colgroup>
    <!-- head -->
    <thead>
      <tr>
       <th class="bg-blue-300 text-lg text-white">번호</th>
       <th class="bg-blue-300 text-lg text-white">시작일</th>
       <th class="bg-blue-300 text-lg text-white">마감일</th>
      <th class="bg-blue-300 text-lg text-white">프로젝트명</th>
        <th class="bg-blue-300 text-lg text-white">작업명</th>
        <th class="bg-blue-300 text-lg text-white">진행도</th>
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
    			<td class="bg-yellow-200">생성 완료</td>
    		</c:when>
    		<c:when test="${toDo.status == 2}">
    		    <td class="bg-red-200">작업중</td>
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
 
<%@ include file="../common/foot.jsp" %>
