<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="작업 조회" />
<%@ include file="../common/head.jsp" %>
<script>
	function handleSortChange() {
	    var selectedOption = document.getElementById('sortSelect').value;
	
	    switch (selectedOption) {
	        case 'startDateAsc':
	            sortByStartDateAsc();
	            break;
	        case 'startDateDesc':
	            sortByStartDateDesc();
	            break;
	        case 'endDateAsc':
	            sortByEndDateAsc();
	            break;
	        case 'endDateDesc':
	            sortByEndDateDesc();
	            break;
	    }
	}
	
	function sortByStartDateAsc() {

		$.get('sortByStartDateAsc', function(data) {
		    if (data.success) {
		        var tableContent = "";

		        data.data1.forEach(function(toDo, index) {
		            var statusCellContent = "";

		            if (toDo.status === 1) {
		                statusCellContent = '<td class="bg-yellow-200"><button class="statusChangeBtn" data-id="' + toDo.id + '" data-new-status="2">생성 완료</button></td>';
		            } else if (toDo.status === 2) {
		                statusCellContent = '<td class="bg-red-200"><button class="statusChangeBtn" data-id="' + toDo.id + '" data-new-status="3">작업중</button></td>';
		            } else {
		                statusCellContent = '<td></td>';
		            }

		            tableContent += '<tr><td>' + (index + 1) + '</td><td class="bg-gray-100 font-normal">' + toDo.startDate.substring(0, 10) + '</td><td class="bg-gray-100 font-normal">' + toDo.endDate.substring(0, 10) + '</td><td class="bg-gray-100 font-normal">' + toDo.projectName + '</td><td class="bg-gray-100">' + toDo.title + '</td>' + statusCellContent + '</tr>';
		        });

		        $("#tableBodyId").html(tableContent);
		    } else {
		        alert(data.msg);
		    }
		}, 'json');



	}


	
	function sortByStartDateDesc() {
		$.get('sortByStartDateDesc', function(data) {
		    if (data.success) {
		        var tableContent = "";

		        data.data1.forEach(function(toDo, index) {
		            var statusCellContent = "";

		            if (toDo.status === 1) {
		                statusCellContent = '<td class="bg-yellow-200"><button class="statusChangeBtn" data-id="' + toDo.id + '" data-new-status="2">생성 완료</button></td>';
		            } else if (toDo.status === 2) {
		                statusCellContent = '<td class="bg-red-200"><button class="statusChangeBtn" data-id="' + toDo.id + '" data-new-status="3">작업중</button></td>';
		            } else {
		                statusCellContent = '<td></td>';
		            }

		            tableContent += '<tr><td>' + (index + 1) + '</td><td class="bg-gray-100 font-normal">' + toDo.startDate.substring(0, 10) + '</td><td class="bg-gray-100 font-normal">' + toDo.endDate.substring(0, 10) + '</td><td class="bg-gray-100 font-normal">' + toDo.projectName + '</td><td class="bg-gray-100">' + toDo.title + '</td>' + statusCellContent + '</tr>';
		        });

		        $("#tableBodyId").html(tableContent);
		    } else {
		        alert(data.msg);
		    }
		}, 'json');

	}
	
	function sortByEndDateAsc() {
		$.get('sortByEndDateAsc', function(data) {
		    if (data.success) {
		        var tableContent = "";

		        data.data1.forEach(function(toDo, index) {
		            var statusCellContent = "";

		            if (toDo.status === 1) {
		                statusCellContent = '<td class="bg-yellow-200"><button class="statusChangeBtn" data-id="' + toDo.id + '" data-new-status="2">생성 완료</button></td>';
		            } else if (toDo.status === 2) {
		                statusCellContent = '<td class="bg-red-200"><button class="statusChangeBtn" data-id="' + toDo.id + '" data-new-status="3">작업중</button></td>';
		            } else {
		                statusCellContent = '<td></td>';
		            }

		            tableContent += '<tr><td>' + (index + 1) + '</td><td class="bg-gray-100 font-normal">' + toDo.startDate.substring(0, 10) + '</td><td class="bg-gray-100 font-normal">' + toDo.endDate.substring(0, 10) + '</td><td class="bg-gray-100 font-normal">' + toDo.projectName + '</td><td class="bg-gray-100">' + toDo.title + '</td>' + statusCellContent + '</tr>';
		        });

		        $("#tableBodyId").html(tableContent);
		    } else {
		        alert(data.msg);
		    }
		}, 'json');

	}
	
	function sortByEndDateDesc() {
		$.get('sortByEndDateDesc', function(data) {
		    if (data.success) {
		        var tableContent = "";

		        data.data1.forEach(function(toDo, index) {
		            var statusCellContent = "";

		            if (toDo.status === 1) {
		                statusCellContent = '<td class="bg-yellow-200"><button class="statusChangeBtn" data-id="' + toDo.id + '" data-new-status="2">생성 완료</button></td>';
		            } else if (toDo.status === 2) {
		                statusCellContent = '<td class="bg-red-200"><button class="statusChangeBtn" data-id="' + toDo.id + '" data-new-status="3">작업중</button></td>';
		            } else {
		                statusCellContent = '<td></td>';
		            }

		            tableContent += '<tr><td>' + (index + 1) + '</td><td class="bg-gray-100 font-normal">' + toDo.startDate.substring(0, 10) + '</td><td class="bg-gray-100 font-normal">' + toDo.endDate.substring(0, 10) + '</td><td class="bg-gray-100 font-normal">' + toDo.projectName + '</td><td class="bg-gray-100">' + toDo.title + '</td>' + statusCellContent + '</tr>';
		        });

		        $("#tableBodyId").html(tableContent);
		    } else {
		        alert(data.msg);
		    }
		}, 'json');

	}
	
	// 상태 변경 버튼에 대한 이벤트 리스너 추가
	$(document).on('click', '.statusChangeBtn', function() {
	    var toDoId = $(this).data('id'); // 버튼에서 toDo ID 가져오기
	    var newStatus = $(this).data('new-status'); // 새 상태 값 가져오기
         console.log(toDoId);
	     console.log(newStatus);
	    // AJAX 요청을 통해 서버에 상태 변경 요청
	    $.get('changeStatus', {
	    	toDoId: toDoId,
	    	newStatus: newStatus,	
	    },function(data) {
		    if (data.success) {
					alert(data.msg);
					location.reload(true);
		    } else {
		    }
		}, 'json');
	   
	});

	
	
  
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
<input type="checkbox" id="my_modal_6" class="modal-toggle" />
<div class="modal" role="dialog">
  <div class="modal-box">
  <div class="flex justify-evenly">
    <button class="btn btn-warning" value="1">생성 완료</button>
    <button class="btn btn-error" value="2">진행 중</button>
    <button class="btn btn-success" value="3">작업 완료</button>
   </div>
    <div class="modal-action">
      <label for="my_modal_6" class="btn">Close!</label>
    </div>
  </div>
</div>

<div class="work-grid-container">
  <div class="item1">
    <div class="card w-full h-full bg-base-100 shadow-xl">
      <div class="card-body">
        <h2 class="text-3xl font-bold">To-Do</h2>
		        <!-- 정렬 옵션 선택 -->
		<select class="select select-ghost w-full max-w-xs" id="sortSelect" onchange="handleSortChange()">
		     <option disabled selected>정렬</option>
		    <option value="startDateAsc">시작 빠른순</option>
		    <option value="startDateDesc">시작 느린순</option>
		    <option value="endDateAsc">마감 빠른순</option>
		    <option value="endDateDesc">마감 느린순</option>
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
        <h2 class="text-3xl font-bold">Done</h2>
           <div class="overflow-x-auto shadow-xl text-xl">
  <table class="table w-full horizontal-border-only">
    <colgroup>
    					<col width="50"/>
						<col width="150"/>
						<col width="100"/>
						<col width="50"/>
					</colgroup>
    <thead>
      <tr>
      <th class="bg-blue-300 text-lg text-white">번호</th>
      <th class="bg-blue-300 text-lg text-white">프로젝트명</th>
        <th class="bg-blue-300 text-lg text-white">작업명</th>
        <th class="bg-blue-300 text-lg text-white">진행도</th>
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
